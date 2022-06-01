import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player {

	//player variables
	int pos = 0;
	int playerNumber;
	String avatar;  
	int money = 1500;
	ArrayList<Integer> propertiesOwned = new ArrayList<Integer>();
	int x = 920; 
	int y = 900;
	private Image img; 	
	private AffineTransform tx;
	int width; 
	int height;
	int numRailRoads; 
	int newPosition;
	int bounceY = 0;
	int bounceX = 0;
	int vx = 0;
	int vy = 0;
	int numUtilities;
	boolean bankrupt = false;
	boolean arrived = true;
	boolean isIn = true;
	int inJail = 0;
	
	
	//getters, setters
	public int getInJail() {
		return inJail;
	}

	public void setInJail(int inJail) {
		this.inJail = inJail;
	}

	public boolean isIn() {
		return isIn;
	}

	public void setIn(boolean isIn) {
		this.isIn = isIn;
	}

	public boolean getArrived() {
		return arrived;
	}

	public void setArrived(boolean arrived) {
		this.arrived = arrived;
	}
	

	public boolean isBankrupt() {
		return bankrupt;
	}

	public void setBankrupt(boolean bankrupt) {
		this.bankrupt = bankrupt;
	}

	public Player(int playerNumber, int pos, String avatar, int width, int height, int numRailRoads, int numUtilities) {
		this.playerNumber = playerNumber;
		this.avatar = avatar;
			img = getImage("/imgs/" + avatar); 
			tx = AffineTransform.getTranslateInstance(x, y );
			this.pos = pos;
			this.width = width; 
			this.height = height;
			this.numRailRoads = 0; 
			this.numUtilities = 0; 
			init(x, y); 				
			
			
	}

		public void paint(Graphics g) {
			
			Graphics2D g2 = (Graphics2D) g;
			
			
		
			update();
			
			
			
			
			g2.drawImage(img, tx, null);
			
			

		}
	
		private void update() {

			tx.setToTranslation(x + bounceX, y + bounceY);
			tx.scale(0.3, 0.3);
			x+=vx;
			y+=vy; 
			
		}
		
		public int getNewPosition() {
			return newPosition;
		}

		public void setNewPosition(int newPosition) {
			this.newPosition = newPosition;
		}

		public int getBounceY() {
			return bounceY;
		}

		public void setBounceY(int bounceY) {
			this.bounceY = bounceY;
		}

		public int getBounceX() {
			return bounceX;
		}

		public void setBounceX(int bounceX) {
			this.bounceX = bounceX;
		}

		public int getVx() {
			return vx;
		}

		public void setVx(int vx) {
			this.vx = vx;
		}

		public int getVy() {
			return vy;
		}

		public void setVy(int vy) {
			this.vy = vy;
		}

		private void init(double a, double b) {
			tx.setToTranslation(a, b);
			tx.scale(.3, .3);
		}

		private Image getImage(String path) {
			Image tempImage = null;
			try {
				URL imageURL = Background.class.getResource(path);
				tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tempImage;
		}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public ArrayList<Integer> getPropertiesOwned() {
		return propertiesOwned;
	}

	public void setPropertiesOwned(ArrayList<Integer> propertiesOwned) {
		this.propertiesOwned = propertiesOwned;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getNumRailRoads() {
		return numRailRoads;
	}

	public void setNumRailRoads(int numRailRoads) {
		this.numRailRoads = numRailRoads;
	}
	
	public int getNumUtilities() {
		return numUtilities;
	}

	public void setNumUtilities(int numUtilities) {
		this.numUtilities = numUtilities;
	}
	
	
	
}
