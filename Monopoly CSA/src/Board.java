


	

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


			
			// CREATE THE OBJECT (STEP 1)
			Random rnd = new Random();

			

			public void paint(Graphics g) {
				super.paintComponent(g);
			}

			private Image getImage(String string) {
				// TODO Auto-generated method stub
				return null;
			}

			public static void main(String[] arg) {
				Board f = new Board();
			}

			public Board() {

				Random rnd = new Random();
				
		
				

				JFrame f = new JFrame("DungeonCrawler");
				f.setSize(new Dimension(1900, 1200));
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
				if(MouseEvent.MOUSE_CLICKED == 500) {
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


