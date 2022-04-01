
import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener, MouseListener, KeyListener {

	Background bg = new Background(0, 0); //aa
	

	// CREATE THE OBJECT (STEP 1)
	Random rnd = new Random();
	//https://www.falstad.com/monopoly.html
		Property p0 = new Property("Go","", 0, 0, 0, -200);					//special
		Property p1 = new Property("Mediterranean Avenue","", 0, 0, 60, 2);
		Property p2 = new Property("Community Chest","", 0, 0, 0, 0); 		//special
		Property p3 = new Property("Baltic Avenue","", 0, 0, 60, 4);
		Property p4 = new Property("Income Tax","", 0, 0, 0, 200);			//special
		Property p5 = new Property("Reading Railroad","", 0, 0, 200, 25); 	//special
		Property p6 = new Property("Oriental Avenue","", 0, 0, 100, 6);
		Property p7 = new Property("Chance","", 0, 0, 0, 0); 				//special
		Property p8 = new Property("Vermont Avenue","", 0, 0, 100, 6);
		Property p9 = new Property("Connecticut Avenue","", 0, 0, 100, 8);
		Property p10 = new Property("VISITING JAIL","", 0, 0, 0, 0);		//special
		Property p11 = new Property("St. Charles Place","", 0, 0, 140, 10);
		Property p12 = new Property("Electric Company","", 0, 0, 150, 0); 	//utilities
		Property p13 = new Property("States Avenue","", 0, 0, 140, 10);
		Property p14 = new Property("Virginia Avenue","", 0, 0, 160, 12);
		Property p15 = new Property("Pennsylvania Railroad","", 0, 0, 200, 25);//special
		Property p16 = new Property("St. James Place","", 0, 0, 180, 14);
		Property p17 = new Property("Community Chest","", 0, 0, 0, 0); 		//special
		Property p18 = new Property("Tennessee Avenue","", 0, 0, 180, 14);
		Property p19 = new Property("New York Avenue","", 0, 0, 200, 16);
		Property p20 = new Property("Free Parking","", 0, 0, 0, 0); 		//special
		Property p21 = new Property("Kentucky Avenue","", 0, 0, 220, 18);
		Property p22 = new Property("Chance","", 0, 0, 0, 0); 				//special
		Property p23 = new Property("Indiana Avenue","", 0, 0, 220, 18);
		Property p24 = new Property("Illinois Avenue","", 0, 0, 240, 20);
		Property p25 = new Property("B&O Railroad","", 0, 0, 200, 25);		//special
		Property p26 = new Property("Atlantic Avenue","", 0, 0, 260, 22);
		Property p27 = new Property("Ventnor Avenue","", 0, 0, 260, 22);
		Property p28 = new Property("Water Works","", 0, 0, 150, 0); 		//utilities
		Property p29 = new Property("Marvin Gardens","", 0, 0, 280, 24);
		Property p30 = new Property("JAIL","", 0, 0, 0, 0);					//special
		Property p31 = new Property("Pacific Avenue","", 0, 0, 300, 26);
		Property p32 = new Property("North Carolina Avenue","", 0, 0, 300, 26);
		Property p33 = new Property("Community Chest","", 0, 0, 0, 0); 		//special
		Property p34 = new Property("Pennsylvania Avenue","", 0, 0, 320, 28);
		Property p35 = new Property("Short Line","", 0, 0, 200, 25);
		Property p36 = new Property("Chance","", 0, 0, 0, 0); 				//special
		Property p37 = new Property("Park Place","", 0, 0, 350, 38);
		Property p38 = new Property("Luxury Tax","", 0, 0, 0, -100);		//special
		Property p39 = new Property("Boardwalk","", 0, 0, 400, 50);
	
	
	

	public void paint(Graphics g) {
		super.paintComponent(g);
		bg.paint(g);
	}

	private Image getImage(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] arg) {
		Board f = new Board();
	}

	public Board() {

		Random rnd = new Random();// aa

		JFrame f = new JFrame("Monopoly");
		f.setSize(new Dimension(1900, 1035));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(true);
		f.setLayout(new GridLayout(1, 2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (MouseEvent.MOUSE_CLICKED == 500) {
			System.out.println(getMousePosition());
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println(arg0.getKeyCode()); //Player movement
		if (arg0.getKeyCode() == 38) {

		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		// Stops player when no keys are pressed
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
