package item.derived;

import character.Character;
import constants.ImageHolder;
import interfaces.Collidable;
import item.base.Utility;
import logic.ImageLogic;
import logic.RenderableHolder;

public class AmmoStash extends Utility {

	public AmmoStash() {
		super();
		this.setX(50);
		this.setY(50);
		this.isDestroy = false;
		ImageLogic.resizeAndsetSprite(this, ImageHolder.getInstance().ammoStash, 32, 32);
	}

	public AmmoStash(double width, double height, double x, double y) {
		this();
		this.setX(x);
		this.setY(y);
		ImageLogic.resizeAndsetSprite(this, ImageHolder.getInstance().ammoStash, width, height);
	}

	@Override
	public void collectBy(Character character) {
		if(character.getWeapon() != null) {
			character.getWeapon().refillAmmo();
			System.out.println(character.getWeapon().getName());
		}
	}

	@Override
	public void onCollide(Collidable target) {
		if (target != null) {
			if (target instanceof Character) {
				if (!this.isDestroy) {
					this.isDestroy = true;
					Character targetCharacter = (Character) target;
					System.out.println("Pick up AmmoStash");
					collectBy(targetCharacter);
					RenderableHolder.getInstance().addGarbage(this);
				}
				
			}
		}
	}
}
