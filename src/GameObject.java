import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;

    int y;

    int width;

    int height;
    
    int speed=0;
    
    Rectangle collisionBox;
    
    boolean isActive=true;
	GameObject(int x, int y, int width, int height){
	    collisionBox= new Rectangle (x,y,width, height);
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	void update() {
	    collisionBox.setBounds(x,y,width,height);


	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 100, 100);
	}
}
