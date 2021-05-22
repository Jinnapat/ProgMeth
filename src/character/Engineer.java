package character;

import item.base.Weapon;
import item.derived.Ak47;

public class Engineer extends Character {

	public Engineer() {
		super(50.0, 50.0, 5.0, 8.0, 100, "Yellow");
		Weapon assaultRifle = new Ak47();
		setWeapon(assaultRifle);
	}

}
