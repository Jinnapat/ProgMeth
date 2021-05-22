package item.derived;

import item.base.Bullet;
import item.base.Weapon;

public class Shotgun extends Weapon {

	public Shotgun() {
		super();
		
	}

	@Override
	public void shoot(double x, double y, int side) {
		double maxDegree = Math.PI / 50;
		for (int i = 0; i < 4; i++) {
			double angle = (2 * maxDegree * Math.random()) - maxDegree;
			Bullet newBullet = new Bullet(3.0, 3.0, x, y);
			newBullet.setDamage(5);
			newBullet.setSpeed(3.0);
			newBullet.setSpeed_x(Math.cos(angle) * getBulletSpeed() * side);
			newBullet.setSpeed_y(Math.sin(angle) * getBulletSpeed());
		}
	}

}
