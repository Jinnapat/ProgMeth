package item.derived;

import character.Character;
import constants.GameConstant;
import constants.ImageHolder;
import interfaces.Collidable;
import item.base.Utility;
import logic.ImageLogic;

public class AmmoStash extends Utility {

	public AmmoStash(double width, double height, double x, double y) {
		super(x, y);
		ImageLogic.resizeAndsetSprite(this, ImageHolder.getInstance().ammoStash, width, height);
	}

	@Override
	public void collectBy(Character character) {
		if(character.getWeapon() != null) {
			System.out.println(character.getWeapon());
			character.getWeapon().refillAmmo();
			System.out.println(character.getWeapon().getName());
		}
	}

	@Override
	public void onCollide(Collidable target) {
		if (target != null) {
			if (target instanceof Character && !this.isDestroy()) {
				Character targetCharacter = (Character) target;
				if(targetCharacter.getWeapon() != null) {
					this.collectBy(targetCharacter);
					this.setDestroy(true);
					this.coolDown = GameConstant.UTILITY_COOLDOWN;
				}
			}
		}
	}
}
