import java.awt.Color;
import java.awt.Graphics;

public class GameObject {
	int x;

    int y;

    int width;

    int height;
    
    int speed =0;
    
    boolean isActive=true;
	GameObject(int x, int y, int width, int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
	}

	void update() {
	y++;
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 100, 100);
	}
}
