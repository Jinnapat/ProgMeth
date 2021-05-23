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
	}

	@Override
	public void onCollide(Collidable target) {
		if(target != null) {
			if(target instanceof Character && !this.isDestroy()) {
				this.setDestroy(true);
				Character targetCharacter = (Character) target;
				System.out.println("Get DropBox");
				this.coolDown = GameConstant.UTILITY_COOLDOWN;
				int newClass = (int)Math.floor(5 * Math.random());
				Character newCharacter = null;
				switch (newClass) {
					case 0: {
						newCharacter = new Engineer();
						break;
					}
					case 1: {
						newCharacter = new Scout();
						break;
					}
					case 2: {
						newCharacter = new Sniper();
						break;
					}
					case 3: {
						newCharacter = new Heavy();
						break;
					}
					case 4: {
						newCharacter = new Shield();
						break;
					}
				}
				newCharacter.setX(targetCharacter.getX());
				newCharacter.setY(targetCharacter.getY());
				newCharacter.setHeadLeft(targetCharacter.isHeadLeft());
				newCharacter.setControlKeys(targetCharacter.getControlKeys());
				newCharacter.setCheckControls(true);
				newCharacter.setName(targetCharacter.getName());
				newCharacter.setFallable(true);
				newCharacter.setHealth((int)Math.round((double)targetCharacter.getHealth() / (double)targetCharacter.getMaxHealth() * newCharacter.getMaxHealth()));
				RenderableHolder.getInstance().addGarbage(targetCharacter.getWeapon());
				RenderableHolder.getInstance().addGarbage(targetCharacter);
			}
		}
	}

}
