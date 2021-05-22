package logic;
import character.Character;
import item.base.Bullet;

public class DamageLogic {
	public static void calculateDamage(Bullet b, Character e) {
		if(!b.isHit()) {
			int newHealth = Math.max(e.getHealth() - b.getDamage(), 0);
			System.out.println(newHealth);
			e.setHealth(newHealth);
		}
	}
		
	public static void calculateDamage(int damage, Character e) {
		int newHealth = Math.max(e.getHealth() - damage, 0);
		System.out.println(newHealth);
		e.setHealth(newHealth);
	}
	
	public static void calulateHeal(double percent, Character character) {
		int currentHealth = character.getHealth();
		int maxHealth = character.getMaxHealth();
		int newHealth = Math.min(currentHealth += maxHealth*(percent), maxHealth);
		character.setHealth(newHealth);
	}
	
	public static void pushCharacter(Character character) {
		
	}
}
