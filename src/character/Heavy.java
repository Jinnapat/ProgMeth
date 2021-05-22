package character;

import item.base.Weapon;
import item.derived.BombLauncher;

public class Heavy extends Character {

	public Heavy() {
		super(50.0, 50.0, 5.0, 10.0, 150, "Red");
		Weapon bombLaucher = new BombLauncher();
		setWeapon(bombLaucher);
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

}
