import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class End extends JPanel implements MouseListener{
	private JFrame frame = new JFrame("Blackjack");
	
	public End()
	{
		frame.setSize(1000, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocation(50,50);
		this.setSize(1000,600);
		this.setBackground(Color.black);
		frame.add(this);
		draw(this.getGraphics(), 0);
		this.addMouseListener(this);
	}
	
	public End(int i)
	{
		frame.setSize(1000, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocation(50,50);
		this.setSize(1000,600);
		this.setBackground(Color.green);
		frame.add(this);
		draw(this.getGraphics(), i);
		this.addMouseListener(this);
	}
	
	public void draw(Graphics g, int i)
	{
		if (i > 0)
		{
			g.setColor(Color.white);
			g.setFont(new Font("Monospaced", Font.BOLD, 35));
			g.drawString("Cashed Out!", 415, 275);
			g.drawString("You cashed out with $" + i, 300, 325);
			int profit = 0;
			if (i >= 10000)
			{
				profit = i - 10000;
				g.drawString("Profit $" + profit + "!", 420, 375);
			}
			else if (i < 10000)
			{
				profit = 10000 - i;
				g.drawString("Loss: $" + profit + "!", 420, 375);
			}
		}
		else
		{
			g.setColor(Color.red);
			g.setFont(new Font("Monospaced", Font.BOLD, 35));
			g.drawString("You Lose!", 425, 275);
			g.drawString("You ran out of money!", 325, 325);
		}
	}

	public void mouseClicked(MouseEvent e) {
		frame.setVisible(false);
		BlackJackMain game = new BlackJackMain();
	}
//	public static void main(String[] args)
//	{
//		End n = new End(10001);
//	}
	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}
}
