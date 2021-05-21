package character;

import item.base.Weapon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Heavy extends Character {

	public Heavy() {
		super(50.0, 50.0, 5.0, 10, 100, "Red");
		setMaxHealth(100);
		setHealth(100);
		Weapon assaultRifle = new Weapon();
		assaultRifle.setMaxAmmo(100);
		assaultRifle.setBulletSpeed(5);
		assaultRifle.setDamage(10);
		assaultRifle.setFireRate(1);
		assaultRifle.refillAmmo();
		setWeapon(assaultRifle);
		System.out.println(assaultRifle.getFireRate());
	}

}
