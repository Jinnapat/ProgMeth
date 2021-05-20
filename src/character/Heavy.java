package character;

import item.base.Weapon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Heavy extends Character {

	public Heavy() {
		super(50.0, 50.0, 10.0, 10, 100, "Red");
		setHealth(100);
		setMaxHealth(100);
		Weapon assaultRifle = new Weapon();
		setWeapon(assaultRifle);
	}

}
