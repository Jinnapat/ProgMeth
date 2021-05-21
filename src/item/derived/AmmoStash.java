package item.derived;

import character.Character;
import interfaces.Collidable;
import item.base.Utility;

public class AmmoStash extends Utility{

	@Override
	public void collectBy(Character character) {
		System.out.println("Pick up AmmoStash");
		character.getWeapon().refillAmmo();
		checkCollide();
	}
	
	@Override
	public void onCollide(Collidable target) {
		if (target instanceof Character) {
			Character targetCharacter = (Character)target;
			collectBy(targetCharacter);
		}
	}
}
