package item.derived;

import constants.ImageHolder;
import item.base.Weapon;

public class Awp extends Weapon{

	public Awp() {
		super();
		this.setName("AWP");
		this.setMaxAmmo(100);
		this.setFireRate(10);
		this.setDamage(100);
		this.setBulletSpeed(10);
		this.setRange(10);
		this.setRunSpeed(50);
		this.refillAmmo();
		this.setSprite(ImageHolder.getInstance().awp);
		System.out.println("AWP have been create");
	}
}
