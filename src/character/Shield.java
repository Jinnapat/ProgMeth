package character;

import item.base.Weapon;
import item.derived.Ak47;

public class Shield extends Character {

	public Shield() {
		super(50.0, 50.0, 4.0, 8.0, 300, "Black");
		Weapon assaultRifle = new Ak47();
		setWeapon(assaultRifle);
	}

}
