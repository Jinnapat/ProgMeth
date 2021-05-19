package item.derived;

import character.Character;
import item.base.Item;
import sceneObject.SolidObject;
import character.Character;

public class dropBox extends Item{

	@Override
	public void collectBy(Character character) {
		// TODO Auto-generated method stub
		character.setWeapon(null);
	}

	@Override
	public void onCollide(SolidObject target) {
		// TODO Auto-generated method stub
		
	}

}
