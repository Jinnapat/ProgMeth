package item.derived;

import character.Character;
import item.base.Utility;
import logic.DamageLogic;
import sceneObject.SolidObject;

public class Bandage extends Utility{

	public Bandage() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collectBy(Character character) {
		// TODO Auto-generated method stub
		DamageLogic.calulateHeal(0.3, character);
	}

	@Override
	public void onCollide(SolidObject target) {
		// TODO Auto-generated method stub
	}

}
