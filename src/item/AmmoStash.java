package item;

import character.Character;

public class AmmoStash extends Utility{

	@Override
	public void collectBy(Character character) {
		System.out.println("Pick up AmmoStash");
		character.getWeapon().refillAmmo();
	}

	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
		
	}
	
}
