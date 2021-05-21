package item.derived;

import character.Character;
import constants.ImageHolder;
import interfaces.Collidable;
import item.base.Utility;
import logic.ImageLogic;
import logic.RenderableHolder;

public class DropBox extends Utility{
	
	public DropBox() {
		super();
		this.setX(50);
		this.setY(50);
		ImageLogic.resizeAndsetSprite(this, ImageHolder.getInstance().box,32, 32);
	}
	
	public DropBox(double width, double height, double x, double y) {
		this();
		this.setX(x);
		this.setY(y);
		ImageLogic.resizeAndsetSprite(this, ImageHolder.getInstance().box, width, height);
	}

	@Override
	public void collectBy(Character character) {
		character.setWeapon(null);
	}

	@Override
	public void onCollide(Collidable target) {
		if(target != null) {
			if(target instanceof Character) {
				Character targetCharacter = (Character) target;
				this.collectBy(targetCharacter);
				System.out.println("Get DropBox");
				RenderableHolder.getInstance().addGarbage(this);
			}
		}
	}

}
