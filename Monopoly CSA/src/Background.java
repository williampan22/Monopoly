import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Background{
	

	private Image img; 	
	private AffineTransform tx;

	public Background(int x, int y) {
		//board image 
		img = getImage("/imgs/board.png"); 
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
		tx.scale(1, 1);
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
