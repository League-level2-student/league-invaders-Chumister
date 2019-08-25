import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class ObjectManager implements ActionListener {
	ArrayList<Projectile> Projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random;
	Rocketship ship;
	int score;
	ObjectManager(Rocketship rocket) {
		this.ship=rocket;
	score = 0;
	GamePanel panel;
	}
	
	void getscore(){
		int score;
	}

	 void addProjectile(Projectile projectile) {
		Projectiles.add(projectile);
	}

	 void addAlien() {

		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

	}

	 void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if (aliens.get(i).y > LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}
		}
		for (int a = 0; a < Projectiles.size(); a++) {
			Projectiles.get(a).update();
			if (Projectiles.get(a).y < 0) {
				Projectiles.get(a).isActive = false;
			}
		}
	checkCollision();
	purgeObjects();
	}
	

	void draw(Graphics g) {
		ship.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int a = 0; a < Projectiles.size(); a++) {
			Projectiles.get(a).draw(g);
		}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for (int a = 0; a < Projectiles.size(); a++) {
			if (Projectiles.get(a).isActive == false) {
				Projectiles.remove(a);
			}

		}
		

	}
	void checkCollision(){
		for (int i = 0; i < aliens.size(); i++) {
			if (ship.collisionBox.intersects(aliens.get(i).collisionBox)||Projectiles.get(i).collisionBox.intersects(aliens.get(i).collisionBox) ) {
				aliens.get(i).isActive=false;
				Projectiles.get(i).isActive=false;
			}

		}
		
	}

	
	public void addActionListener(GamePanel gamePanel) {
		// TODO Auto-generated method stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	}
