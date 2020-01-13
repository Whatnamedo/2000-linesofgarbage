import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
	private JFrame startframe = new JFrame("BlackJack");
	private JFrame frame = new JFrame("BlackJack");
	private JPanel game = new JPanel();
	private JPanel start = new JPanel();
	private ImageIcon[] cards = new ImageIcon[52];
	private ImageIcon[] background = new ImageIcon[2];
	private ImageIcon[] deck = new ImageIcon[1];
	private ImageIcon[] back = new ImageIcon[1];
	private JLabel decks;
	private JLabel table1;
	private JLabel table2;
	private JLabel table3;
	private JLabel table4;
	private JLabel table5;
	private JLabel backLabel;
	private JLabel backMain;
	private JLabel deal1;
	private JLabel deal2;
	public BlackJackMain()
	{
		hit.addMouseListener(this);
		Double.addMouseListener(this);
		stand.addMouseListener(this);
		play.addMouseListener(this);
		info.addMouseListener(this);
		quit.addMouseListener(this);
		start.setPreferredSize(new Dimension(1000,600));
		start.setLayout(null);
		game.setPreferredSize(new Dimension(1000,600));
		game.setLayout(null);
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
		play.setBounds(450, 100, 150, 50);
		play.setVisible(true);
		info.setBounds(450, 250, 150, 50);
		info.setVisible(true);
		quit.setBounds(450, 400, 150, 50);
		quit.setVisible(true);
		backLabel = new JLabel(background[0]);
		backLabel.setOpaque(true);
		backLabel.setBounds(0, 0, 1000, 600);
		table1 = new JLabel(cards[0]);
		table1.setOpaque(true);
		table1.setBounds(340,450,69,94);
		table2 = new JLabel(cards[1]);
		table2.setOpaque(true);
		table2.setBounds(420,450,69,94);
		table3 = new JLabel(cards[2]);
		table3.setOpaque(true);
		table3.setBounds(500,450,69,94);
		table4 = new JLabel(cards[3]);
		table4.setOpaque(true);
		table4.setBounds(580,450,69,94);
		table5 = new JLabel(cards[4]);
		table5.setOpaque(true);
		table5.setBounds(660,450,69,94);
		decks = new JLabel(deck[0]);
		decks.setOpaque(true);
		decks.setBounds(500, 200, 69, 94);
		deal1 = new JLabel(back[0]);
		deal1.setOpaque(true);
		deal1.setBounds(460,31,69,94);
		deal2 = new JLabel(cards[8]);
		deal2.setOpaque(true);
		deal2.setBounds(540,31,69,94);
		hit.setBounds(210, 350, 150, 50);
		Double.setBounds(460, 350, 150, 50);
		stand.setBounds(710, 350, 150, 50);
		start.add(backMain);
		start.add(play);
		start.add(info);
		start.add(quit);
		game.add(table1);
		game.add(table2);
		game.add(table3);
		game.add(table4);
		game.add(table5);
		game.add(decks);
		game.add(deal1);
		game.add(deal2);
		game.add(hit);
		game.add(Double);
		game.add(stand);
		game.add(backLabel);
		startframe.add(start);
		startframe.pack();
		startframe.setVisible(true);
		startframe.setLocation(50,50);
	}
	public void mouseClicked (MouseEvent e)
    {
		if (e.getSource() == hit)
		{
			imageNo++;
			if (imageNo > 51)
			{
				imageNo = 0;
			}
			table3.setIcon(cards[imageNo]);
		}
		else if (e.getSource() == Double)
		{
			
		}
		else if (e.getSource() == stand)
		{
			
		}
		else if (e.getSource() == play)
		{
			game.setVisible(true);
			start.setVisible(false);
		}
		else if (e.getSource() == info)
		{
			
		}
		else if (e.getSource() == quit)
		{
			startframe.setVisible(false);
			frame.add(game);
			frame.pack();
			frame.setVisible(true);
			frame.setLocation(50, 50);
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
