package item.derived;

import character.Character;
import constants.GameConstant;
import constants.ImageHolder;
import interfaces.Collidable;
import item.base.Utility;
import javafx.scene.input.KeyCode;
import logic.ImageLogic;
import logic.RenderableHolder;
import character.Engineer;
import character.Heavy;
import character.Sniper;
import character.Scout;
import character.Shield;

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
				int newClass = (int)Math.floor(5 * Math.random());
				Character newCharacter = null;
				switch (newClass) {
					case 0: {
						newCharacter = new Engineer();
					}
					case 1: {
						newCharacter = new Scout();
					}
					case 2: {
						newCharacter = new Sniper();
					}
					case 3: {
						newCharacter = new Heavy();
					}
					case 4: {
						newCharacter = new Shield();
					}
					newCharacter.setX(targetCharacter.getX());
					newCharacter.setY(targetCharacter.getY());
					newCharacter.setHeadLeft(targetCharacter.isHeadLeft());
					newCharacter.setControlKeys(targetCharacter.getControlKeys());
					newCharacter.setCheckControls(true);
					newCharacter.setName(targetCharacter.getName());
					newCharacter.setFallable(true);
					RenderableHolder.getInstance().addWillAddObject(newCharacter);
					RenderableHolder.getInstance().addGarbage(targetCharacter.getWeapon());
					RenderableHolder.getInstance().addGarbage(targetCharacter);
				}
			}
		}
	}

}
