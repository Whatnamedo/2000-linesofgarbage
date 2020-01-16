import java.util.*;

public class Hand {
	ArrayList<Card> cards = new ArrayList<Card>();  // stores all the cards of the hand
	private int totalValue = 0;  // total value of the hand
	boolean isDealer; // if the hand belongs to a dealer or a player
	private String handValue = ""; // string to store the cards, used in the toString method
	private String dealValue = "";
	private int temp = 0;
	private boolean show = false;
	private int numAces = 0;
	
	public void addCard(Card in) // adds card to the hand
	{
		if (isDealer && cards.size() == 0) // if the hand belongs to the dealer then the first card will remain hidden
		{
			handValue += "Card: ???\n\t";
			dealValue += in + "\n\t";
		}
		else // if the hand belongs to the player or the dealer already has a card, the card will be added to a string variable
		{
			handValue += in + "\n\t";
			dealValue += in + "\n\t";
		}
		cards.add(in); // adds the card to the array
		if (in.getRank() == 11 || in.getRank() == 12 || in.getRank() ==13)  // if the card is a jack, queen, king then the value of the card will be 10
		{
			totalValue += 10;
			temp += 10;
		}
		else
		{
			totalValue += in.getRank();
			temp += in.getRank(); // finds the numerical value of the card and adds it to the total value of the hand
		}		
		if (in.getRank() == 1) 
		{
			totalValue += 10;
			temp += 10;
			numAces ++;
		}
	}
	
	public int getNumAces()
	{
		return numAces;
	}
	
	public void setNumAces(int n)
	{
		numAces = n;
	}
	
	public void subtractAce()
	{
		numAces --;
	}
	
	public int getSize()
	{
		return cards.size();
	}
	
	public String getHandValue() // returns the value of handValue
	{
		return handValue;
	}
	
	public int getTotalValue() // returns the value of totalValue
	{
		return totalValue;
	}
	
	public void setTotalValue(int n)
	{
		totalValue = n;
	}
	
	public void subtractTotalValue()
	{
	     totalValue -= 10;
	     if (cards.size() == 1)
	     {
		temp -= 10;
	     }
	     numAces --;
	}
	
	public void show()
	{
		show = true;
	}
	
	public boolean getShow()
	{
		return show;
	}
	
	public Hand (boolean d) // constructor
	{
		isDealer = d;
	}
	
	public String toString() // toStringn method
	{
		if (!isDealer) // if the hand belongs to the player then it will display all cards in the hand
		{
			return ("Current Total: " + totalValue);
		}
		if (show)
		{
			return ("Current Total: " + totalValue);
		}
		return ("Current Total: " + (totalValue-temp));
	}    
}
