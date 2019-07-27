import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<Projectile> Projectiles;
	ArrayList<Alien> aliens;
	Random random;
	Rocketship ship;
	ObjectManager(Rocketship rocket) {
		this.ship=rocket;
		Projectiles = new ArrayList<Projectile>();
		aliens = new ArrayList<Alien>();
	}

	void addProjectile() {
		Projectiles.add(new Projectile(random.nextInt(LeagueInvaders.HEIGHT), 0, 50, 50));

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

}
