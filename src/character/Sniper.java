package character;

import item.base.Weapon;
import item.derived.Awp;

public class Sniper extends Character{

	public Sniper() {
		super(50.0, 50.0, 7.0, 10.0, 100, "Green");
		Weapon sniperRifle = new Awp();
		setWeapon(sniperRifle);
	}

	@Override
	public void act() {
	}

}
