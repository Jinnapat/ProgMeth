package item.derived;

import constants.SoundHolder;
import item.base.Bullet;
import item.base.Weapon;
import javafx.scene.media.AudioClip;

public class Shotgun extends Weapon {

	public Shotgun() {
		super();
		this.setName("Shotgun");
		this.setFireRate(5);
		this.setDamage(5);
		this.setBulletSpeed(30);
		this.setRange(400);
		this.refillAmmo();
	}

	@Override
	public void shoot(double x, double y, int side) {
		double maxDegree = Math.PI / 50;
		for (int i = 0; i < 5; i++) {
			double angle = (2 * maxDegree * Math.random()) - maxDegree;
			Bullet newBullet = new Bullet(3.0, 3.0, x, y);
			newBullet.setDamage(this.getDamage());
			newBullet.setSpeed(this.getBulletSpeed());
			newBullet.setMaxRange(this.getRange());
			newBullet.setSpeed_x(Math.cos(angle) * getBulletSpeed() * side);
			newBullet.setSpeed_y(Math.sin(angle) * getBulletSpeed());
			(new AudioClip(SoundHolder.getInstance().gunShot)).play();
		}
	}

}
