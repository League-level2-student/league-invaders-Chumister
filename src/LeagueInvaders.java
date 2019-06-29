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
	Invaders.setSize(WIDTH,HEIGHT);
	Invaders.setVisible(true);

	Invaders.add(Background);
	Invaders.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
