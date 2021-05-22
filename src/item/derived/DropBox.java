package item.derived;

import character.Character;
import constants.GameConstant;
import constants.ImageHolder;
import interfaces.Collidable;
import item.base.Utility;
import logic.ImageLogic;

public class DropBox extends Utility{
	
	public DropBox(double width, double height, double x, double y) {
		super(x, y);
		ImageLogic.resizeAndsetSprite(this, ImageHolder.getInstance().box, width, height);
	}

	@Override
	public void collectBy(Character character) {
		character.setWeapon(null);
	}

	@Override
	public void onCollide(Collidable target) {
		if(target != null) {
			if(target instanceof Character && !this.isDestroy) {
				Character targetCharacter = (Character) target;
				this.collectBy(targetCharacter);
				System.out.println("Get DropBox");
				this.isDestroy = true;
				this.coolDown = GameConstant.UTILITY_COOLDOWN;
			}
		}
	}

}
