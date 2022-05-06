
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

	Background bg = new Background(0, 0); // aaas
	Player player0 = new Player(0, 0, "Car.png", 53, 39);
	Player player1 = new Player(1, 0, "Dog.png", 48, 32);
	Player player2 = new Player(2, 0, "Hat.png", 0, 0);
	int turn = 0;
	int numPlayers = 2;
	boolean rollYet = false; 
	boolean didBuy = false; 
	boolean haveToPay = false; 

	// CREATE THE OBJECT (STEP 1)ssss
	Random rnd = new Random();
	// https://www.falstad.com/monopoly.html
	Property p0 = new Property("Go", -1 , 930, 920, 0, -200); // special
	Property p1 = new Property("Mediterranean Avenue", -1, 825, 930, 60, 2);
	Property p2 = new Property("Community Chest", -1, 740, 930, 0, 0); // special - x diff is 85
	Property p3 = new Property("Baltic Avenue", -1, 660, 930, 60, 4);
	Property p4 = new Property("Income Tax", -1, 580, 930, 0, 200); // special
	Property p5 = new Property("Reading Railroad", -1, 500, 930, 200, 25); // special
	Property p6 = new Property("Oriental Avenue", -1, 416, 930, 100, 6);
	Property p7 = new Property("Chance", -1, 335, 930, 0, 0); // special
	Property p8 = new Property("Vermont Avenue", -1, 250, 930, 100, 6);
	Property p9 = new Property("Connecticut Avenue", -1, 167, 930, 100, 8);
	Property p10 = new Property("VISITING JAIL", -1, 0, 890, 0, 0); // special

	Property p11 = new Property("St. Charles Place", -1, 55, 820, 140, 10);
	Property p12 = new Property("Electric Company", -1, 55, 740, 150, 0); // utilities - y difference of 80
	Property p13 = new Property("States Avenue", -1, 55, 660, 140, 10);
	Property p14 = new Property("Virginia Avenue", -1, 55, 580, 160, 12);
	Property p15 = new Property("Pennsylvania Railroad", -1, 55, 500, 200, 25);// special
	Property p16 = new Property("St. James Place", -1, 55, 420, 180, 14);
	Property p17 = new Property("Community Chest", -1, 55, 340, 0, 0); // special
	Property p18 = new Property("Tennessee Avenue", -1, 55, 260, 180, 14);
	Property p19 = new Property("New York Avenue", -1, 55, 180, 200, 16);
	Property p20 = new Property("Free Parking", -1, 55, 55, 0, 0); // special

	Property p21 = new Property("Kentucky Avenue", -1, 170, 55, 220, 18);
	Property p22 = new Property("Chance", -1, 255, 55, 0, 0); // special
	Property p23 = new Property("Indiana Avenue", -1, 340, 55, 220, 18);
	Property p24 = new Property("Illinois Avenue", -1, 425, 55, 240, 20);
	Property p25 = new Property("B&O Railroad", -1, 510, 55, 200, 25); // special
	Property p26 = new Property("Atlantic Avenue", -1, 595, 55, 260, 22);
	Property p27 = new Property("Ventnor Avenue", -1, 680, 55, 260, 22);
	Property p28 = new Property("Water Works", -1, 765, 55, 150, 0); // utilities
	Property p29 = new Property("Marvin Gardens", -1, 850, 55, 280, 24);
	Property p30 = new Property("JAIL", -1, 930, 55, 0, 0); // special

	Property p31 = new Property("Pacific Avenue", -1, 940, 170, 300, 26);
	Property p32 = new Property("North Carolina Avenue", -1, 940, 250, 300, 26);
	Property p33 = new Property("Community Chest", -1, 940, 330, 0, 0); // special
	Property p34 = new Property("Pennsylvania Avenue", -1, 940, 410, 320, 28);
	Property p35 = new Property("Short Line", -1, 940, 490, 200, 25);
	Property p36 = new Property("Chance", -1, 940, 570, 0, 0); // special
	Property p37 = new Property("Park Place", -1, 940, 650, 350, 38);
	Property p38 = new Property("Luxury Tax", -1, 940, 730, 0, -100); // special
	Property p39 = new Property("Boardwalk", -1, 940, 810, 400, 50);

	Property[] properties = { p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19,
			p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39 };

	Player[] players = { player0, player1, player2 };

	public int dice() {
		int diceX = (int) (Math.random() * 6 + 1); // a
		int diceY = (int) (Math.random() * 6 + 1);
		return diceX + diceY;
	}

	public void roll() {
		players[turn].setPos(players[turn].getPos() + dice());

		if (players[turn].getPos() >= 40) {
			players[turn].setPos(players[turn].getPos() - 39);
		}

		players[turn].setX(properties[players[turn].getPos()].getX() - players[turn].getWidth() / 2);
		players[turn].setY(properties[players[turn].getPos()].getY());
		rollYet = true;
		didBuy = false; 
		haveToPay = false; 
		
		if(properties[players[turn].getPos()].getOwner() != -1 ) { 
			haveToPay = true; 
		}
		
	}
	
	public void buy() { 
		if(players[turn].getPos() != 0 && players[turn].getPos() != 2 && players[turn].getPos() != 4 && 
				players[turn].getPos() != 7 && players[turn].getPos() != 10 && players[turn].getPos() != 17 && players[turn].getPos() != 20 
				&& players[turn].getPos() != 22 && players[turn].getPos() != 30 && players[turn].getPos() != 33 && players[turn].getPos() != 36 
				&& players[turn].getPos() != 38 && properties[players[turn].getPos()].getOwner() == -1 ) {
			
			
		players[turn].propertiesOwned.add(players[turn].getPos());
		properties[players[turn].getPos()].setOwner(turn);
		players[turn].setMoney(players[turn].getMoney() - properties[players[turn].getPos()].getPrice() );
		didBuy = true; 
		
		}
	}

	public void paint(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.setStroke(new BasicStroke(10));
		// thick
		g.setColor(Color.BLACK);
		g.setFont(new Font("Times New Roman", Font.BOLD, 20));
		g.drawRect(1000, 0, 550, 992);
		g.fillRect(1540, 0, 15, 1035);

		bg.paint(g);
		player0.paint(g);
		player1.paint(g);
		// player2.paint(g);
		g.drawString("Player " + turn + "'s Turn", 1045, 150);
		
		if(players[turn].getPos() == 0 && rollYet) { 
			
			g.drawString("You are on GO!" , 1045, 200);
			
			}
		
		else if(players[turn].getPos() == 10 && rollYet ) { 
			
			g.drawString("Visiting JAIL!" , 1045, 200);
			
			}
		
		else if(players[turn].getPos() == 20  && rollYet) { 
			
			g.drawString("ON FREE PARKING!" , 1045, 200);
			
			}
		
		else if(players[turn].getPos() == 30 && rollYet) { 
			
			g.drawString("Going to JAIL!" , 1045, 200);
			
			}
		
		else if(players[turn].getPos() == 7 || players[turn].getPos() == 22 || players[turn].getPos() == 36 && rollYet) { 
			
			g.drawString("Landed on Chance! Draw a Card!" , 1045, 200);
			
			}
		
		
		else if(players[turn].getPos() == 2 || players[turn].getPos() == 17 || players[turn].getPos() == 33 && rollYet) { 
			
			g.drawString("Landed on Community Chest! Draw a Card!" , 1045, 200);
			
			}
		
		
		else if(players[turn].getPos() == 4 && rollYet) { 
			
			g.drawString("INCOME TAX! PAY $200!" , 1045, 200);
			
			}
		
		else if(players[turn].getPos() == 38 && rollYet) { 
			
			g.drawString("LUXURY TAX! PAY $100!" , 1045, 200);
			
			}

		
		else if(properties[players[turn].getPos()].getOwner() == -1 && rollYet) { 
			
			g.drawString("Do You Want To Buy " + properties[players[turn].getPos()].getName() + "?", 1045, 200);
			g.drawString("It Will Cost $" + properties[players[turn].getPos()].getPrice(), 1045, 250);
			}	
		
		
		if (turn >= numPlayers) {
			turn = 0;
		}

		if(rollYet) { 
			g.drawString("Rolled! End Turn!" , 1045, 300);
		}
		
		if(!rollYet) { 
			g.drawString("Player " + turn + "!Roll!", 1045, 300);
		}
		
		for(int i = 0; i < properties.length; i++) { 
			if(properties[i].getOwner() == 0 ) { 
				g.setColor(Color.BLUE);
				g.drawRect(properties[i].getX(), properties[i].getY() + 10, 5, 5);
			}
			if(properties[i].getOwner() == 1 ) { 
				g.setColor(Color.GREEN);
				g.drawRect(properties[i].getX(), properties[i].getY() + 10, 5, 5);
			}
			if(properties[i].getOwner() == 2 ) { 
				g.setColor(Color.ORANGE);
				g.drawRect(properties[i].getX(), properties[i].getY() + 10, 5, 5);
			}
		}
		
		
		//UI CODDE
		
		
		if(didBuy) { 
			g.drawString("Player " + turn + " Bought " + properties[players[turn].getPos()].getName() + 
					" For $" + properties[players[turn].getPos()].getPrice() + "!" , 1045, 250);
		}
		
		
		if(haveToPay) { 
			g.drawString("Player " + turn + " Landed On " + properties[players[turn].getPos()].getName() + 
					" And Has to Pay Player " + properties[players[turn].getPos()].getOwner() + "For $" + properties[players[turn].getPos()].getPrice() + "!" , 1045, 250);
		}
		
		if (turn == 0) {
			g.setColor(Color.BLUE);
		}
		if (turn == 1) {
			g.setColor(Color.GREEN);
		}

		g.drawRect(1010, 10, 525, 972);

		g.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(5));
		g.drawRect(1030, 30, 100, 60);
		g.setFont(new Font("Times New Roman", Font.BOLD, 40));
		g.drawString("Buy", 1045, 70);

		g.drawRect(1150, 30, 100, 60);
		g.drawString("Roll", 1165, 70);

		g2.setStroke(new BasicStroke(10));

		g.setFont(new Font("Times New Roman", Font.BOLD, 20));

		for (int i = 0; i < players.length; i++) {
			g.drawLine(1550, i * 1000 / players.length, 1900, i * 1000 / players.length);

			// g.fillRect(1550, i*1000/players.length-1000/players.length, 400,
			// 1000/players.length);

			if (i == 0) {
				g.setColor(Color.BLUE);
				g.drawRect(1550, i * 1000 / players.length, 400, 1000 / players.length);
				g.setColor(Color.BLACK);
				g.drawString("Money: " + players[i].getMoney(), 1560, i * 1000 / players.length + 20);
				g.drawString("Position: " + properties[players[i].getPos()].getName(), 1560, i * 1000 / players.length + 20 + 30) ;
				g.drawString("Properties Owned:" , 1560, i * 1000 / players.length + 20 + 30 + 30 ) ;
			
				for (int j = 0; j < players[i].getPropertiesOwned().size(); j++) {
					g.drawString(properties[players[i].getPropertiesOwned().get(j)].getName(), 1560,
							i * 1000 / players.length + 100 + 20 * j);
				}
			}
			if (i == 1) {
				g.setColor(Color.GREEN);
				g.drawRect(1550, i * 1000 / players.length, 400, 1000 / players.length);
				g.setColor(Color.BLACK);
				g.drawString("Money: " + players[i].getMoney(), 1560, i * 1000 / players.length + 20);
				g.drawString("Position: " + properties[players[i].getPos()].getName(), 1560, i * 1000 / players.length + 20 + 30) ;
				g.drawString("Properties Owned:" , 1560, i * 1000 / players.length + 20 + 30 + 30 ) ;
				
				for (int j = 0; j < players[i].getPropertiesOwned().size(); j++) {
					g.drawString(properties[players[i].getPropertiesOwned().get(j)].getName(), 1560,
							i * 1000 / players.length + 100 + 20 * j);
				}
			}
			if (i == 2) {
				g.setColor(Color.ORANGE);
				g.drawRect(1550, i * 1000 / players.length, 400, 1000 / players.length);
				g.setColor(Color.BLACK);
				g.drawString("Money: " + players[i].getMoney(), 1560, i * 1000 / players.length + 20);
				for (int j = 0; j < players[i].getPropertiesOwned().size(); j++) {
					g.drawString(properties[players[i].getPropertiesOwned().get(j)].getName(), 1560,
							i * 1000 / players.length + 40 + 20 * j);
				}
			}
			if (i == 3) {
				g.setColor(Color.RED);
				g.drawRect(1550, i * 1000 / players.length, 400, 1000 / players.length);
				g.setColor(Color.BLACK);
				g.drawString("Money: " + players[0].getMoney(), 1560, i * 1000 / players.length + 20);
				g.drawString("Position: " + properties[players[i].getPos()].getName(), 1560, i * 1000 / players.length + 20 + 30) ;
				for (int j = 0; j < players[i].getPropertiesOwned().size(); j++) {
					g.drawString(properties[players[i].getPropertiesOwned().get(j)].getName(), 1560,
							i * 1000 / players.length + 40 + 20 * j);
				}
			}
		}

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
		int mx = (int) arg0.getX(); 
		int my = (int) arg0.getY(); 
		if(mx > 1150 & mx < 1250 && my > 30 && my < 90) { 
			roll();
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

		if (arg0.getKeyCode() == 82 && rollYet == false) {
			roll();
		}
		if (arg0.getKeyCode() == 84) {
			turn++;
			rollYet = false; 
		}
		if (arg0.getKeyCode() == 66) {
			buy();
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
