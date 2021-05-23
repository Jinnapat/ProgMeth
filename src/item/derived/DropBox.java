package item.derived;

import character.Character;
import constants.GameConstant;
import constants.ImageHolder;
import interfaces.Collidable;
import item.base.Utility;
import logic.ImageLogic;
import logic.RenderableHolder;
import systemMemory.Memory;
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

	private Character createNewCharacter() {
		int chosenClass = (int)Math.floor(5 * Math.random());
		Character createdCharacter = null;
		if (chosenClass == 0) {
			createdCharacter = new Engineer();
		} else if (chosenClass == 1) {
			createdCharacter = new Scout();
		} else if (chosenClass == 2) {
			createdCharacter = new Sniper();
		} else if (chosenClass == 3) {
			createdCharacter = new Heavy();
		} else if (chosenClass == 4) {
			createdCharacter = new Shield();
		}
		return createdCharacter;
	}
	private void copyCharacterStats(Character targetCharacter, Character createdCharacter) {
		createdCharacter.setX(targetCharacter.getX());
		createdCharacter.setY(targetCharacter.getY());
		createdCharacter.setHeadLeft(targetCharacter.isHeadLeft());
		createdCharacter.setControlKeys(targetCharacter.getControlKeys());
		createdCharacter.setCheckControls(true);
		createdCharacter.setName(targetCharacter.getName());
		double healthPercent = (double)targetCharacter.getHealth() / (double)targetCharacter.getMaxHealth();
		createdCharacter.setHealth((int)Math.round(healthPercent * createdCharacter.getMaxHealth()));
	}
	
	private void replaceOldCharacter(Character targetCharacter, Character createdCharacter) {
		Character memChar1 = Memory.getInstance().selectionGui.getSelectCharacterBox().getCharacter();
		Character memChar2 = Memory.getInstance().selectionGui.getSelectCharacterBox2().getCharacter();
		if (targetCharacter.getName().equals(memChar1.getName())) {
			Memory.getInstance().selectionGui.getSelectCharacterBox().setCharacter(createdCharacter);
		} else if (targetCharacter.getName().equals(memChar2.getName())) {
			Memory.getInstance().selectionGui.getSelectCharacterBox2().setCharacter(createdCharacter);
		}
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
				this.coolDown = GameConstant.UTILITY_COOLDOWN;
				Character createdCharacter = createNewCharacter();
				RenderableHolder.getInstance().addGarbage(targetCharacter.getWeapon());
				RenderableHolder.getInstance().addGarbage(targetCharacter);
				this.copyCharacterStats(targetCharacter, createdCharacter);
				this.replaceOldCharacter(targetCharacter, createdCharacter);
			}
		}
	}

}
