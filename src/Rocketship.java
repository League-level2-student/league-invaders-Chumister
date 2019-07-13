import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	
	Rocketship(int x, int y, int width, int height) {
		super(250,700,50,50);
		// TODO Auto-generated constructor stub
		speed=10;
		
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(250,700,50,50);
	}
	public void right() {
		x+=speed;
	}
	public void left() {
		x-=speed;
	}
	public void up() {
		y-=speed;
	}
	public void down() {
		y+=speed;
	}
}
