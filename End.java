import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class End extends JPanel implements MouseListener{
	private JFrame frame = new JFrame("Blackjack");
	private ImageIcon[] background = new ImageIcon[1];
	private JButton back = new JButton("Go Back");
	private JLabel backboard;
	private int condition;
	
	public End()
	{
		frame.setSize(1000, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		this.setSize(1000,600);
		this.setBackground(Color.black);
		background[0] = new ImageIcon("blueback1.jpg");
		backboard = new JLabel(background[0]);
		backboard.setBounds(0, 0, 1000, 600);
		this.add(backboard);
		condition = 0;
		frame.add(this);
		draw(this.getGraphics());
	}
	
	public End(int i)
	{
		frame.setSize(1000, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		this.setSize(1000,600);
		this.setBackground(Color.black);
		background[0] = new ImageIcon("blueback1.jpg");
		backboard = new JLabel(background[0]);
		backboard.setBounds(0, 0, 1000, 600);
		this.add(backboard);
		condition = 1;
		frame.add(this);
		draw(this.getGraphics());
	}
	
	public void draw(Graphics g)
	{
		if (condition == 0)
		{
			g.setColor(Color.black);
			g.fillRect(0, 0, 1000, 600);
			g.setColor(Color.red);
			g.fillRect(280, 200, 500, 200);
			g.setColor(Color.black);
			g.setFont(new Font("Monospaced", Font.BOLD, 35));
			g.drawString("You Lose!", 425, 275);
			g.drawString("You ran out of money!", 325, 325);
		}
		else if (condition == 1)
		{
			g.setColor(Color.green);
			g.setFont(new Font("Monospaced", Font.BOLD, 35));
			g.drawString("You Win!", 450, 300);
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == back)
		{
			BlackJackMain game = new BlackJackMain();
		}
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}
	
	public static void main(String[] args)
	{
		End thing = new End();
	}
}
