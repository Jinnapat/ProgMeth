package item.derived;

import constants.ImageHolder;
import item.base.Weapon;

public class Ak47 extends Weapon{
	
	public Ak47() {
		super();
		this.setName("AK47");
		this.setMaxAmmo(100);
		this.setFireRate(10);
		this.setDamage(100);
		this.setBulletSpeed(10);
		this.setRange(10);
		this.setRunSpeed(50);
		this.refillAmmo();
		this.setSprite(ImageHolder.getInstance().ak47);
		System.out.println("AK47 have been create");
	}
}
