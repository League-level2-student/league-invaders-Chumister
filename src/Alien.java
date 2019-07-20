import java.awt.Graphics;
import java.awt.Color;

public class Alien extends GameObject {

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 1;
		
	}
void update() {
	y+=speed;
	
}
void draw(Graphics g) {
	g.setColor(Color.YELLOW);
	g.fillRect(x, y, width, height);
}
}
