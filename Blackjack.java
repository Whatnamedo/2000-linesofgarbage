import java.io.*;
import java.util.concurrent.TimeUnit;

public class Blackjack {
	
	static int bettingAmount = 10000; // amount of money the player has
	static int bet; // how much the player is betting on the hand
	static String str = ""; // used with BufferedReader to get player input
	
	public static void getBet(BufferedReader br) throws InterruptedException 
	{ // method to determine how much the player wants to bet
		System.out.println("Thank you for playing Black Jack!" + "\n" + "You have $" + bettingAmount + " to play!");
		System.out.print("How much would you like to bet? ");
		
		while (bet < 1 || bet > bettingAmount) // while loop which asks the player for a betting amount, invalid inputs result in the user
		{                                       // being prompted to enter a valid input
			try
			{
				str = br.readLine(); // reads the user's input
				bet = Integer.parseInt(str); // converts the string bet into an integer bet
				bettingAmount -= bet;
			}
			catch (NumberFormatException e)
			{
				
			}
			catch (IOException e)
			{
				
			}
			if (bet > 0 && bet < bettingAmount + 1) break; // will stop the loop when the bet is above zero and <= to the money the player has
			System.out.print("Invalid Input! How much would you like to bet? "); // keeps getting the bet until it is a valid bet
		}
		System.out.print("\n"); // prints a new line
		return; // used to keep track of how much money the player has
	}
	
	public static void hsloop(BufferedReader br, Deck deck, Hand playerHand, Hand dealerHand) throws InterruptedException
	{
		int turn = 0;
		boolean dd = false;
		while(true)
		{
			while (playerHand.getTotalValue() > 21 && playerHand.getNumAces() > 0) // if the player's hand is above 21 and he has an ace
			{
				playerHand.subtractTotalValue(); // remove 10 from the value of the hand
				System.out.println(playerHand);  // displays the new player hand that has 10 less in value
			}
			if (playerHand.getTotalValue() > 21) // if the player's hand is above 21 with no aces
			{
				TimeUnit.SECONDS.sleep(1); // pause for 1 second
				System.out.println("\nYour hand is busted!\nThe dealer has won this round!"); 
				TimeUnit.SECONDS.sleep(1); // pause for 1 second
				System.out.println("--------------------------");
				return; // betting Amount doesn't increase
			}
			if (!dd)
			{
				if (turn == 1 || bettingAmount < bet)
				{
					System.out.print("Would you like to hit or stand? ");
				}
				else
				{
					System.out.print("Would you like to hit, stand, or double down? ");
					turn ++;
				}
			}
			while (true) // hit or stand loop
			{
				try
				{
					str = br.readLine(); // reads the player's input
				}
				catch (IOException e)
				{
					
				}
				if (str.equals("hit")) // if the player decides to hit
				{
					playerHand.addCard(deck.draw()); // remove the top card from the deck and add it to the player's hand
					while (playerHand.getTotalValue() > 21 && playerHand.getNumAces() > 0) // if the player's hand is above 21 and he has an ace
					{
						System.out.println("\n" + playerHand); // display the player's hand
						TimeUnit.SECONDS.sleep(2); // pause for 2 seconds
						playerHand.subtractTotalValue(); // remove 10 from the value of the hand
						break;
					}
					System.out.println("\n" + playerHand); // display the player's hand
					break; // stop the loop asking if the player wants to hit or stand
				}
				if (turn == 1 &&(str.equals("double down") || str.equals("dd"))) // if the player decides to double down
				{
					bettingAmount -= bet;
					bet = bet * 2;
					dd = true;
					playerHand.addCard(deck.draw()); // remove the top card from the deck and add it to the player's hand
					while (playerHand.getTotalValue() > 21 && playerHand.getNumAces() > 0) // if the player's hand is above 21 and he has an ace
					{
						System.out.println("\n" + playerHand); // display the player's hand
						TimeUnit.SECONDS.sleep(2); // pause for 2 seconds
						playerHand.subtractTotalValue(); // remove 10 from the value of the hand
						break;
					}
					System.out.println("\n" + playerHand); // display the player's hand
					TimeUnit.SECONDS.sleep(2); // pause for 2 seconds
				}
				if (turn == 1 && (str.equals("double down") || str.equals("dd")))
				{
					while (playerHand.getTotalValue() > 21 && playerHand.getNumAces() > 0) // if the player's hand is above 21 and he has an ace
					{
						System.out.println("\n" + playerHand); // display the player's hand
						TimeUnit.SECONDS.sleep(2); // pause for 2 seconds
						playerHand.subtractTotalValue(); // remove 10 from the value of the hand
						break;
					}
					if (playerHand.getTotalValue() > 21) // if the player's hand is above 21 with no aces
					{
						TimeUnit.SECONDS.sleep(1); // pause for 1 second
						System.out.println("\nYour hand is busted!\nThe dealer has won this round!"); 
						TimeUnit.SECONDS.sleep(1); // pause for 1 second
						System.out.println("--------------------------");
						return; //player loses whatever he bet
					}
				}
				if (str.equals("stand") || turn == 1 && (str.equals("double down") || str.equals("dd"))) // if the player decides to stand
				{
					System.out.println("\nDealers turn:");
					if (dealerHand.getShow() == false) // reveals the dealers first card
					{
						dealerHand.show(); // changes a variable in the dealers hand so that the first card will be visible
						System.out.println(dealerHand); // displays the dealers full hand
						TimeUnit.SECONDS.sleep(1); // pause for 1 seconds
					}
					while (true) // dealers turn loop
					{
						while (dealerHand.getTotalValue() > 21 && dealerHand.getNumAces() > 0) // if the dealer's hand is above 21 and he has an ace
						{
							dealerHand.subtractTotalValue(); // remove 10 from the value of the hand
							System.out.println(dealerHand);  // output the dealer's hand
						}
						
						if (dealerHand.getTotalValue() == playerHand.getTotalValue() && dealerHand.getTotalValue() > 16) // if the dealer and the player both have the same card
						{
							TimeUnit.SECONDS.sleep(1); // pause for 1 second
							System.out.println("\nThe dealer has decided to STAND");
							TimeUnit.SECONDS.sleep(1); // pause for 1 second
							System.out.println("Its a draw! Bets will be refunded.\n--------------------------");
							TimeUnit.SECONDS.sleep(1); // pause for 1 second
							bettingAmount += (2*bet);
							return; // betting Amount increases by bet
						}
						
						if (dealerHand.getTotalValue() > playerHand.getTotalValue() && dealerHand.getTotalValue() > 16) // if the dealer's hand is greater than the player's hand
						{
							TimeUnit.SECONDS.sleep(1); // pause for 1 second
							System.out.println("\nThe dealer has decided to STAND\n");
							TimeUnit.SECONDS.sleep(1); // pause for 1 second
							System.out.println("The dealer has won the round!\n--------------------------");
							TimeUnit.SECONDS.sleep(1); // pause for 1 seconds
							return; //player loses whatever he bet
						}
						
						else if (dealerHand.getTotalValue() > 16) // if the dealer's hand is greater than the player's hand
						{
							TimeUnit.SECONDS.sleep(1); // pause for 1 second
							System.out.println("\nThe dealer has decided to STAND");
							TimeUnit.SECONDS.sleep(1); // pause for 1 second
							System.out.println("The dealer's hand has less points than yours!\nCongratulations, you win!\n--------------------------");
							TimeUnit.SECONDS.sleep(1); // pause for 1 seconds
							bettingAmount += 2*bet;
							return ; // player earns double what they bet ($10,000 with a $500 bet will now be $10,500)
						}
						
						if (dealerHand.getTotalValue() < 17) // if the dealers total is less than 17
						{
							System.out.println("\nThe dealer has decided to HIT\n");
							TimeUnit.SECONDS.sleep(1); // pause for 1 second
							dealerHand.addCard(deck.draw()); // remove a card from the deck and add it to the dealer's hand
							System.out.println(dealerHand);
							TimeUnit.SECONDS.sleep(1); // pause for 1 seconds
						}
						
						while (dealerHand.getTotalValue() > 21 && dealerHand.getNumAces() > 0) // if the dealer's hand is above 21 and he has an ace
						{
							dealerHand.subtractTotalValue(); // remove 10 from the value of the hand
							System.out.println(dealerHand);  // output the dealer's hand
							TimeUnit.SECONDS.sleep(1); // pause for 1 seconds
						}
						
						if (dealerHand.getTotalValue() > 21) // if the dealer busts/ player wins the round
						{
							TimeUnit.SECONDS.sleep(1); // pause for 1 second
							System.out.println("\nThe dealer's hand is busted!\nCongratulations, you win!\n--------------------------");
							TimeUnit.SECONDS.sleep(1); // pause for 1 seconds
							bettingAmount += 2*bet;
							return; //player gains double their bet
						}
						
						if (dealerHand.getTotalValue() > playerHand.getTotalValue() && dealerHand.getTotalValue() > 16) // if the dealer's hand is greater than the player's hand
						{
							TimeUnit.SECONDS.sleep(1); // pause for 1 second
							System.out.println("\nThe dealer has decided to STAND");
							TimeUnit.SECONDS.sleep(1); // pause for 1 second
							System.out.println("The dealer has won the round!\n--------------------------");
							TimeUnit.SECONDS.sleep(1); // pause for 1 seconds
							return; //player loses whatever he bet
						}
					}
				}
				if (!(str.equals("stand") || str.equals("hit"))) // if the player didn't input either hit or stand it will ask for input again
				{
					System.out.print("Invalid Input! Would you like to hit or stand?");
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException // main code
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // used to read input
			
		while (bettingAmount > 0) // while the player has money
		{
			bet = -1; 
			Deck deck = new Deck(); // creates a deck
			Hand playerHand = new Hand(false); // creates a hand for the player
			Hand dealerHand = new Hand(true); // creates a hand for the dealer
			getBet(br);
			
			deck.shuffle(); // shuffles the deck
			playerHand.addCard(deck.draw()); // draws a card from the top of the deck and adds it to the player's hand
			playerHand.addCard(deck.draw()); // draws a card from the top of the deck and adds it to the player's hand
			
			System.out.println(playerHand); // displays the player's hand
			
			dealerHand.addCard(deck.draw()); // draws a card from the top of the deck and adds it to the dealer's hand
			dealerHand.addCard(deck.draw()); // draws a card from the top of the deck and adds it to the dealer's hand
			
			System.out.println(dealerHand); // displays the player's hand
			hsloop(br, deck, playerHand, dealerHand); // player's turn (hit, stand) --> dealer's turn

		}
		System.out.println("You have ran out of money, you lose!"); // if bettingAmount is <= 0 then the player loses and its game over
	}
}
