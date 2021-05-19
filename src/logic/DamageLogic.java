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
}
