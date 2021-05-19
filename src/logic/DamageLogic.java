package logic;
import character.Character;

public class DamageLogic {
	public static void calculateDamage(int damage, Character e) {
		int newHealth = Math.max(e.getHealth() - damage, 0);
		e.setHealth(newHealth);
		System.out.println(newHealth);
		e.setHealth(newHealth);
	}
}
