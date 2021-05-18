package item.derived;

import character.Character;
import item.base.Utility;
import item.base.Weapon;
import sceneObject.SolidObject;

public class Package extends Utility{

	public Weapon weapon;
	
	
	public Package(Weapon weapon) {
		super();
		this.weapon = weapon;
	}

	@Override
	public void collectBy(Character character) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCollide(SolidObject target) {
		// TODO Auto-generated method stub
		
	}

}
