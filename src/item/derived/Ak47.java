package item.derived;

import constants.SoundHolder;
import item.base.Bullet;
import item.base.Weapon;
import javafx.scene.media.AudioClip;

public class Ak47 extends Weapon{
	
	public Ak47() {
		super();
		this.setName("AK47");
		this.setMaxAmmo(30);
		this.setFireRate(12);
		this.setDamage(5);
		this.setBulletSpeed(30);
		this.setRange(600);
		this.refillAmmo();
	}

	@Override
	public void shoot(double x, double y, int side){
		Bullet newBullet = new Bullet(3.0, 3.0, x, y);
		newBullet.setDamage(this.getDamage());
		newBullet.setSpeed(this.getBulletSpeed());
		newBullet.setMaxRange(this.getRange());
		newBullet.setSpeed_x(getBulletSpeed() * side);
		(new AudioClip(SoundHolder.getInstance().gunShot)).play();
	}
}
