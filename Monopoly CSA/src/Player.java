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

	int pos = 0;
	int playerNumber;
	String avatar;  
	int money = 1500;
	ArrayList<Integer> propertiesOwned = new ArrayList<Integer>();
	int x;
	int y;
	private Image img; 	
	private AffineTransform tx;
	
	public Player(int playerNumber, String avatar) {
		this.playerNumber = playerNumber;
		this.avatar = avatar;

			img = getImage("/imgs/wall.png"); //load the image for Tree
			tx = AffineTransform.getTranslateInstance(x, y );
			init(x, y); 				//initialize the location of the image
								
			//use your variables
	}

		public void paint(Graphics g) {
			//these are the 2 lines of code needed draw an image on the screen
			Graphics2D g2 = (Graphics2D) g;
			
			
			//call update to update the actually picture location
			update();
			
			
			
			
			g2.drawImage(img, tx, null);
			
			

		}
		/* update the picture variable location */
		private void update() {

			
			
		}
		
		private void init(double a, double b) {
			tx.setToTranslation(a, b);
			tx.scale(2.7, 2.4);
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
	
	
	
	
	
	
	
	
	
}
