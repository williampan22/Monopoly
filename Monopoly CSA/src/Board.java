
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

	Background bg = new Background(0, 0); // aaasaass
	Dice dice = new Dice(1150, -10);
	int gameChecker;
	int finalPlayer;
	
	Player player0 = new Player(0, 0, "Car.png", 53, 39, 0, 0);
	Player player1 = new Player(1, 0, "Dog.png", 48, 32, 0, 0);
	Player player2 = new Player(2, 0, "Hat.png", 0, 0, 0, 0);
	int turn = 0;
	int numPlayers = 2;
	boolean rollYet = false;
	boolean didBuy = false;
	boolean haveToPay = false;
	boolean enoughMoney = false;
	boolean onlyPayOnce = false;
	boolean arrived = false; 
	boolean triedToBuy = false; 
//	boolean bankrupt = false; 
	boolean mortgage = false; 
	int dice1;
	int dice2;
	int railRoadPay = 0;
	int utilitiesPay = 0;
	int mortgagePos; 
	boolean didMortgage = false; 
	
	
	
	
	// CREATE THE OBJECT (STEP 1)sssss
	Random rnd = new Random();
	// https://www.falstad.com/monopoly.html
	Property p0 = new Property("Go", -1, 890, 930, 0, -200); // special
	Property p1 = new Property("Mediterranean Avenue", -1, 825, 930, 60, 2);
	Property p2 = new Property("Community Chest", -1, 740, 930, 0, 0); // special - x diff is 85
	Property p3 = new Property("Baltic Avenue", -1, 660, 930, 60, 4);
	Property p4 = new Property("Income Tax", -1, 580, 930, 0, 200); // special
	Property p5 = new Property("Reading Railroad", -1, 500, 930, 200, 25); // special
	Property p6 = new Property("Oriental Avenue", -1, 416, 930, 100, 6);
	Property p7 = new Property("Chance", -1, 335, 930, 0, 0); // special
	Property p8 = new Property("Vermont Avenue", -1, 250, 930, 100, 6);
	Property p9 = new Property("Connecticut Avenue", -1, 167, 930, 100, 8);
	Property p10 = new Property("VISITING JAIL", -1, 55, 940, 0, 0); // special

	Property p11 = new Property("St. Charles Place", -1, 55, 790, 140, 10);
	Property p12 = new Property("Electric Company", -1, 55, 710, 150, 0); // utilities - y difference of 80
	Property p13 = new Property("States Avenue", -1, 55, 630, 140, 10);
	Property p14 = new Property("Virginia Avenue", -1, 55, 550, 160, 12);
	Property p15 = new Property("Pennsylvania Railroad", -1, 55, 470, 200, 25);// special
	Property p16 = new Property("St. James Place", -1, 55, 390, 180, 14);
	Property p17 = new Property("Community Chest", -1, 55, 310, 0, 0); // special
	Property p18 = new Property("Tennessee Avenue", -1, 55, 230, 180, 14);
	Property p19 = new Property("New York Avenue", -1, 55, 150, 200, 16);
	Property p20 = new Property("Free Parking", -1, 40, 55, 0, 0); // special

	Property p21 = new Property("Kentucky Avenue", -1, 200, 55, 220, 18);
	Property p22 = new Property("Chance", -1, 285, 55, 0, 0); // special
	Property p23 = new Property("Indiana Avenue", -1, 370, 55, 220, 18);
	Property p24 = new Property("Illinois Avenue", -1, 455, 55, 240, 20);
	Property p25 = new Property("B&O Railroad", -1, 540, 55, 200, 25); // special
	Property p26 = new Property("Atlantic Avenue", -1, 625, 55, 260, 22);
	Property p27 = new Property("Ventnor Avenue", -1, 710, 55, 260, 22);
	Property p28 = new Property("Water Works", -1, 795, 55, 150, 0); // utilities
	Property p29 = new Property("Marvin Gardens", -1, 880, 55, 280, 24);
	Property p30 = new Property("JAIL", -1, 940, 30, 0, 0); // special

	Property p31 = new Property("Pacific Avenue", -1, 940, 190, 300, 26);
	Property p32 = new Property("North Carolina Avenue", -1, 940, 270, 300, 26);
	Property p33 = new Property("Community Chest", -1, 940, 350, 0, 0); // special
	Property p34 = new Property("Pennsylvania Avenue", -1, 940, 430, 320, 28);
	Property p35 = new Property("Short Line", -1, 940, 510, 200, 25);
	Property p36 = new Property("Chance", -1, 940, 590, 0, 0); // special
	Property p37 = new Property("Park Place", -1, 940, 670, 350, 38);
	Property p38 = new Property("Luxury Tax", -1, 940, 750, 0, -100); // special
	Property p39 = new Property("Boardwalk", -1, 940, 830, 400, 50);

	Property[] properties = { p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19,
			p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39 };

	Player[] players = { player0, player1, player2 };

	public int dice() {
		int dice1 = (int) (Math.random() * 6 + 1); // a
		int dice2 = (int) (Math.random() * 6 + 1);
		this.dice1 = dice1;
		this.dice2 = dice2;
		return dice1 + dice2;
		
	}

	public void roll() {
		
		players[turn].setArrived(false);
		int original = players[turn].getPos();
//		if(original == 10) {
//			players[turn].setVx(10);
//		}
		players[turn].setNewPosition(original + dice());

		
		if (players[turn].getNewPosition() >= 40) {
			players[turn].setMoney(players[turn].getMoney() + 200);
			players[turn].setNewPosition(players[turn].getNewPosition() - 40);
		}
		rollYet = true;
		didBuy = false;
		haveToPay = false;
		onlyPayOnce = false;
		arrived = false; 
		didMortgage = false; 
		triedToBuy = false; 
		
		
		if (properties[players[turn].getNewPosition()].getOwner() != -1) {
			haveToPay = true;
		}
 
	}

	public void buy() {
		if (players[turn].getNewPosition() != 0 && players[turn].getNewPosition() != 2
				&& players[turn].getNewPosition() != 4 && players[turn].getNewPosition() != 7
				&& players[turn].getNewPosition() != 10 && players[turn].getNewPosition() != 17
				&& players[turn].getNewPosition() != 20 && players[turn].getNewPosition() != 22
				&& players[turn].getNewPosition() != 30 && players[turn].getNewPosition() != 33
				&& players[turn].getNewPosition() != 36 && players[turn].getNewPosition() != 38
				&& properties[players[turn].getNewPosition()].getOwner() == -1) {

			if ((players[turn].getMoney() >= properties[players[turn].getNewPosition()].getPrice())) {

				players[turn]
						.setMoney(players[turn].getMoney() - properties[players[turn].getNewPosition()].getPrice());
				players[turn].propertiesOwned.add(players[turn].getNewPosition());
				properties[players[turn].getNewPosition()].setOwner(turn);
				enoughMoney = true;

				// railroads
				if (players[turn].getNewPosition() == 5 || players[turn].getNewPosition() == 15
						|| players[turn].getNewPosition() == 25 || players[turn].getNewPosition() == 35) {
					players[turn].setNumRailRoads(players[turn].getNumRailRoads() + 1);
				}
				
				if (players[turn].getPos() == 12 || players[turn].getPos() == 28) {
					players[turn].setNumUtilities(players[turn].getNumUtilities() + 1);
				}

			} else {
				enoughMoney = false;
			}

			didBuy = true;

		}
		triedToBuy = true; 
	}

	public void passGo() { 
		
	}
	
	
	public void pay() {

		// take money away
		players[turn].setMoney(players[turn].getMoney() - properties[players[turn].getNewPosition()].getPay());

		// give money
		players[properties[players[turn].getNewPosition()].getOwner()]
				.setMoney(players[properties[players[turn].getNewPosition()].getOwner()].getMoney()
						+ properties[players[turn].getNewPosition()].getPay());
		onlyPayOnce = true;
		System.out.println(turn + "paid" + properties[players[turn].getNewPosition()].getPay());

	}

	public int payRailRoad() {

		int railRoadPay = 0;

		if (players[properties[players[turn].getNewPosition()].getOwner()].getNumRailRoads() == 1) {
			railRoadPay = 25;
		}
		if (players[properties[players[turn].getNewPosition()].getOwner()].getNumRailRoads() == 2) {
			railRoadPay = 50;
		}
		if (players[properties[players[turn].getNewPosition()].getOwner()].getNumRailRoads() == 3) {
			railRoadPay = 100;
		}
		if (players[properties[players[turn].getNewPosition()].getOwner()].getNumRailRoads() == 4) {
			railRoadPay = 400;
		}

		players[turn].setMoney(players[turn].getMoney() - railRoadPay);

		// give money
		players[properties[players[turn].getNewPosition()].getOwner()]
				.setMoney(players[properties[players[turn].getNewPosition()].getOwner()].getMoney() + railRoadPay);
		onlyPayOnce = true;

		return railRoadPay;
	}

	public int payUtilities() {

		int utilitiesPay = 0;

		if (players[properties[players[turn].getNewPosition()].getOwner()].getNumUtilities() == 1) {
			utilitiesPay = (dice1 + dice2) * 4;
		}
		if (players[properties[players[turn].getNewPosition()].getOwner()].getNumUtilities() == 2) {
			utilitiesPay = (dice1 + dice2) * 10;
		}

		players[turn].setMoney(players[turn].getMoney() - utilitiesPay);
		players[properties[players[turn].getNewPosition()].getOwner()]
				.setMoney(players[properties[players[turn].getNewPosition()].getOwner()].getMoney() + utilitiesPay);
		onlyPayOnce = true;
		
		
		return utilitiesPay;
	}

	public void luxuryTax() {
		players[turn].setMoney(players[turn].getMoney() - 100);
		onlyPayOnce = true;
	}

	public void incomeTax() {
		players[turn].setMoney(players[turn].getMoney() - 200);
		onlyPayOnce = true;
	}
	
	public void mortgage() { 
		
		
			
		
		
		players[turn].setMoney(players[turn].getMoney() + properties[mortgagePos].getPrice() / 2 );
		properties[mortgagePos].setOwner(-1);
		didMortgage = true; 
		for(int i = 0; i < players[turn].getPropertiesOwned().size(); i++) { 
			if(players[turn].getPropertiesOwned().get(i) == mortgagePos) { 
				players[turn].getPropertiesOwned().remove(i);
				break;
			}
			
			
		}
		
		
		
	}
	
	public void bankruptcy() { 
		
	}
	
	

	public void paint(Graphics g) {
		super.paintComponent(g);
		
		
		
		
		
//		System.out.println("mortgage " + mortgage);
//		System.out.println("bankrupt " + bankrupt);
//		System.out.println("mortgage Pos  " + mortgagePos);
		

			bg.paint(g);
		
		g.setFont(new Font("Times New Roman", Font.BOLD, 20));
		for(int i = 0; i < players.length; i++) { 
			if(players[i].getMoney() < 0 ) { 
				g.drawString("Player " + i + " HAS NEGATIVE MONEY!!  " , 1045, 600);
				g.drawString("DECLARE BANKRUPTCY OR RAISE MONEY BY:  " , 1045, 625);
				g.drawString("Morgagting Property to Bank (for half price paid) "  , 1045, 650);
				players[turn].setBankrupt(true);
			}
		}
		
		if(properties[mortgagePos].getOwner() == turn) { 
			mortgage();
		}
		
		
		
		g.setFont(new Font("Times New Roman", Font.BOLD, 15));
		if(didMortgage ) { 
			g.drawString("Player " + turn + " Mortgaged " + properties[mortgagePos].getName() + " For $" + properties[mortgagePos].getPrice() /2 
					+ " And No Longer Owns It!", 1020, 500);
		}
		
		g.setFont(new Font("Times New Roman", Font.BOLD, 20));
//		System.out.println("0 Pos " + players[0].getPos()); 
//		System.out.println("1 Pos " + players[1].getPos()); 
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

		
		for(int p = 0, isIn = 0; p < players.length; p++) {
			if(players[p].isBankrupt() == false) {
				isIn++;
				players[p].paint(g);
			}
			gameChecker = isIn;
		}
		
		if (turn >= numPlayers) {
			turn = 0;
		}
			
		
		// player2.paint(g);

		
		//MOVEMENT CODE
		if (players[turn].getNewPosition() <= 20 && !(players[turn].getX() <= 20
				+ properties[players[turn].getNewPosition()].getX() - players[turn].getWidth() / 2
				&& players[turn].getX() >= -20 + properties[players[turn].getNewPosition()].getX()
						- players[turn].getWidth() / 2)) {
			players[turn].setVx(-10);
			players[turn].setBounceY((int) (40 * Math.cos(.03 * players[turn].getX())));
		}

		if (players[turn].getPos() == 10) {
			players[turn].setBounceX(-40);
		}

		if (players[turn].getNewPosition() <= 30 && players[turn].getNewPosition() > 10
				&& !(players[turn].getY() <= 20 + properties[players[turn].getNewPosition()].getY()
						&& players[turn].getY() >= -20 + properties[players[turn].getNewPosition()].getY())) {
			players[turn].setVy(-10);
			players[turn].setBounceX((int) (40 * Math.cos(.03 * players[turn].getY())));
		}

		if (players[turn].getNewPosition() <= 39 && players[turn].getNewPosition() > 20
				&& !(players[turn].getX() <= 20 + properties[players[turn].getNewPosition()].getX()
						- players[turn].getWidth() / 2
						&& players[turn].getX() >= -20 + properties[players[turn].getNewPosition()].getX()
								- players[turn].getWidth() / 2)) {
			players[turn].setVx(10);
			players[turn].setBounceY((int) (40 * Math.cos(.03 * players[turn].getX())));
		}

		if (((players[turn].getNewPosition() <= 39 && players[turn].getNewPosition() > 30)
				|| players[turn].getNewPosition() <= 10)
				&& !(players[turn].getY() <= 20 + properties[players[turn].getNewPosition()].getY()
						&& players[turn].getY() >= -20 + properties[players[turn].getNewPosition()].getY())) {
			players[turn].setVy(10);
			players[turn].setBounceX((int) (40 * Math.cos(.03 * players[turn].getY())));
		}

		if (players[turn].getX() <= 20 + properties[players[turn].getNewPosition()].getX()
				- players[turn].getWidth() / 2
				&& players[turn].getX() >= -20 + properties[players[turn].getNewPosition()].getX()
						- players[turn].getWidth() / 2) {
			players[turn].setVx(0);
			players[turn].setPos(players[turn].getNewPosition());
			players[turn].setArrived(true);
		}

		if (players[turn].getY() <= 20 + properties[players[turn].getNewPosition()].getY()
				&& players[turn].getY() >= -20 + properties[players[turn].getNewPosition()].getY()) {
			players[turn].setVy(0);
			players[turn].setPos(players[turn].getNewPosition());
			players[turn].setArrived(true);
		}
		
		if ((players[turn].getX() <= 20 + properties[players[turn].getNewPosition()].getX()
				- players[turn].getWidth() / 2
				&& players[turn].getX() >= -20 + properties[players[turn].getNewPosition()].getX()
						- players[turn].getWidth() / 2) && ((players[turn].getY() <= 20 + properties[players[turn].getNewPosition()].getY()
				&& players[turn].getY() >= -20 + properties[players[turn].getNewPosition()].getY()))){
					
				}

		if(players[turn].getArrived() == true && players[turn].getPos() == 30) {
			players[turn].setNewPosition(10);
			players[turn].setX(40);
			players[turn].setY(920);
		}
		
		if (players[turn].getX() > 50 && players[turn].getPos() < 10) {
			players[turn].setVy(0);
		}

		if (players[turn].getX() < 890 && (players[turn].getPos() >= 20 && players[turn].getPos() < 30)) {
			players[turn].setVy(0);
		}

		if (players[turn].getY() > 80 && (players[turn].getPos() >= 10 && players[turn].getPos() < 20)) {
			players[turn].setVx(0);
		}

		if (players[turn].getY() < 910 && (players[turn].getPos() >= 30 && players[turn].getPos() <= 39)) {
			players[turn].setVx(0);
		}


		if(gameChecker == 1) {
			for(int i = 0; i < players.length; i++) {
				if(players[i].isBankrupt() == false) {
					finalPlayer = i;
				}
			}
			
			g.setFont(new Font("Times New Roman", Font.BOLD, 100));
			
			g.drawString("Player " + finalPlayer, 1100, 200);
			g.drawString("Wins!", 1100, 400);
			
			players[finalPlayer].setNewPosition(10);
			if(players[finalPlayer].getArrived() == true && players[finalPlayer].getPos() == 10) {
				players[finalPlayer].setNewPosition(20);
			}
			if(players[finalPlayer].getArrived() == true && players[finalPlayer].getPos() == 20) {
				players[finalPlayer].setNewPosition(31);
			}
			if(players[finalPlayer].getArrived() == true && players[finalPlayer].getPos() == 31) {
				players[finalPlayer].setNewPosition(38);
			}
			if(players[finalPlayer].getArrived() == true && players[finalPlayer].getPos() == 39) {
				players[finalPlayer].setNewPosition(players[finalPlayer].getNewPosition() + 10);
			}
		}
		
		if(gameChecker > 1) {
		
			

		g.setFont(new Font("Times New Roman", Font.BOLD, 50));

		g.drawString("Player " + turn + "'s Turn", 1045, 150);

		g.setFont(new Font("Times New Roman", Font.BOLD, 20));

		if (rollYet) {
			g.drawString("Dice 1: " + dice1, 1045, 180); // dice
			g.drawString("Dice 2: " + dice2, 1150, 180);
			g.drawString("Total Distance: " + (dice1 + dice2), 1250, 180);
		}

		if (players[turn].getNewPosition() == 0 && rollYet) {

			g.drawString("You are on GO!", 1045, 200);

		}

		else if (players[turn].getNewPosition() == 10 && rollYet) {

			g.drawString("Visiting JAIL!", 1045, 200);

		}

		else if (players[turn].getNewPosition() == 20 && rollYet) {

			g.drawString("ON FREE PARKING!", 1045, 200);

		}

		else if (players[turn].getNewPosition() == 30 && rollYet) {

			g.drawString("Going to JAIL!", 1045, 200);

		}

		else if ((players[turn].getNewPosition() == 7 || players[turn].getNewPosition() == 22
				|| players[turn].getNewPosition() == 36) && rollYet) {

			g.drawString("Landed on Chance! Draw a Card!", 1045, 200);

		}

		else if ((players[turn].getNewPosition() == 2 || players[turn].getNewPosition() == 17
				|| players[turn].getNewPosition() == 33) && rollYet) {

			g.drawString("Landed on Community Chest! Draw a Card!", 1045, 200);

		}

		else if (players[turn].getNewPosition() == 4 && rollYet) {

			g.drawString("INCOME TAX! PAY $200!", 1045, 200);

			if (!onlyPayOnce) {
				incomeTax();
			}
		}

		else if (players[turn].getNewPosition() == 38 && rollYet) {

			g.drawString("LUXURY TAX! PAY $100!", 1045, 200);

			if (!onlyPayOnce) {
				luxuryTax();
			}

		}

		else if (!didBuy && rollYet && properties[players[turn].getNewPosition()].getOwner() == turn) {

			g.setFont(new Font("Times New Roman", Font.BOLD, 40));
			g.drawString("Player " + turn + " Landed On His Own Property, "
					+ properties[players[turn].getNewPosition()].getName() + "!", 1045, 225);

		}

		
		else if (properties[players[turn].getNewPosition()].getOwner() == -1 && rollYet && players[turn].getArrived() == true) {

			g.drawString("Do You Want To Buy " + properties[players[turn].getNewPosition()].getName() + "?", 1045, 225);
			g.drawString("It Will Cost $" + properties[players[turn].getNewPosition()].getPrice(), 1045, 250);
			
			g.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(10));
			g.setFont(new Font("Times New Roman", Font.BOLD, 90));
			
			if(!triedToBuy) {
			g.drawRect(1175, 290, 200, 100);
			g.drawString("Buy", 1190, 360);
			}
		}
		
		g2.setStroke(new BasicStroke(5));
		g.setFont(new Font("Times New Roman", Font.BOLD, 40));

		if (turn >= numPlayers) {
			turn = 0;
		}

		if(rollYet && !players[turn].getArrived()) {
			dice.paint(g);
		}
		
		if (rollYet && players[turn].getArrived()) {
			g.drawString("Rolled! End Turn!", 1045, 450);
			
			g.setColor(Color.BLACK);
			
			g2.setStroke(new BasicStroke(5));
			g.setFont(new Font("Times New Roman", Font.BOLD, 40));
			
			g.drawRect(1180, 30, 185, 60);
			g.drawString("End Turn", 1190, 70);
			
		}

		if (!rollYet) {
			
			g.setColor(Color.BLACK);
			
			g2.setStroke(new BasicStroke(5));
			g.setFont(new Font("Times New Roman", Font.BOLD, 40));
			g.drawRect(1200, 30, 100, 60);
			g.drawString("Roll", 1215, 70);
			g.drawString("Player " + turn + "! Roll!", 1045, 200);
		}
		

		for (int i = 0; i < properties.length; i++) {
			if (properties[i].getOwner() == 0) {
				g.setColor(Color.BLUE);
				g.drawRect(properties[i].getX(), properties[i].getY() + 10, 5, 5);
			}
			if (properties[i].getOwner() == 1) {
				g.setColor(Color.GREEN);
				g.drawRect(properties[i].getX(), properties[i].getY() + 10, 5, 5);
			}
			if (properties[i].getOwner() == 2) {
				g.setColor(Color.ORANGE);
				g.drawRect(properties[i].getX(), properties[i].getY() + 10, 5, 5);
			}
		}

		// UI CODDE

		g.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		if (didBuy && rollYet) {

			if (enoughMoney) {
				g.drawString("Player " + turn + " Bought " + properties[players[turn].getNewPosition()].getName()
						+ " For $" + properties[players[turn].getNewPosition()].getPrice() + "!", 1045, 250);
			} else {
				g.drawString("Player " + turn + " CANNOT BUY " + properties[players[turn].getNewPosition()].getName()
						+ " For $" + properties[players[turn].getNewPosition()].getPrice() + "!", 1045, 300);
				g.drawString("NOT ENOUGH MONEY!!", 1045, 350);
			}

		}

		g.setFont(new Font("Times New Roman", Font.BOLD, 14));

		if (haveToPay && arrived && turn != properties[players[turn].getNewPosition()].getOwner()) {

			if (players[turn].getNewPosition() == 5 || players[turn].getNewPosition() == 15 || players[turn].getNewPosition() == 25
					|| players[turn].getNewPosition() == 35 ) {
					if (!onlyPayOnce) {
						railRoadPay = payRailRoad();
					}
					g.drawString("Player " + turn + " Landed On " + properties[players[turn].getNewPosition()].getName()
							+ " And Has to Pay Player " + properties[players[turn].getNewPosition()].getOwner() + " For $"
							+ railRoadPay + "!", 1045, 250);
				
				
				
			}else if(players[turn].getNewPosition() == 12 || players[turn].getNewPosition() == 28) { 
				if (!onlyPayOnce) {
					utilitiesPay = payUtilities();
				}
				g.drawString("Player " + turn + " Landed On " + properties[players[turn].getNewPosition()].getName()
						+ " And Has to Pay Player " + properties[players[turn].getPos()].getOwner() + " For $"
						+ utilitiesPay + "!", 1045, 250);
			}else { 
				if (!onlyPayOnce) {
					pay();
				}

				g.drawString("Player " + turn + " Landed On " + properties[players[turn].getNewPosition()].getName()
						+ " And Has to Pay Player " + properties[players[turn].getPos()].getOwner() + " For $"
						+ properties[players[turn].getPos()].getPay() + "!", 1045, 250);
			}
			

		}

		if (turn == 0) {
			g.setColor(Color.BLUE);
		}
		if (turn == 1) {
			g.setColor(Color.GREEN);
		}

		 g2.setStroke(new BasicStroke(10));
			g.drawRect(1010, 10, 525, 972);
	

		//g2.setStroke(new BasicStroke(10));

		g.setFont(new Font("Times New Roman", Font.BOLD, 20));

		for (int i = 0; i < players.length; i++) {
			g.drawLine(1550, i * 1000 / players.length, 1900, i * 1000 / players.length);

			// g.fillRect(1550, i*1000/players.length-1000/players.length, 400,
			// 1000/players.length);

			if (i == 0) { 
				
				if(players[i].isBankrupt() == false) {
				g.setColor(Color.BLUE);
				g.drawRect(1550, i * 1000 / players.length, 400, 1000 / players.length);
				g.setColor(Color.BLACK);
				g.drawString("Money: " + players[i].getMoney(), 1560, i * 1000 / players.length + 20);
				g.drawString("Position: " + properties[players[i].getNewPosition()].getName(), 1560,
						i * 1000 / players.length + 20 + 30);
				g.drawString("Properties Owned:", 1560, i * 1000 / players.length + 20 + 30 + 30);

				for (int j = 0; j < players[i].getPropertiesOwned().size(); j++) {
					g.drawString(properties[players[i].getPropertiesOwned().get(j)].getName(), 1560,
							i * 1000 / players.length + 100 + 20 * j);
				}
				}
				else {
					g.setFont(new Font("Times New Roman", Font.BOLD, 40));
					g.setColor(Color.GRAY);
					g.drawRect(1550, i * 1000 / players.length, 400, 1000 / players.length);
					g.setColor(Color.BLACK);
					g.drawString("OUT", 1560,
							i * 1000 / players.length + 20 + 30);
				}
			}
			if (i == 1) {
				if(players[i].isBankrupt() == false) {
				g.setColor(Color.GREEN);
				g.drawRect(1550, i * 1000 / players.length, 400, 1000 / players.length);
				g.setColor(Color.BLACK);
				g.drawString("Money: " + players[i].getMoney(), 1560, i * 1000 / players.length + 20);
				g.drawString("Position: " + properties[players[i].getNewPosition()].getName(), 1560,
						i * 1000 / players.length + 20 + 30);
				g.drawString("Properties Owned:", 1560, i * 1000 / players.length + 20 + 30 + 30);

				for (int j = 0; j < players[i].getPropertiesOwned().size(); j++) {
					g.drawString(properties[players[i].getPropertiesOwned().get(j)].getName(), 1560,
							i * 1000 / players.length + 100 + 20 * j);
				}
				}
				else {
					g.setFont(new Font("Times New Roman", Font.BOLD, 40));
					g.setColor(Color.GRAY);
					g.drawRect(1550, i * 1000 / players.length, 400, 1000 / players.length);
					g.setColor(Color.BLACK);
					g.drawString("OUT", 1560,
							i * 1000 / players.length + 20 + 30);
				}
			}
			if (i == 2) {
				if(players[i].isBankrupt() == false) {
				g.setColor(Color.ORANGE);
				g.drawRect(1550, i * 1000 / players.length, 400, 1000 / players.length);
				g.setColor(Color.BLACK);
				g.drawString("Money: " + players[i].getMoney(), 1560, i * 1000 / players.length + 20);
				for (int j = 0; j < players[i].getPropertiesOwned().size(); j++) {
					g.drawString(properties[players[i].getPropertiesOwned().get(j)].getName(), 1560,
							i * 1000 / players.length + 40 + 20 * j);
				}
				}
				else {
					g.setFont(new Font("Times New Roman", Font.BOLD, 40));
					g.setColor(Color.GRAY);
					g.drawRect(1550, i * 1000 / players.length, 400, 1000 / players.length);
					g.setColor(Color.BLACK);
					g.drawString("OUT", 1560,
							i * 1000 / players.length + 20 + 30);
				}
			}
			if (i == 3) {
				if(players[i].isBankrupt() == false) {
				g.setColor(Color.RED);
				g.drawRect(1550, i * 1000 / players.length, 400, 1000 / players.length);
				g.setColor(Color.BLACK);
				g.drawString("Money: " + players[0].getMoney(), 1560, i * 1000 / players.length + 20);
				g.drawString("Position: " + properties[players[i].getNewPosition()].getName(), 1560,
						i * 1000 / players.length + 20 + 30);
				for (int j = 0; j < players[i].getPropertiesOwned().size(); j++) {
					g.drawString(properties[players[i].getPropertiesOwned().get(j)].getName(), 1560,
							i * 1000 / players.length + 40 + 20 * j);
				}
				}
				else {
					g.setFont(new Font("Times New Roman", Font.BOLD, 40));
					g.setColor(Color.GRAY);
					g.drawRect(1550, i * 1000 / players.length, 400, 1000 / players.length);
					g.setColor(Color.BLACK);
					g.drawString("OUT", 1560,
							i * 1000 / players.length + 20 + 30);
				}
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
		 System.out.println(mx + " " + my);
		 
		
		 if (mx >= 1200 & mx <= 1310 && my >= 60 && my <= 120 && !rollYet) {
				roll();
			}
			
			if (players[turn].getArrived() && mx >= 1180 & mx <= 1380 && my >= 60 && my <= 120 && rollYet && players[turn].getArrived()) {
				if(players[turn].getMoney() <= 0) {
					players[turn].setBankrupt(true);
				}
				turn++;
				rollYet = false;
			}
				

			if (mx >= 1180 & mx <= 1390 && my >= 315 && my <= 430) {
				buy();
			}

		 
//		 
//		if (!players[turn].isBankrupt() && arrived && mx >= 1040 & mx <= 1140 && my >= 60 && my <= 118) {
//			buy();
//		}
//
//		if (!players[turn].isBankrupt() &&  rollYet == false && mx >= 1157 & mx <= 1257 && my >= 60 && my <= 118) {
//			roll();
//		}
//
//		if (!players[turn].isBankrupt() && arrived && rollYet  && mx >= 1278 & mx <= 1460 && my >= 60 && my <= 118) {
//			turn++;
//			rollYet = false;
//
//		}
		
		if (players[turn].isBankrupt() && mortgage) { 
			 
			
			if(my <= 165 && my >= 0 ) { 
				int counter = 21; 
				for(int x =139; counter < 30; x+= 81, counter++) { 
					if(mx >= x && mx <= x + 81) { 
						mortgagePos = counter; 
						System.out.println("mortgage " + counter); 
						
					}
				}
			}
			
			 if(my >= 897 && my <= 1050 ) { 
				int counter = 9; 
				for(int x = 139; counter > 0; x+= 81, counter--) { 
					if(mx >= x && mx <= x + 81) { 
						mortgagePos = counter; 
						System.out.println("mortgage " + counter); 
					}
				}
			}
		}
		
		 if(mx <= 140 && mx >= 0 ) { 
			int counter = 10; 
			for(int y = 898; counter < 20; y-= 80, counter++) { 
				if(my >= y && my <= y + 81) { 
					mortgagePos = counter; 
					System.out.println("mortgage " + counter); 
					
				}
			}
		}
		 if(mx <= 1011 && mx >= 875 ) { 
			int counter = 31; 
			for(int y = 161; counter < 40; y+= 80, counter++) { 
				if(my >= y && my <= y + 81) { 
					mortgagePos = counter; 
					System.out.println("mortgage " + counter); 
					
				}
			}
		}
		
			                        
		}
		
		
		
	//}

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
		// System.out.println(arg0.getKeyCode());

//		if (arg0.getKeyCode() == 82 && rollYet == false) {
//			roll();
//		}
//		if (arg0.getKeyCode() == 84) {
//			turn++;
//			rollYet = false;
//		}
//		if (arg0.getKeyCode() == 66) {
//			buy();
//		}

//		if (mortgage && arg0.getKeyCode() == 77) {
//			mortgage = false; 
//			System.out.println("mortgage " + mortgage);
//		}
//		
		if (!mortgage && arg0.getKeyCode() == 77) {
			mortgage = true; 
			System.out.println("mortgage " + mortgage);
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
