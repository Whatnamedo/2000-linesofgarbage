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
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class BlackJackMain implements MouseListener{
	private JButton play = new JButton("Play BlackJack");
	private JButton info = new JButton("How to Play");
	private JButton quit = new JButton("Quit");
	private JButton hit = new JButton("HIT");
	private JButton Double = new JButton("DOUBLE");
	private JButton stand = new JButton("STAND");
	private JButton betton = new JButton("Bet");
	private JButton backstart = new JButton("Back to Main Page");
	private JButton bettons = new JButton("Bet");	
	private JButton cashout = new JButton("Cash Out");
	private JButton cont = new JButton("Continue");
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
	private JLabel deal3;
	private JLabel deal4;
	private JLabel deal5;
	private JLabel deal6;
	private JLabel deal7;
	private JLabel deal8;
	private JLabel deal9;
	private Card hold;
	private JLabel turn;
	private JLabel balance = new JLabel("Balance: $" + Blackjack.bettingAmount);
	private JLabel bamount = new JLabel("Bet: $" + Blackjack.bet);
	private JLabel balances = new JLabel("Balance: $" + Blackjack.bettingAmount);
	private JLabel bethere = new JLabel("How much would you like to bet?");
	private JLabel value = new JLabel("Total Hand Value: ");
	private JLabel dvalue = new JLabel("Dealer Hand Value: ");
	private JLabel better = new JLabel("How much would you like to bet?");
	private JTextField in = new JTextField();
	private JTextField newbet = new JTextField();	
	private Deck d = new Deck();
	private Hand playerHand = new Hand(false);
	private Hand dealerHand = new Hand(true);
	private int betamount = 0;
	public BlackJackMain()
	{
		bettons.addMouseListener(this);	
		hit.addMouseListener(this);
		Double.addMouseListener(this);
		stand.addMouseListener(this);
		play.addMouseListener(this);
		info.addMouseListener(this);
		quit.addMouseListener(this);
		betton.addMouseListener(this);
		backstart.addMouseListener(this);
		cashout.addMouseListener(this);
		cont.addMouseListener(this);
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
		table1 = new JLabel(cards[0]);	
		table2 = new JLabel(cards[1]);
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
		deal1 = new JLabel(back[0]);
		deal1.setOpaque(true);
		deal1.setBounds(460,31,69,94);
		deal3 = new JLabel(cards[2]);
		deal3.setOpaque(true);
		deal3.setBounds(620,31,69,94);
		deal3.setVisible(false);
		deal4 = new JLabel(cards[3]);
		deal4.setOpaque(true);
		deal4.setBounds(700,31,69,94);
		deal4.setVisible(false);
		deal5 = new JLabel(cards[4]);
		deal5.setOpaque(true);
		deal5.setBounds(780,31,69,94);
		deal5.setVisible(false);
		deal6 = new JLabel(cards[5]);
		deal6.setOpaque(true);
		deal6.setBounds(860,31,69,94);
		deal6.setVisible(false);
		deal7 = new JLabel(cards[6]);
		deal7.setOpaque(true);
		deal7.setBounds(940,31,69,94);
		deal7.setVisible(false);
		deal8 = new JLabel(cards[7]);
		deal8.setOpaque(true);
		deal8.setBounds(1020,31,69,94);
		deal8.setVisible(false);
		deal9 = new JLabel(cards[8]);
		deal9.setOpaque(true);
		deal9.setBounds(1100,31,69,94);
		deal9.setVisible(false);
		decks = new JLabel(deck[0]);
		decks.setOpaque(true);
		decks.setBounds(500, 200, 69, 94);
		turn = new JLabel(arrow[1]);
		turn.setBounds(850, 250, 50, 100);	
		turn.setVisible(true);
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
		better.setBounds(35, 180, 200, 50);	
		better.setForeground(Color.white);	
		better.setFont(new Font("Monospace", Font.PLAIN, 12));	
		better.setVisible(false);	
		newbet.setBounds(25, 225, 200, 30);	
		newbet.setVisible(false);	
		bettons.setBounds(75, 260, 100, 20);	
		bettons.setVisible(false);
		cashout.setBounds(800, 150, 100, 50);
		cashout.setVisible(true);
		cont.setBounds(75, 225, 100, 50);
		cont.setVisible(false);
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
		game.add(better);	
		game.add(newbet);	
		game.add(bettons);
		game.add(cashout);
		game.add(cont);
		startframe.add(start);
		startframe.pack();
		startframe.setVisible(true);
		startframe.setLocation(550,250);
		startframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		betframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		infoframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void dealerturn (int i) throws InterruptedException
	{
		while (i > 21 && dealerHand.getNumAces() > 0)
		{
			dealerHand.subtractTotalValue();
			dvalue.setText("Dealer Hand Value: " + dealerHand);
			i -= 10;
		}
		if (i >= 17)
		{
		}
		else
		{
//			long curr = System.currentTimeMillis();
//			long time = System.currentTimeMillis();
//			while (time != curr+1000L)
//			{	
//				time = System.currentTimeMillis();
//			}
//			TimeUnit.SECONDS.sleep(1);
			Card ind = d.draw();
			dealerHand.addCard(ind);
			int index = dealerHand.getSize();
			if (index == 3)
			{
				deal3.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				dvalue.setText("Dealer Hand Value: " + dealerHand);
				deal1.setBounds(420,31,69,94);
				deal2.setBounds(500,31,69,94);
				deal3.setBounds(580,31,69,94);
				deal3.setVisible(true);
//				TimeUnit.SECONDS.sleep(1);
				dealerturn(dealerHand.getTotalValue());
			}
			else if (index == 4)
			{
				deal4.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				dvalue.setText("Dealer Hand Value: " + dealerHand);
				deal1.setBounds(380,31,69,94);
				deal2.setBounds(460,31,69,94);
				deal3.setBounds(540,31,69,94);
				deal4.setBounds(620,31,69,94);
				deal4.setVisible(true);
//				TimeUnit.SECONDS.sleep(1);
				dealerturn(dealerHand.getTotalValue());
			}
			else if (index == 5)
			{
				deal5.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				dvalue.setText("Dealer Hand Value: " + dealerHand);
				deal1.setBounds(340,31,69,94);
				deal2.setBounds(420,31,69,94);
				deal3.setBounds(500,31,69,94);
				deal4.setBounds(580,31,69,94);
				deal5.setBounds(660,31,69,94);
				deal5.setVisible(true);
//				TimeUnit.SECONDS.sleep(1);
				dealerturn(dealerHand.getTotalValue());
			}
			else if (index == 6)
			{
				deal6.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				dvalue.setText("Dealer Hand Value: " + dealerHand);
				deal1.setBounds(300,31,69,94);
				deal2.setBounds(380,31,69,94);
				deal3.setBounds(460,31,69,94);
				deal4.setBounds(540,31,69,94);
				deal5.setBounds(620,31,69,94);
				deal6.setBounds(700,31,69,94);
				deal6.setVisible(true);
//				TimeUnit.SECONDS.sleep(1);
				dealerturn(dealerHand.getTotalValue());
			}
			else if (index == 7)
			{
				deal7.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				dvalue.setText("Dealer Hand Value: " + dealerHand);
				deal1.setBounds(260,31,69,94);
				deal2.setBounds(340,31,69,94);
				deal3.setBounds(420,31,69,94);
				deal4.setBounds(500,31,69,94);
				deal5.setBounds(580,31,69,94);
				deal6.setBounds(660,31,69,94);
				deal7.setBounds(740,31,69,94);
				deal7.setVisible(true);
//				TimeUnit.SECONDS.sleep(1);
				dealerturn(dealerHand.getTotalValue());
			}
			else if (index == 8)
			{
				deal8.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				dvalue.setText("Dealer Hand Value: " + dealerHand);
				deal1.setBounds(220,31,69,94);
				deal2.setBounds(300,31,69,94);
				deal3.setBounds(380,31,69,94);
				deal4.setBounds(460,31,69,94);
				deal5.setBounds(540,31,69,94);
				deal6.setBounds(620,31,69,94);
				deal7.setBounds(700,31,69,94);
				deal8.setBounds(780,31,69,94);
				deal8.setVisible(true);
//				TimeUnit.SECONDS.sleep(1);
				dealerturn(dealerHand.getTotalValue());
			}
			else if (index == 9)
			{
				deal9.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				dvalue.setText("Dealer Hand Value: " + dealerHand);
				deal1.setBounds(180,31,69,94);
				deal2.setBounds(260,31,69,94);
				deal3.setBounds(340,31,69,94);
				deal4.setBounds(420,31,69,94);
				deal5.setBounds(500,31,69,94);
				deal6.setBounds(580,31,69,94);
				deal7.setBounds(660,31,69,94);
				deal8.setBounds(740,31,69,94);
				deal9.setBounds(820,31,69,94);
				deal9.setVisible(true);
//				TimeUnit.SECONDS.sleep(1);
				dealerturn(dealerHand.getTotalValue());
			}
		}
	}
	public void mouseClicked (MouseEvent e)
    {
		if (e.getSource() == bettons)	
		{	
			String out = newbet.getText();	
			try	
			{	
				int b = Integer.parseInt(out);	
				if (b > Blackjack.bettingAmount || b < 1)	
				{	
					better.setText("Invalid Input! How much would you like to bet?");	
					better.setBounds(15, 180, 300, 50);	
				}	
				else	
				{	
					deal3.setVisible(false);
					deal4.setVisible(false);
					deal5.setVisible(false);
					deal6.setVisible(false);
					deal7.setVisible(false);
					deal8.setVisible(false);
					deal9.setVisible(false);
					bettons.setVisible(false);	
					better.setVisible(false);	
					newbet.setVisible(false);
					hit.setVisible(true);
					stand.setVisible(true);
					Double.setVisible(true);
					d = new Deck();	
					playerHand = new Hand(false);	
					dealerHand = new Hand(true);	
					d.shuffle();	
					table3.setVisible(false);	
					table4.setVisible(false);	
					table5.setVisible(false);	
					table6.setVisible(false);	
					table7.setVisible(false);	
					table8.setVisible(false);	
					table9.setVisible(false);	
					Card ind = d.draw();	
					playerHand.addCard(ind);	
					table1.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);	
					table1.setOpaque(true);	
					table1.setBounds(460,450,69,94);
					ind = d.draw();	
					playerHand.addCard(ind);	
					table2.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);	
					table2.setOpaque(true);	
					table2.setBounds(540,450,69,94);	
					ind = d.draw();	
					dealerHand.addCard(ind);	
					hold = ind;
					ind = d.draw();	
					dealerHand.addCard(ind);	
					deal1.setIcon(back[0]);
					deal1.setBounds(460,31,69,94);
					deal2.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);	
					deal2.setOpaque(true);	
					deal2.setBounds(540,31,69,94);	
					bethere.setText("How much would you like to bet");	
					bethere.setBounds(397, 210, 250, 50);	
					betamount = b;
					Blackjack.bettingAmount -= b;	
					Blackjack.bet = b;	
					balance.setText("Balance: $" + Blackjack.bettingAmount);	
					balance.setFont(new Font("Monospace", Font.PLAIN, 15));	
					bamount.setText("Bet: $" + Blackjack.bet);	
					bamount.setFont(new Font("Monospace", Font.PLAIN, 15));	
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
					if (Blackjack.bettingAmount < Blackjack.bet || playerHand.getSize() > 2) 
					{	
						Double.setVisible(false);	
					}	
					better.setText("How much would you like to bet?");
					better.setBounds(35, 180, 250, 50);
				}	
			}	
			catch (NumberFormatException i)	
			{	
				better.setText("Invalid Input! How much would you like to bet?");	
				better.setBounds(15, 180, 300, 50);	
			}	
		}	
		else if (e.getSource() == hit)
		{
			Card ind = d.draw();
			playerHand.addCard(ind);
			Double.setVisible(false);

			int index = playerHand.getSize();
			if (index == 3)
			{
				table3.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				value.setText("Hand Value: " + playerHand);
				table1.setBounds(420,450,69,94);
				table2.setBounds(500,450,69,94);
				table3.setBounds(580,450,69,94);
				table3.setVisible(true);
			}
			else if (index == 4)
			{
				table4.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				value.setText("Hand Value: " + playerHand);
				table1.setBounds(380,450,69,94);
				table2.setBounds(460,450,69,94);
				table3.setBounds(540,450,69,94);
				table4.setBounds(620,450,69,94);
				table4.setVisible(true);
			}
			else if (index == 5)
			{
				table5.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				table5.setVisible(true);
				value.setText("Hand Value: " + playerHand);
				table1.setBounds(340,450,69,94);
				table2.setBounds(420,450,69,94);
				table3.setBounds(500,450,69,94);
				table4.setBounds(580,450,69,94);
				table5.setBounds(660,450,69,94);
			}
			else if (index == 6)
			{
				table6.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				table6.setVisible(true);
				value.setText("Hand Value: " + playerHand);
				table1.setBounds(300,450,69,94);
				table2.setBounds(380,450,69,94);
				table3.setBounds(460,450,69,94);
				table4.setBounds(540,450,69,94);
				table5.setBounds(620,450,69,94);
				table6.setBounds(700,450,69,94);
			}
			else if (index == 7)
			{
				table7.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				table7.setVisible(true);
				value.setText("Hand Value: " + playerHand);
				table1.setBounds(260,450,69,94);
				table2.setBounds(340,450,69,94);
				table3.setBounds(420,450,69,94);
				table4.setBounds(500,450,69,94);
				table5.setBounds(580,450,69,94);
				table6.setBounds(660,450,69,94);
				table7.setBounds(740,450,69,94);
			}
			else if (index == 8)
			{
				table8.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				table8.setVisible(true);
				value.setText("Hand Value: " + playerHand);
				table1.setBounds(220,450,69,94);
				table2.setBounds(300,450,69,94);
				table3.setBounds(380,450,69,94);
				table4.setBounds(460,450,69,94);
				table5.setBounds(540,450,69,94);
				table6.setBounds(620,450,69,94);
				table7.setBounds(700,450,69,94);
				table8.setBounds(780,450,69,94);
			}
			else if (index == 9)
			{
				table9.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
				table9.setVisible(true);
				value.setText("Hand Value: " + playerHand);
				table1.setBounds(180,450,69,94);
				table2.setBounds(260,450,69,94);
				table3.setBounds(340,450,69,94);
				table4.setBounds(420,450,69,94);
				table5.setBounds(500,450,69,94);
				table6.setBounds(580,450,69,94);
				table7.setBounds(660,450,69,94);
				table8.setBounds(740,450,69,94);
				table9.setBounds(820,450,69,94);
			}
			if (playerHand.getTotalValue() > 21 && playerHand.getNumAces() > 0)
			{
				playerHand.subtractTotalValue();
				value.setText("Hand Value: " + playerHand);
			}
			else if (playerHand.getTotalValue () > 21)
			{
				// PLAYER LOSE	
				bamount.setText("Bet: $0");
				balance.setText("Balance: $" + Blackjack.bettingAmount);	
				hit.setVisible(false);	
				stand.setVisible(false);
				better.setVisible(true);	
				better.setText("You busted, How much would you like to bet?");	
				better.setBounds(15, 180, 250, 50);	
				newbet.setVisible(true);	
				bettons.setVisible(true);
				if (Blackjack.bettingAmount <= 0)
				{
					better.setText("You are out of money!");
					better.setBounds(70, 190, 200, 30);
					bettons.setVisible(false);
					newbet.setVisible(false);
					cont.setVisible(true);
				}
			}
		}
		else if (e.getSource() == Double)
		{
			Blackjack.bettingAmount -= Blackjack.bet;
			Blackjack.bet *= 2;
			betamount *= 2;
			Card ind = d.draw();
			playerHand.addCard(ind);
			hit.setVisible(false);
			Double.setVisible(false);
			stand.setVisible(false);
			bamount.setText("Bet: $" + Blackjack.bet);
			balance.setText("Balance: $" + Blackjack.bettingAmount);
			
			table3.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
			table3.setVisible(true);
			value.setText("Hand Value: " + playerHand);
			table1.setBounds(420,450,69,94);
			table2.setBounds(500,450,69,94);
			table3.setBounds(580,450,69,94);
			
			while (playerHand.getTotalValue() > 21 && playerHand.getNumAces() > 0)
			{
				playerHand.subtractTotalValue();
				value.setText("Hand Value: " + playerHand);
			}
			if (playerHand.getTotalValue () > 21)
			{
				// PLAYER LOSE	
				bamount.setText("Bet: $0");
				balance.setText("Balance: $" + Blackjack.bettingAmount);	
				hit.setVisible(false);	
				stand.setVisible(false);	
				better.setVisible(true);	
				better.setText("You busted, How much would you like to bet?");	
				better.setBounds(15, 180, 250, 50);	
				newbet.setVisible(true);	
				bettons.setVisible(true);
			}
			else 
			{
				dealerHand.show();
				deal1.setIcon(cards[(hold.getRank()*4)-(5-hold.getSuit())]);
				dvalue.setText("Dealer Hand Value: " + dealerHand);	
				try 
				{
					dealerturn(dealerHand.getTotalValue());
					int i = dealerHand.getTotalValue();
					if (i > 21)
					{
						// DEALER LOSE	
						bamount.setText("Bet: $0");
						Blackjack.bettingAmount += (betamount*2);
						balance.setText("Balance: $" + Blackjack.bettingAmount);	
						better.setVisible(true);	
						better.setText("You won! How much would you like to bet?");	
						better.setBounds(15, 180, 250, 50);	
						newbet.setVisible(true);	
						bettons.setVisible(true);
					}
					else
					{
						if (dealerHand.getTotalValue() < playerHand.getTotalValue())
						{
							Blackjack.bettingAmount += (betamount*2);
							bamount.setText("Bet: $0");
							balance.setText("Balance: $" + Blackjack.bettingAmount);	
							better.setText("You won! How much would you like to bet?");
							better.setBounds(25, 180, 260, 50);
							better.setVisible(true);
							bettons.setVisible(true);
							newbet.setVisible(true);
						}
						else if (dealerHand.getTotalValue() == playerHand.getTotalValue())
						{
							Blackjack.bettingAmount += betamount;
							bamount.setText("Bet: $0");
							balance.setText("Balance: $" + Blackjack.bettingAmount);	
							better.setText("You tied! How much would you like to bet?");
							better.setBounds(25, 180, 260, 50);
							better.setVisible(true);
							bettons.setVisible(true);
							newbet.setVisible(true);
						}
						else
						{
							bamount.setText("Bet: $0");
							balance.setText("Balance: $" + Blackjack.bettingAmount);	
							better.setText("You lost! How much would you like to bet?");
							better.setBounds(25, 180, 260, 50);
							better.setVisible(true);
							bettons.setVisible(true);
							newbet.setVisible(true);
						}
					}
				}				
				catch (InterruptedException e1) 
				{
					System.out.println("Problem");
				}
			}
			if (Blackjack.bettingAmount <= 0)
			{
				better.setText("You are out of money!");
				better.setBounds(70, 190, 200, 30);
				bettons.setVisible(false);
				newbet.setVisible(false);
				cont.setVisible(true);
			}
		}
		else if (e.getSource() == stand)
		{
			hit.setVisible(false);
			Double.setVisible(false);
			stand.setVisible(false);
			dealerHand.show();
			deal1.setIcon(cards[(hold.getRank()*4)-(5-hold.getSuit())]);
			dvalue.setText("Dealer Hand Value: " + dealerHand);
			try 
			{
				dealerturn(dealerHand.getTotalValue());
				int i = dealerHand.getTotalValue();
				if (i > 21)
				{
					// DEALER LOSE	
					Blackjack.bettingAmount += betamount;
					Blackjack.bettingAmount += betamount;
					bamount.setText("Bet: $0");
					balance.setText("Balance: $" + Blackjack.bettingAmount);	
					better.setVisible(true);	
					better.setText("You won! How much would you like to bet?");	
					better.setBounds(15, 180, 250, 50);	
					newbet.setVisible(true);	
					bettons.setVisible(true);
				}
				else
				{
					bamount.setText("Bet: $0");
					if (dealerHand.getTotalValue() < playerHand.getTotalValue())
					{
						Blackjack.bettingAmount += (2*betamount);
						bamount.setText("Bet: $0");
						balance.setText("Balance: $" + Blackjack.bettingAmount);	
						better.setText("You won! How much would you like to bet?");
						better.setBounds(25, 180, 260, 50);
						better.setVisible(true);
						bettons.setVisible(true);
						newbet.setVisible(true);
					}
					else if (dealerHand.getTotalValue() == playerHand.getTotalValue())
					{
						Blackjack.bettingAmount += betamount;
						bamount.setText("Bet: $0");
						balance.setText("Balance: $" + Blackjack.bettingAmount);	
						better.setText("You tied! How much would you like to bet?");
						better.setBounds(25, 180, 260, 50);
						better.setVisible(true);
						bettons.setVisible(true);
						newbet.setVisible(true);
					}
					else
					{
						bamount.setText("Bet: $0");
						balance.setText("Balance: $" + Blackjack.bettingAmount);	
						better.setText("You lost! How much would you like to bet?");
						better.setBounds(25, 180, 260, 50);
						better.setVisible(true);
						bettons.setVisible(true);
						newbet.setVisible(true);
					}
				}
			} 
			catch (InterruptedException e1) 
			{
				System.out.println("Problem");
			}
			if (Blackjack.bettingAmount <= 0)
			{
				better.setText("You are out of money!");
				better.setBounds(70, 190, 200, 30);
				bettons.setVisible(false);
				newbet.setVisible(false);
				cont.setVisible(true);
			}
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
			Betting.setText("<html><b><u>Betting:</u></b><br>Before the dealing begins, the player places a bet in dollars. The minimum bet is $1, there is no maximum bet.</html>");
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
			DoublingDown.setText("<html><b><u>Doubling Down:</u></b><br>Another option available to the player is known as “double down”. When a player chooses to “double down”, they place a bet equal to the original bet <br> and the dealer deals them one card. Note that the dealer doesn’t have the option to “double down. You can only double down when you have two <br> cards, and your bet is less than or equal to half of your balance.</html>");
			DoublingDown.setFont(new Font("Monospace", Font.PLAIN, 15));
			DoublingDown.setBounds(15, 500, 1000, 80);
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
				int b = Integer.parseInt(out);
				if (b > Blackjack.bettingAmount || b < 1)
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
					table1.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
					table1 = new JLabel(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
					table1.setOpaque(true);
					table1.setBounds(460,450,69,94);
					ind = d.draw();
					playerHand.addCard(ind);
					table2 = new JLabel(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
					table2.setIcon(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
					table2.setOpaque(true);
					table2.setBounds(540,450,69,94);
					ind = d.draw();
					dealerHand.addCard(ind);
					hold = ind;
					ind = d.draw();
					dealerHand.addCard(ind);
					deal2 = new JLabel(cards[(ind.getRank()*4)-(5-ind.getSuit())]);
					deal2.setOpaque(true);
					deal2.setBounds(540,31,69,94);
					bethere.setText("How much would you like to bet");
					bethere.setBounds(397, 210, 250, 50);
					betframe.setVisible(false);
					Blackjack.bettingAmount -= b;
					Blackjack.bet = b;
					betamount = b;
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
					if (Blackjack.bettingAmount < Blackjack.bet || playerHand.getSize() > 2)
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
					game.add(deal3);
					game.add(deal4);
					game.add(deal5);
					game.add(deal6);
					game.add(deal7);
					game.add(deal8);
					game.add(deal9);
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
		else if (e.getSource() == cashout)
		{
			frame.setVisible(false);
			End finish = new End(Blackjack.bettingAmount);
			Blackjack.bettingAmount = 10000;
		}
		else if (e.getSource() == cont)
		{
			frame.setVisible(false);
			End thing = new End();
			Blackjack.bettingAmount = 10000;
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
