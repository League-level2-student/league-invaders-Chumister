import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
GamePanel Background;
JFrame Invaders;
LeagueInvaders (){
	Background= new GamePanel();
	Invaders = new JFrame();
}
public static final int HEIGHT= 800;
public static final int WIDTH = 500;
public static void main(String[] args) {
	LeagueInvaders Aliens = new LeagueInvaders();

	Aliens.setup();

}

void setup(){	 
	Invaders.add(Background);
	Invaders.setSize(WIDTH,HEIGHT);
	Invaders.setVisible(true);
	Invaders.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Invaders.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
    Invaders.addKeyListener(Background);
	Invaders.pack();
    Background.startGame();
    
}
}
