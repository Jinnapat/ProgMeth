package item.derived;

import constants.ImageHolder;
import constants.SoundHolder;
import item.base.Bullet;
import item.base.Weapon;
import javafx.scene.media.AudioClip;
import logic.ImageLogic;

public class Awp extends Weapon{

	public Awp() {
		super();
		this.setName("AWP");
		this.setMaxAmmo(100);
		this.setFireRate(10);
		this.setDamage(100);
		this.setBulletSpeed(10);
		this.setRange(10);
		this.refillAmmo();
		
		this.setX(300);
		this.setY(400);
		
		ImageLogic.resizeAndsetSprite(this, ImageHolder.getInstance().awp,100, 30);
		this.setWidth(50);
		this.setHeight(30);
		System.out.println("AWP have been create");
	}

	@Override
	public void shoot(double x, double y, int side) {
		Bullet newBullet = new Bullet(3.0, 3.0, x, y);
		newBullet.setMaxRange(1200.0);
		newBullet.setDamage(5);
		newBullet.setSpeed_x(getBulletSpeed() * side);
		(new AudioClip(SoundHolder.getInstance().gunShot)).play();
	}
	
	
}
