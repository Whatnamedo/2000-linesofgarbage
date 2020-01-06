import java.util.*;

public class Deck {
	ArrayList<Card> cards = new ArrayList<Card>();  // stores all the cards of the deck
	public int deckSize = 0;  // monitors the size of the deck
	
	public Card draw() // removes the top card of the deck and returns its value
	{
		return cards.remove(cards.size()-1); // removes the top card of the deck and returns its value
	}
	
	public void shuffle()  // shuffles the deck
	{
		Card temp;  // variable to help in swapping two cards
		int t;  // stores the random value that selects the card
		int x;  // stores the random value that selects the card that t will be replaced with
		int n = deckSize - 1;  // stores deckSize - 1 which is the length of the ArrayList "cards"
		Random rand = new Random();  
		for (int i = 0; i <= 1040; i++)  // for loop selecting how many times cards are swapped
		{                               // values for t and x are selected
			t = rand.nextInt(n+1);  
			x = rand.nextInt(n/2);
			while (t - x < 0 && t + x > n)  // ensures that the card t is replacing is within range of the ArrayList
			{
				x = rand.nextInt(n/2);
			}
			if (t + x > n) // shuffles cards closer to the bottom of the deck (1 card is shuffled)
			{	
				temp = cards.get(t-x);
				cards.set(t-x,cards.get(t));
				cards.set(t,temp);
			}
			else // shuffles the rest of the cards (1 card is shuffled)
			{
				temp = cards.get(t+x);
				cards.set(t+x,cards.get(t));
				cards.set(t,temp);
			}
		}
	}

	public Deck() // object constructor
	{
		for (int i = 1; i <= 4; i++) 
		{
			for (int j = 1; j <= 13; j++) 
			{
				cards.add(new Card(j, i));
				deckSize++;
			}
		}
	}
}