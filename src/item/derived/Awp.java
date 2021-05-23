package item.derived;

import constants.SoundHolder;
import item.base.Bullet;
import item.base.Weapon;
import javafx.scene.media.AudioClip;

public class Awp extends Weapon{

	public Awp() {
		super();
		this.setName("AWP");
		this.setMaxAmmo(15);
		this.setFireRate(1);
		this.setDamage(40);
		this.setBulletSpeed(40);
		this.setRange(1200);
		this.refillAmmo();
		System.out.println("AWP have been create");
	}

	@Override
	public void shoot(double x, double y, int side) {
		Bullet newBullet = new Bullet(3.0, 3.0, x, y);
		newBullet.setMaxRange(this.getRange());
		newBullet.setDamage(this.getDamage());
		newBullet.setSpeed_x(getBulletSpeed() * side);
		(new AudioClip(SoundHolder.getInstance().gunShot)).play();
	}
	
	
}
