// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CirclePanel extends JPanel {
	private final int CIRCLE_SIZE = 50;
	private int x,y;
	private Color c;
	
	//poin1
	private JButton left; 
	private JButton right;
	private JButton up;
	private JButton down;
	
	private int width;
	private int height;
	//---------------------------------------------------------------
	// Set up circle and buttons to move it.
	//---------------------------------------------------------------
	public CirclePanel(int width, int height) {
		// Set coordinates so circle starts in middle
		x = (width / 2) - (CIRCLE_SIZE / 2);
		y = (height / 2) - (CIRCLE_SIZE / 2);
		c = Color.green;
		
		// Need a border layout to get the buttons on the bottom
		this.setLayout(new BorderLayout());
		
		// Create buttons to move the circle
		left = new JButton("Left");
		right = new JButton("Right");
		up = new JButton("Up");
		down = new JButton("Down");

		// Add listeners to the buttons
		left.addActionListener(new MoveListener(-20,0));
		right.addActionListener(new MoveListener(20,0));
		up.addActionListener(new MoveListener(0,-20));
		down.addActionListener(new MoveListener(0,20));
		
		 //Poin1: Add mnemonic
        left.setMnemonic(KeyEvent.VK_L);
        right.setMnemonic(KeyEvent.VK_R);
        up.setMnemonic(KeyEvent.VK_U);
        down.setMnemonic(KeyEvent.VK_D);     
       
		//Poin2: Tooltips
        left.setToolTipText("Move circle to the left for 20 pixels");
        right.setToolTipText("Move circle to the right for 20 pixels");
        up.setToolTipText("Move circle upwards for 20 pixels up");
        down.setToolTipText("Move circle downwards for 20 pixels");
       
		// Need a panel to put the buttons on or they'll be on
		// top of each other.
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(left);
		buttonPanel.add(right);
		buttonPanel.add(up);
		buttonPanel.add(down);
		
		// Add the button panel to the bottom of the main panel
		this.add(buttonPanel, "South");
		
		
	}
	
	//---------------------------------------------------------------
	// Draw circle on CirclePanel
	//---------------------------------------------------------------
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		page.setColor(c);
		page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
	}
	
	//---------------------------------------------------------------
	// Class to listen for button clicks that move circle.
	//---------------------------------------------------------------
	private class MoveListener implements ActionListener {
		private int dx;
		private int dy;
	
		//---------------------------------------------------------------
		// Parameters tell how to move circle at click.
		//---------------------------------------------------------------
		public MoveListener(int dx, int dy) {
			this.dx = dx;
			this.dy = dy;
		}
		
		//---------------------------------------------------------------
		// Change x and y coordinates and repaint.
		//---------------------------------------------------------------
		public void actionPerformed(ActionEvent e) {
			//poin3
			int lw = width - CIRCLE_SIZE;
			int lh = height - CIRCLE_SIZE - 70;
			 
            x += dx;
            y += dy;

            x = Math.max(0, x);
            x = Math.min(lw, x);
            y = Math.max(0, y);
            y = Math.min(lh, y);

            left.setEnabled(x > 0);
            right.setEnabled(x < lw);
            up.setEnabled(y > 0);
            down.setEnabled(y < lh);

            repaint();

		}
	}
}
