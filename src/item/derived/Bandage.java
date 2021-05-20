package item.derived;

import character.Character;
import item.base.Utility;
import logic.DamageLogic;
import sceneObject.GameScene;
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
		if(target != null) {
			if(target instanceof Character) {
				Character targetCharacter = (Character) target;
				DamageLogic.calulateHeal(0.3, targetCharacter);
				GameScene.solidObjects.remove(this);
				GameScene.root.getChildren().remove(this.getBoundBox());
				System.out.println("Get Bandage");
			}
		}
	}

}
