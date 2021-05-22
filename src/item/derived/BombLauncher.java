package item.derived;

import item.base.Projectile;
import item.base.Weapon;

public class BombLauncher extends Weapon{

	public BombLauncher() {
		super();
		
	}
	
	@Override
	public void shoot(double x, double y, int side) {
		Projectile newProjectile = new Projectile(x, y);
		newProjectile.setSpeed_x(5.0 * side);
		newProjectile.setSpeed_y(-10.0);
	}

}
