import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
public class GamePanel extends JPanel implements ActionListener, KeyListener{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	Rocketship Rocket = new Rocketship(250,700,50,50);

final int MENU = 0;
final int GAME = 1;
final int END = 2;
int currentState = MENU;
Timer timer;
Font titlefont;
Font textfont1;
Timer Alienspawn;
ObjectManager object;
	GamePanel(){
		if (needImage) {
		    loadImage ("space.png");
		}
		timer= new Timer(1000/60, this);
		titlefont = new Font("Arial", Font.PLAIN, 48);
	textfont1= new Font("Arial", Font.PLAIN, 24);
	object=new ObjectManager(Rocket);
	}
	
	@Override	
public void paintComponent(Graphics g) {
	if(currentState == MENU){
	    drawMenuState(g);
	}else if(currentState == GAME){
	    drawGameState(g);
	}else if(currentState == END){
	    drawEndState(g);
	}
}
void updateMenuState() {
	
}
void updateGameState() {
	object.update();
if (Rocket.isActive=false) {
	currentState=END;
}
}
void  updateEndState()  { 
	
}
void drawMenuState(Graphics g) { 
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(titlefont);
	g.setColor(Color.YELLOW);
	g.drawString("League Invaders", 100, 100);
	g.setFont(textfont1);
	g.drawString("Press ENTER to start", 100, 400);
	g.drawString("Press SPACE for intructions", 100, 600);
}
void drawGameState(Graphics g) {
	if (gotImage) {
		g.drawImage(image,0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT,this);
	} else {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}
object.draw(g);
}
void drawEndState(Graphics g)  {
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(titlefont);
	g.setColor(Color.YELLOW);
	g.drawString("GAME OVER YEAHHHH", 0, 100);
	g.setFont(textfont1);
	g.drawString("Try Again?", 100, 400);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	repaint();
}
void startGame() {
	timer = new Timer(1000/60, this);
	timer.start();
Alienspawn=new Timer(1000, object);
Alienspawn.start();
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		if(currentState == END){
			currentState=MENU;
		    
		}else {
			currentState++;
		}
		
	}   
	
	if (e.getKeyCode()==KeyEvent.VK_UP) {
		Rocket.up();
	    System.out.println("UP");
	}
	if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		Rocket.down();
	    System.out.println("DOWN");
	}
	if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		Rocket.right();
	    System.out.println("RIGHT");
	}
	if (e.getKeyCode()==KeyEvent.VK_LEFT) {
	  Rocket.left();
		System.out.println("LEFT");
	}
	if (e.getKeyCode()==KeyEvent.VK_SPACE) {
		object.addProjectile(Rocket.getProjectile());

	}
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Key typed");
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("key released");
	
}

}

