package item.derived;

import constants.SoundHolder;
import item.base.Projectile;
import item.base.Weapon;
import javafx.scene.media.AudioClip;

public class BombLauncher extends Weapon{

	public BombLauncher() {
		super();
		this.setFireRate(1);
		this.setDamage(10);
		this.setName("Bomb Launcher");
	}
	
	@Override
	public void shoot(double x, double y, int side) {
		Projectile newProjectile = new Projectile(x, y - 5.0);
		newProjectile.setDamage(this.getDamage());
		newProjectile.setSpeed_x(5.0 * side);
		newProjectile.setSpeed_y(-10.0);
		(new AudioClip(SoundHolder.getInstance().gunShot)).play();
	}

}
