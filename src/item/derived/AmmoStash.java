package item.derived;

import character.Character;
import item.base.Utility;
import sceneObject.SolidObject;

public class AmmoStash extends Utility{

	@Override
	public void collectBy(Character character) {
		System.out.println("Pick up AmmoStash");
		character.getWeapon().refillAmmo();
	}
	
	@Override
	public void onCollide(SolidObject target) {
		// TODO Auto-generated method stub
		
	}
}
