package item;

import character.Character;

public class Bandage extends Utility{

	@Override
	public void collectBy(Character character) {
		// TODO Auto-generated method stub
		int currentHealth = character.getHealth();
		int maxHealth = character.getMaxHealth();
		int newHealth = Math.max(currentHealth += maxHealth*(0.3), maxHealth);
		character.setHealth(newHealth);
	}

	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
		
	}

}
