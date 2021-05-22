package item.derived;

import character.Character;
import constants.GameConstant;
import constants.ImageHolder;
import interfaces.Collidable;
import item.base.Utility;
import logic.DamageLogic;
import logic.ImageLogic;

public class Bandage extends Utility {

	public Bandage(double width, double height, double x, double y) {
		super(x, y);
		ImageLogic.resizeAndsetSprite(this, ImageHolder.getInstance().heartPlus, width, height);
	}

	@Override
	public void collectBy(Character character) {
		DamageLogic.calulateHeal(0.3, character);
	}

	@Override
	public void onCollide(Collidable target) {
		if (target != null) {
			if (target instanceof Character && !this.isDestroy) {
				Character targetCharacter = (Character) target;
				this.collectBy(targetCharacter);
				System.out.println("Get Bandage");
				this.isDestroy = true;
				this.coolDown = GameConstant.UTILITY_COOLDOWN;
			}
		}
	}

}
