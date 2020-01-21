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
		this.setLocation(50,50);
		frame.add(this);
		draw(this.getGraphics(), 0);
		this.addMouseListener(this);
	}
	
	public End(int i)
	{
		frame.setSize(1000, 600);
		frame.setLayout(null);
		frame.setVisible(true);
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

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}
}
