
package character;

import item.base.Weapon;
import item.derived.Shotgun;

public class Scout extends Character{
	public Scout() {
		super(50.0, 50.0, 8.0, 10.0, 100, "Blue");
		Weapon shotgun = new Shotgun();
		setWeapon(shotgun);
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}
}