package BlackJack_Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.MediaTracker;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class BlackJackMain implements MouseListener{
	private int imageNo = 0;
	private JButton play = new JButton("Play BlackJack");
	private JButton info = new JButton("How to Play");
	private JButton quit = new JButton("Quit");
	private JButton hit = new JButton("HIT");
	private JButton Double = new JButton("DOUBLE");
	private JButton stand = new JButton("STAND");
	private JButton betton = new JButton("Bet");
	private JButton backstart = new JButton("Back to Main Page");
	private JFrame startframe = new JFrame("BlackJack");
	private JFrame frame = new JFrame("BlackJack");
	private JFrame betframe = new JFrame("BlackJack");
	private JFrame infoframe = new JFrame("BlackJack");
	private JPanel game = new JPanel();
	private JPanel start = new JPanel();
	private JPanel bet = new JPanel();
	private ImageIcon[] cards = new ImageIcon[52];
	private ImageIcon[] background = new ImageIcon[2];
	private ImageIcon[] deck = new ImageIcon[1];
	private ImageIcon[] back = new ImageIcon[1];
	private ImageIcon[] arrow = new ImageIcon[2];
	private JLabel decks;
	private JLabel table1;
	private JLabel table2;
	private JLabel table3;
	private JLabel table4;
	private JLabel table5;
	private JLabel table6;
	private JLabel table7;
	private JLabel table8;
	private JLabel table9;
	private JLabel backLabel;
	private JLabel backMain;
	private JLabel backBet;
	private JLabel deal1;
	private JLabel deal2;
	//
	private JLabel deal3;
	private JLabel deal4;
	private JLabel deal5;
	private JLabel deal6;
	private JLabel deal7;
	private JLabel deal8;
	private JLabel deal9;
	//
	private JLabel turn;
	private JLabel balance = new JLabel("Balance: $" + Blackjack.bettingAmount);
	private JLabel bamount = new JLabel("Bet: $" + Blackjack.bet);
	private JLabel balances = new JLabel("Balance: $" + Blackjack.bettingAmount);
	private JLabel bethere = new JLabel("How much would you like to bet?");
	private JLabel value = new JLabel("Total Hand Value: ");
	private JLabel dvalue = new JLabel("Dealer Hand Value: ");
	private JTextField in = new JTextField();
	private Deck d = new Deck();
	private Hand playerHand = new Hand(false);
	private Hand dealerHand = new Hand(true);
	public BlackJackMain()
	{
		hit.addMouseListener(this);
		Double.addMouseListener(this);
		stand.addMouseListener(this);
		play.addMouseListener(this);
		info.addMouseListener(this);
		quit.addMouseListener(this);
		betton.addMouseListener(this);
		backstart.addMouseListener(this);
		start.setPreferredSize(new Dimension(300,300));
		start.setLayout (new GridLayout(3,0));
		game.setPreferredSize(new Dimension(1000,600));
		game.setLayout(null);
		bet.setPreferredSize(new Dimension(1000,600));
		bet.setLayout(null);
		arrow[0] = new ImageIcon("UpArrow.png");
		arrow[1] = new ImageIcon("DownArrow1.png");
		background[0] = new ImageIcon("blueback1.jpg");
		back[0] = new ImageIcon("back.png");
		deck[0] = new ImageIcon("deck1.png");
		cards[0] = new ImageIcon("01s.gif");
		cards[1] = new ImageIcon("01h.gif");
		cards[2] = new ImageIcon("01c.gif");
		cards[3] = new ImageIcon("01d.gif");
		cards[4] = new ImageIcon("02s.gif");
		cards[5] = new ImageIcon("02h.gif");
		cards[6] = new ImageIcon("02c.gif");
		cards[7] = new ImageIcon("02d.gif");
		cards[8] = new ImageIcon("03s.gif");
		cards[9] = new ImageIcon("03h.gif");
		cards[10] = new ImageIcon("03c.gif");
		cards[11] = new ImageIcon("03d.gif");
		cards[12] = new ImageIcon("04s.gif");
		cards[13] = new ImageIcon("04h.gif");
		cards[14] = new ImageIcon("04c.gif");
		cards[15] = new ImageIcon("04d.gif");
		cards[16] = new ImageIcon("05s.gif");
		cards[17] = new ImageIcon("05h.gif");
		cards[18] = new ImageIcon("05c.gif");
		cards[19] = new ImageIcon("05d.gif");
		cards[20] = new ImageIcon("06s.gif");
		cards[21] = new ImageIcon("06h.gif");
		cards[22] = new ImageIcon("06c.gif");
		cards[23] = new ImageIcon("06d.gif");
		cards[24] = new ImageIcon("07s.gif");
		cards[25] = new ImageIcon("07h.gif");
		cards[26] = new ImageIcon("07c.gif");
		cards[27] = new ImageIcon("07d.gif");
		cards[28] = new ImageIcon("08s.gif");
		cards[29] = new ImageIcon("08h.gif");
		cards[30] = new ImageIcon("08c.gif");
		cards[31] = new ImageIcon("08d.gif");
		cards[32] = new ImageIcon("09s.gif");
		cards[33] = new ImageIcon("09h.gif");
		cards[34] = new ImageIcon("09c.gif");
		cards[35] = new ImageIcon("09d.gif");
		cards[36] = new ImageIcon("10s.gif");
		cards[37] = new ImageIcon("10h.gif");
		cards[38] = new ImageIcon("10c.gif");
		cards[39] = new ImageIcon("10d.gif");
		cards[40] = new ImageIcon("11s.gif");
		cards[41] = new ImageIcon("11h.gif");
		cards[42] = new ImageIcon("11c.gif");
		cards[43] = new ImageIcon("11d.gif");
		cards[44] = new ImageIcon("12s.gif");
		cards[45] = new ImageIcon("12h.gif");
		cards[46] = new ImageIcon("12c.gif");
		cards[47] = new ImageIcon("12d.gif");
		cards[48] = new ImageIcon("13s.gif");
		cards[49] = new ImageIcon("13h.gif");
		cards[50] = new ImageIcon("13c.gif");
		cards[51] = new ImageIcon("13d.gif");
		backMain = new JLabel(background[0]);
		backMain.setOpaque(true);
		backMain.setBounds(0, 0, 1000, 600);
		backLabel = new JLabel(background[0]);
		backLabel.setOpaque(true);
		backLabel.setBounds(0, 0, 1000, 600);
		backBet = new JLabel(background[0]);
		backBet.setOpaque(true);
		backBet.setBounds(0, 0, 1000, 600);
		//
		table3 = new JLabel(cards[2]);
		table3.setOpaque(true);
		table3.setBounds(620,450,69,94);
		table3.setVisible(false);
		table4 = new JLabel(cards[3]);
		table4.setOpaque(true);
		table4.setBounds(700,450,69,94);
		table4.setVisible(false);
		table5 = new JLabel(cards[4]);
		table5.setOpaque(true);
		table5.setBounds(780,450,69,94);
		table5.setVisible(false);
		table6 = new JLabel(cards[5]);
		table6.setOpaque(true);
		table6.setBounds(860,450,69,94);
		table6.setVisible(false);
		table7 = new JLabel(cards[6]);
		table7.setOpaque(true);
		table7.setBounds(940,450,69,94);
		table7.setVisible(false);
		table8 = new JLabel(cards[7]);
		table8.setOpaque(true);
		table8.setBounds(1020,450,69,94);
		table8.setVisible(false);
		table9 = new JLabel(cards[8]);
		table9.setOpaque(true);
		table9.setBounds(1100,450,69,94);
		table9.setVisible(false);
		deal3 = new JLabel(cards[2]);
		deal3.setOpaque(true);
		deal3.setBounds(620,450,69,94);
		deal3.setVisible(false);
		deal4 = new JLabel(cards[3]);
		deal4.setOpaque(true);
		deal4.setBounds(700,450,69,94);
		deal4.setVisible(false);
		deal5 = new JLabel(cards[4]);
		deal5.setOpaque(true);
		deal5.setBounds(780,450,69,94);
		deal5.setVisible(false);
		deal6 = new JLabel(cards[5]);
		deal6.setOpaque(true);
		deal6.setBounds(860,450,69,94);
		deal6.setVisible(false);
		deal7 = new JLabel(cards[6]);
		deal7.setOpaque(true);
		deal7.setBounds(940,450,69,94);
		deal7.setVisible(false);
		deal8 = new JLabel(cards[7]);
		deal8.setOpaque(true);
		deal8.setBounds(1020,450,69,94);
		deal8.setVisible(false);
		deal9 = new JLabel(cards[8]);
		deal9.setOpaque(true);
		deal9.setBounds(1100,450,69,94);
		deal9.setVisible(false);
		//
		decks = new JLabel(deck[0]);
		decks.setOpaque(true);
		decks.setBounds(500, 200, 69, 94);
		deal1 = new JLabel(back[0]);
		deal1.setOpaque(true);
		deal1.setBounds(460,31,69,94);
		turn = new JLabel(arrow[1]);
		turn.setBounds(65, 250, 50, 100);
		balance.setForeground(Color.white);
		balance.setBounds(10, 10, 250, 15);
		bamount.setForeground(Color.cyan);
		bamount.setBounds(10, 30, 250, 15);
		bethere.setForeground(Color.white);
		bethere.setBounds(397, 210, 250, 50);
		bethere.setFont(new Font("Monospace", Font.PLAIN, 15));
		balances.setForeground(Color.white);
		balances.setBounds(10,10,250,15);
		balances.setFont(new Font("Monospace", Font.PLAIN, 15));
		hit.setBounds(210, 350, 150, 50);
		Double.setBounds(460, 350, 150, 50);
		stand.setBounds(710, 350, 150, 50);
		in.setBounds(400, 250, 200, 50);
		betton.setBounds(450, 325, 100, 25);
		bet.add(in);
		bet.add(betton);
		bet.add(bethere);
		bet.add(balances);
		bet.add(backBet);
		start.add(play);
		start.add(info);
		start.add(quit);
		game.add(turn);
		game.add(balance);
		game.add(bamount);
		game.add(decks);
		game.add(deal1);
		game.add(hit);
		game.add(Double);
		game.add(stand);
		startframe.add(start);
		startframe.pack();
		startframe.setVisible(true);
		startframe.setLocation(800,300);
	}
	
	public void mouseClicked (MouseEvent e)
    {
		if (e.getSource() == hit)
		{
			Card ind = d.draw();
			playerHand.addCard(ind);
			Double.setVisible(false);

			int index = playerHand.getSize();
			if (index == 3)
			{
				table3.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				value.setText("Hand Value: " + playerHand);
				//
				table1.setBounds(420,450,69,94);
				table2.setBounds(500,450,69,94);
				table3.setBounds(580,450,69,94);
				//
				table3.setVisible(true);
			}
			else if (index == 4)
			{
				table4.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				value.setText("Hand Value: " + playerHand);
				//
				table1.setBounds(380,450,69,94);
				table2.setBounds(460,450,69,94);
				table3.setBounds(540,450,69,94);
				table4.setBounds(620,450,69,94);
				//
				table4.setVisible(true);
			}
			else if (index == 5)
			{
				table5.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				table5.setVisible(true);
				value.setText("Hand Value: " + playerHand);
				//
				table1.setBounds(340,450,69,94);
				table2.setBounds(420,450,69,94);
				table3.setBounds(500,450,69,94);
				table4.setBounds(580,450,69,94);
				table5.setBounds(660,450,69,94);
				//
			}
			else if (index == 6)
			{
				table6.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				table6.setVisible(true);
				value.setText("Hand Value: " + playerHand);
				//
				table1.setBounds(300,450,69,94);
				table2.setBounds(380,450,69,94);
				table3.setBounds(460,450,69,94);
				table4.setBounds(540,450,69,94);
				table5.setBounds(620,450,69,94);
				table6.setBounds(700,450,69,94);
				//
			}
			else if (index == 7)
			{
				table7.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				table7.setVisible(true);
				value.setText("Hand Value: " + playerHand);
				//
				table1.setBounds(260,450,69,94);
				table2.setBounds(340,450,69,94);
				table3.setBounds(420,450,69,94);
				table4.setBounds(500,450,69,94);
				table5.setBounds(580,450,69,94);
				table6.setBounds(660,450,69,94);
				table7.setBounds(740,450,69,94);
				//
			}
			else if (index == 8)
			{
				table8.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				table8.setVisible(true);
				value.setText("Hand Value: " + playerHand);
				//
				table1.setBounds(220,450,69,94);
				table2.setBounds(300,450,69,94);
				table3.setBounds(380,450,69,94);
				table4.setBounds(460,450,69,94);
				table5.setBounds(540,450,69,94);
				table6.setBounds(620,450,69,94);
				table7.setBounds(700,450,69,94);
				table8.setBounds(780,450,69,94);
				//
			}
			else if (index == 9)
			{
				table9.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				table9.setVisible(true);
				value.setText("Hand Value: " + playerHand);
				//
				table1.setBounds(180,450,69,94);
				table2.setBounds(260,450,69,94);
				table3.setBounds(340,450,69,94);
				table4.setBounds(420,450,69,94);
				table5.setBounds(500,450,69,94);
				table6.setBounds(580,450,69,94);
				table7.setBounds(660,450,69,94);
				table8.setBounds(740,450,69,94);
				table9.setBounds(820,450,69,94);
				//
			}
			if (playerHand.getTotalValue() > 21 && playerHand.getNumAces() > 0)
			{
				playerHand.subtractTotalValue();
				value.setText("Hand Value: " + playerHand);
			}
			else if (playerHand.getTotalValue () > 21)
			{
				// PLAYER LOSE	
			}
		}
		else if (e.getSource() == Double)
		{
			Blackjack.bettingAmount -= Blackjack.bet;
			Blackjack.bet *= 2;
			Card ind = d.draw();
			playerHand.addCard(ind);
			hit.setVisible(false);
			Double.setVisible(false);
			stand.setVisible(false);
			bamount.setText("Bet: $" + Blackjack.bet);
			balance.setText("Balance: $" + Blackjack.bettingAmount);
			
			int index = playerHand.getSize();
			if (index == 3)
			{
				table3.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				table3.setVisible(true);
				value.setText("Hand Value: " + playerHand);
				//
				table1.setBounds(420,450,69,94);
				table2.setBounds(500,450,69,94);
				table3.setBounds(580,450,69,94);
				//
			}
			if (playerHand.getTotalValue() > 21 && playerHand.getNumAces() > 0)
			{
				playerHand.subtractTotalValue();
				value.setText("Hand Value: " + playerHand);
			}
			else if (playerHand.getTotalValue () > 21)
			{
				// PLAYER LOSE	
			}
			// Player automatically stands after doubling down
		}
		else if (e.getSource() == stand)
		{
			hit.setVisible(false);
			Double.setVisible(false);
			stand.setVisible(false);
		}
		else if (e.getSource() == play)
		{
			startframe.setVisible(false);
			betframe.add(bet);
			betframe.pack();
			betframe.setVisible(true);
			betframe.setLocation(50,50);
		}
		else if (e.getSource() == info)
		{
			startframe.setVisible(false);
			JLabel HowToPlay, Objective, CardValues, Betting, PlayerTurn, DealerTurn, DoublingDown;
			backstart.setBounds(5,5,200,50);
			HowToPlay = new JLabel ();
			HowToPlay.setText("<html><b>How To Play</b><br></html>");
			HowToPlay.setFont(new Font("Monospace", Font.PLAIN, 25));
			HowToPlay.setBounds(425, 20, 1000, 35);
			HowToPlay.setForeground(Color.white);
			Objective = new JLabel ();
			Objective.setText("<html><b><u>Objective of the Game:</u></b><br>The player attempts to beat the dealer by getting a count as close to 21 as possible, without going over 21.</html>");
			Objective.setFont(new Font("Monospace", Font.PLAIN, 15));
			Objective.setBounds(15, 70, 1000, 40); 
			Objective.setForeground(Color.white);
			CardValues = new JLabel ();
			CardValues.setText("<html><b><u>Card Values/Scoring:</u></b><br>An ace may be worth 1 or 11, depending on the total value of the hand. Face cards are 10, and any other card holds the value of its number.</html>");
			CardValues.setFont(new Font("Monospace", Font.PLAIN, 15));
			CardValues.setBounds(15, 140, 1000, 40);
			CardValues.setForeground(Color.white);
			Betting = new JLabel ();
			Betting.setText("<html><b><u>Betting:</u></b><br>Before the dealing begins, each player places a bet in chips. The minimum bet is 1 chip, there is no maximum bet.</html>");
			Betting.setFont(new Font("Monospace", Font.PLAIN, 15));
			Betting.setBounds(15, 210, 1000, 40);
			Betting.setForeground(Color.white);
			PlayerTurn = new JLabel ();
			PlayerTurn.setText("<html><b><u>The Player’s Turn:</u></b><br>The player (you) must go first and decide whether to “stand” (not ask for another card) or “hit” (ask for another card in an attempt to get closer to 21, <br> or hit 21 exactly). If you receive a card total above 21, the hand is a “bust”. The player loses and the dealer collects the bet wagered. If a draw creates <br> a bust hand by counting an ace as an 11, the ace will be counted as a 1.</html>");
			PlayerTurn.setFont(new Font("Monospace", Font.PLAIN, 15));
			PlayerTurn.setBounds(15, 280, 1000, 80);
			PlayerTurn.setForeground(Color.white);
			DealerTurn = new JLabel ();
			DealerTurn.setText("<html><b><u>The Dealer’s Turn:</u></b><br>After the player’s turn, the dealer’s face-down card is turned up. If the total is 17 or more, the dealer will stand. If the total is 16 or under, the dealer will <br> hit. The dealer must continue to hit until their total is 17 or more. If the dealer has an ace and counting it as an 11 brings the total to 17 or more (but not over 21), the dealer will count the ace as 11 and stand.</html>");
			DealerTurn.setFont(new Font("Monospace", Font.PLAIN, 15));
			DealerTurn.setBounds(15, 390, 1000, 80);
			DealerTurn.setForeground(Color.white);
			DoublingDown = new JLabel ();
			DoublingDown.setText("<html><b><u>Doubling Down:</u></b><br>Another option available to the player is known as “double down”. When a player chooses to “double down”, they place a bet equal to the original bet <br> and the dealer deals them one card. Note that the dealer doesn’t have the option to “double down.</html>");
			DoublingDown.setFont(new Font("Monospace", Font.PLAIN, 15));
			DoublingDown.setBounds(15, 500, 1000, 60);
			DoublingDown.setForeground(Color.white);
			backMain.add(backstart);
			backMain.add(HowToPlay);
			backMain.add(Objective);
			backMain.add(CardValues);
			backMain.add(Betting);
			backMain.add(PlayerTurn);
			backMain.add(DealerTurn);
			backMain.add(DoublingDown);
			infoframe.add(backMain);
			infoframe.pack();
			infoframe.setLocation(50, 50);
			infoframe.setVisible(true);
		}
		else if (e.getSource() == quit)
		{
			startframe.setVisible(false);
			startframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		else if (e.getSource() == betton)
		{
			String out;
			out = in.getText();
			try
			{
				int x = Integer.parseInt(out);
				if (x > Blackjack.bettingAmount || x < 1)
				{
					bethere.setText("Invalid Input! How much would you like to bet?");
					bethere.setBounds(350, 210, 350, 50);
				}
				else
				{
					d = new Deck();
					playerHand = new Hand(false);
					dealerHand = new Hand(true);
					d.shuffle();
					
					Card ind = d.draw();
					playerHand.addCard(ind);
					table1 = new JLabel(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
					table1.setOpaque(true);
					//
					table1.setBounds(460,450,69,94);
					//
					ind = d.draw();
					playerHand.addCard(ind);
					table2 = new JLabel(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
					table2.setOpaque(true);
					//
					table2.setBounds(540,450,69,94);
					//
					ind = d.draw();
					dealerHand.addCard(ind);
					ind = d.draw();
					dealerHand.addCard(ind);
					deal2 = new JLabel(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
					deal2.setOpaque(true);
					deal2.setBounds(540,31,69,94);
					bethere.setText("How much would you like to bet");
					bethere.setBounds(397, 210, 250, 50);
					betframe.setVisible(false);
					int b = Integer.parseInt(out);
					Blackjack.bettingAmount -= b;
					Blackjack.bet = b;
					balance.setText("Balance: $" + Blackjack.bettingAmount);
					balance.setFont(new Font("Monospace", Font.PLAIN, 15));
					bamount.setText("Bet: $" + Blackjack.bet);
					bamount.setFont(new Font("Monospace", Font.PLAIN, 15));
					balances.setText("Balance: $" + Blackjack.bettingAmount);
					if (playerHand.getTotalValue() > 21 && playerHand.getNumAces() > 0)
					{
						playerHand.subtractTotalValue();
						value.setText("Hand Value: " + playerHand);
					}
					else
					{
						value.setText("Hand Value: " + playerHand);
					}
					value.setBounds(485, 400, 200, 50);
					value.setForeground(Color.white);
					value.setFont(new Font("Monospace", Font.PLAIN, 15));
					dvalue.setText("Dealer Hand Value: " + dealerHand);
					dvalue.setForeground(Color.white);
					dvalue.setBounds(460, 125, 200, 50);
					dvalue.setFont(new Font("Monospace", Font.PLAIN, 15));
					if (Blackjack.bettingAmount < Blackjack.bet && playerHand.getSize() < 3)
					{
						Double.setVisible(false);
					}
					game.add(table1);
					game.add(table2);
					game.add(table3);
					game.add(table4);
					game.add(table5);
					game.add(table6);
					game.add(table7);
					game.add(table8);
					game.add(table9);
					game.add(deal2);
					game.add(value);
					game.add(dvalue);
					game.add(backLabel);
					frame.add(game);
					frame.pack();
					frame.setVisible(true);
					frame.setLocation(50, 50);
				}
			}
			catch (NumberFormatException i)
			{
				bethere.setText("Invalid Input! How much would you like to bet?");
				bethere.setBounds(350, 210, 350, 50);
			}
		}
		else if (e.getSource() == backstart)
		{
			infoframe.setVisible(false);
			startframe.setVisible(true);
		}
    }
    
    public void mouseReleased (MouseEvent e)
    {
        
    }
    
    public void mouseEntered (MouseEvent e)
    {
    	
    }
    
    public void mouseExited (MouseEvent e)
    {
    	
    }
    
    public void mousePressed (MouseEvent e)
    {
        
    }
    
	public static void main(String[] args)
	{
		BlackJackMain game = new BlackJackMain();
	}
}
