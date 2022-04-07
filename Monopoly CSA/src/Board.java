
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

	Background bg = new Background(0, 0); //aaa
	Player player0 = new Player(0, 0, "Car.png", 53, 39); 
	Player player1 = new Player(1, 0, "Dog.png", 0, 0); 
	Player player2 = new Player(2, 0, "Hat.png", 0, 0); 
	int turn = 0; 
	int numPlayers = 2; 
	boolean roll = false; 
	
	// CREATE THE OBJECT (STEP 1)sss
	Random rnd = new Random();
	//https://www.falstad.com/monopoly.html
		Property p0 = new Property("Go","", 930, 920, 0, -200);					//special
		Property p1 = new Property("Mediterranean Avenue","", 825 , 930 , 60, 2);
		Property p2 = new Property("Community Chest","", 740 , 930 , 0, 0); 		//special - x diff is 85
		Property p3 = new Property("Baltic Avenue","", 660 , 930, 60, 4);
		Property p4 = new Property("Income Tax","", 580, 930, 0, 200);			//special
		Property p5 = new Property("Reading Railroad","", 500 , 930, 200, 25); 	//special
		Property p6 = new Property("Oriental Avenue","", 416 , 930, 100, 6);
		Property p7 = new Property("Chance","", 335, 930, 0, 0); 				//special
		Property p8 = new Property("Vermont Avenue","", 250 , 930, 100, 6);
		Property p9 = new Property("Connecticut Avenue","", 167, 930, 100, 8);
		Property p10 = new Property("VISITING JAIL","", 0, 890, 0, 0);		//special
		
		
		Property p11 = new Property("St. Charles Place","", 55, 820, 140, 10);
		Property p12 = new Property("Electric Company","", 55, 740, 150, 0); 	//utilities - y difference of 80
		Property p13 = new Property("States Avenue","", 55, 660, 140, 10);
		Property p14 = new Property("Virginia Avenue","", 55, 580, 160, 12);
		Property p15 = new Property("Pennsylvania Railroad","", 55, 500, 200, 25);//special
		Property p16 = new Property("St. James Place","", 55, 420, 180, 14);
		Property p17 = new Property("Community Chest","", 55, 340, 0, 0); 		//special
		Property p18 = new Property("Tennessee Avenue","", 55, 260, 180, 14);
		Property p19 = new Property("New York Avenue","", 55, 180, 200, 16);
		Property p20 = new Property("Free Parking","", 55, 55, 0, 0); 		//special
		
		
		Property p21 = new Property("Kentucky Avenue","", 170 , 55, 220, 18);
		Property p22 = new Property("Chance","", 255, 55, 0, 0); 				//special
		Property p23 = new Property("Indiana Avenue","", 340, 55 , 220, 18);
		Property p24 = new Property("Illinois Avenue","", 425, 55 , 240, 20);
		Property p25 = new Property("B&O Railroad","", 510, 55 , 200, 25);		//special
		Property p26 = new Property("Atlantic Avenue","", 595, 55 , 260, 22);
		Property p27 = new Property("Ventnor Avenue","", 680, 55 , 260, 22);
		Property p28 = new Property("Water Works","", 765, 55 , 150, 0); 		//utilities
		Property p29 = new Property("Marvin Gardens","", 850, 55 , 280, 24);
		Property p30 = new Property("JAIL","", 930 , 55 , 0, 0);					//special
		
		
		Property p31 = new Property("Pacific Avenue","", 940 , 170, 300, 26);
		Property p32 = new Property("North Carolina Avenue","", 940 , 250, 300, 26);
		Property p33 = new Property("Community Chest","", 940, 330, 0, 0); 		//special
		Property p34 = new Property("Pennsylvania Avenue","", 940, 410, 320, 28);
		Property p35 = new Property("Short Line","", 940, 490, 200, 25);
		Property p36 = new Property("Chance","", 940, 570, 0, 0); 				//special
		Property p37 = new Property("Park Place","", 940, 650, 350, 38);
		Property p38 = new Property("Luxury Tax","", 940, 730, 0, -100);		//special
		Property p39 = new Property("Boardwalk","", 940, 810, 400, 50);
	
		Property[] properties = {p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, 
				p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39};
		
		public int dice() {
			 int diceX=(int)(Math.random()*6+1); //a
		  	 int diceY=(int)(Math.random()*6+1); 
		  	 return diceX + diceY; 
		}
		
		public void roll() { 
			player0.setPos( player0.getPos() + dice() );
			player0.setX(properties[player0.getPos()].getX() - player0.getWidth() / 2 );
			player0.setY(properties[player0.getPos()].getY());
			System.out.println("Name " + properties[player0.getPos()].getName());
			turn++;
		}
		
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		bg.paint(g);
		
		player0.paint(g);
		player1.paint(g);
		//player2.paint(g)s;
		
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
		// TODO Auto-generated method stubs
		 System.out.println(arg0.getKeyCode()); 
		
		 if (arg0.getKeyCode() == 82) { 
				roll();
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
