import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Dice{
	
	
	private Image img; 	
	private AffineTransform tx;

	public Dice(int x, int y) {
		img = getImage("/imgs/dice rolling gif.gif"); 
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				
	}

	
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		
		
		update();
		
		
		
		
		g2.drawImage(img, tx, null);
		
		

	}
	/* update the picture variable location */
	private void update() {

		
		
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

}
	
  