import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
@Override	
public void paintComponent(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(10, 10, 100, 100);

}
final int MENU = 0;
final int GAME = 1;
final int END = 2;
int currentState = MENU;
}

