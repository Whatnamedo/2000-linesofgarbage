import java.util.*;

public class Hand {
	private ArrayList<Card> hand = new ArrayList<Card>();
	private int handLength = 0;
	private int pokerHand = 0;
	private boolean computer;
	public Hand (boolean i)
	{
		computer = i;
	}
	public void addCard(Card i)
	{
		hand.add(i);
		handLength++;
		if (handLength == 2)
		{
			if ((hand.get(0)).getRank() == (hand.get(1).getRank()))
			{
				pokerHand = 9;
			}
			else
			{
				pokerHand = 10;
			}
		}
	}
	public int getpokerHand()
	{
		return pokerHand;
	}
	public ArrayList<Card> getHand()
	{
		return hand;
	}
	public String toString()
	{
		String s = "";
		if (computer == true)
		{
			s += "Computer's Hand:\n\t";
		}
		else
		{
			s += "Your Hand:\n\t";
		}
		s += hand.get(0) + "\n\t";
		s += hand.get(1) + "\n\t";
		return s;
	}
}
