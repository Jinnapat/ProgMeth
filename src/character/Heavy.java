package character;

import item.base.Weapon;
import item.derived.BombLauncher;
import item.derived.Shotgun;

public class Heavy extends Character {

	public Heavy() {
		super(50.0, 50.0, 5.0, 10, 100, "Red");
		setMaxHealth(100);
		setHealth(100);
		Weapon assaultRifle = new BombLauncher();
		assaultRifle.setMaxAmmo(100);
		assaultRifle.setBulletSpeed(3);
		assaultRifle.setDamage(10);
		assaultRifle.setFireRate(1);
		assaultRifle.refillAmmo();
		setWeapon(assaultRifle);
	}

}
