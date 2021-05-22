package character;

import item.base.Weapon;
import item.derived.Ak47;

public class Shield extends Character {

	public Shield() {
		super(50.0, 50.0, 4.0, 10.0, 300, "Black");
		Weapon assaultRifle = new Ak47();
		setWeapon(assaultRifle);
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

}
