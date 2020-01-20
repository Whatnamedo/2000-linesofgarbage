import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class End extends JPanel implements MouseListener{
	private JFrame frame = new JFrame("Blackjack");
	private ImageIcon[] back = new ImageIcon[1];
	private int condition;
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (condition == 1)
		{
			g.setColor(Color.green);
		}
		else
		{
			g.setColor(Color.red);
		}
	}
	
	public End()
	{
		frame.setSize(1000, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		this.setSize(1000,600);
		this.setBackground(Color.white);
		frame.add(this);
		back[0] = new ImageIcon("blueback1.jpg");
		condition = 0;
	}
	
	public End(int i)
	{
		frame.setSize(1000, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		this.setSize(1000,600);
		this.setBackground(Color.white);
		frame.add(this);
		back[0] = new ImageIcon("blueback1.jpg");
		condition = 1;
	}
	public void mouseClicked(MouseEvent e) {
		
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
