/*
* This is completely untested, never before run.
* If this doesn't work, don't be surprised.
*/
import java.util.*;
public class Poker {
	private int balance = 2000;
	private int compBalance = 2000;
	private Hand playerHand = new Hand(false);
	private Hand compHand = new Hand(true);
	private Deck d = new Deck();
	private ArrayList<Card> table = new ArrayList<Card>();
	private int ante = 100;
	private Scanner n = new Scanner(System.in);
	private int response;
	private int raise;
	private int bet = 0;
	
	public Poker()
	{
		while(balance > 0 && compBalance > 0)
		{
			raise = 0;
			bet = 0;
			d = new Deck();
			d.shuffle();
			playerHand = new Hand(false);
			compHand = new Hand(true);
			playerHand.addCard(d.draw());
			playerHand.addCard(d.draw());
			compHand.addCard(d.draw());
			compHand.addCard(d.draw());
			balance -= ante;
			compBalance -= ante;
			bet += ante;
			System.out.print("Ante of $" + ante + " has been deducted\nWould you like to fold or raise?(0 for check, 1 for fold or 2 for raise.)");
			try
			{
				response = n.nextInt();
			}
			catch(NumberFormatException e)
			{
				while(true)
				{
					try
					{
						System.out.print("Please enter either 0 to check, 1 to fold or 2 to raise");
						response = n.nextInt();
						break;
					}
					catch (NumberFormatException i)
					{
					}
				}
			}
			if (response != 0 || response != 1 || response != 2)
			{
				while(true)
				{
					try
					{
						System.out.print("Please enter either 0 to check, 1 to fold or 2 to raise");
						response = n.nextInt();
						break;
					}
					catch (NumberFormatException i)
					{
					}
				}
			}
			if (response == 1)
			{
				continue;
			}
			else if (response == 2)
			{
				System.out.print("How much would you like to raise?(Enter 0 to cancel raise.)");
				try
				{
					raise = n.nextInt();
				}
				catch (NumberFormatException e)
				{
					while (true)
					{
						System.out.print("Please enter an amount to raise.(Enter 0 to cancel raise.)");
						try
						{
							raise = n.nextInt();
							break;
						}
						catch (NumberFormatException i)
						{
						}
					}
				}
				if (raise == 0)
				{
					System.out.println("Raise cancelled, you checked.");
				}
				else
				{
					bet += raise;
					System.out.println("You raised the bet $" + raise + ". The bet is now " + bet);
					raise = 0;
				}
			}
			System.out.println("You checked, dealer is drawing cards.");
			for(int i = 0; i < 3; i++)
			{
				table.add(d.draw());
			}
			for (Card x : table)
			{
				System.out.println(x);
			}
			System.out.print("Would you like to check to the ante, fold or raise?(0 for check, 1 for fold or 2 for raise.)");
			try
			{
				response = n.nextInt();
			}
			catch (NumberFormatException e)
			{
				
			}
		}
	}
}
