package character;

import item.base.Weapon;
import item.derived.Ak47;
import item.derived.Mine;

public class Engineer extends Character {
	
	public Engineer() {
		super(50.0, 50.0, 5.0, 8.0, 100, "Yellow");
		Weapon assaultRifle = new Ak47();
		setWeapon(assaultRifle);
	}

	@Override
	public void act() {
		if (this.standStillTime >= 100) {
			this.standStillTime = 0;
			new Mine(30.0, 10.0, getX(), getY());
		}
	}

}
