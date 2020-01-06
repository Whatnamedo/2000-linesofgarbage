public class Card {
	public static int Cards; // keeps track of how many total cards there are
	private int rank;
	private int suit;
	
	public int getRank() // gets the rank
	{
		return rank;
	}
	
	public int getSuit() // gets the suit
	{
		return suit;
	}
	
	public String rankString(int r) // converts the number representing the rank into a string (1 would turn into Ace)
	{
		if (r == 1)
		{
			return "Ace";
		}
		else if (r > 1 && r < 11)
		{
			return Integer.toString(r);
		}
		else if (r == 11)
		{
			return "Jack";
		}
		else if (r == 12)
		{
			return "Queen";
		}
		else if (r == 13)
		{
			return "King";
		}
		return "Error, rank is not 1-13!";
	}
	
	public String suitString(int s) // converts the number representing the suit into a string (1 would turn into Spades)
	{
		if (s == 1)
		{
			return "Spades";
		}
		else if (s == 2)
		{
			return "Hearts";
		}
		else if (s == 3)
		{
			return "Clubs";
		}
		else if (s == 4)
		{
			return "Diamonds";
		}
		return "Error, suit is not 1-4";
	}
	
	public Card(int r, int s) // object constructor
	{
		Cards ++;
		rank = r;
		suit = s;
	}
	
	public String toString() // return the card rank and suit
	{
		return ("Card: " + rankString(rank) + " of " + suitString(suit));
	}
}