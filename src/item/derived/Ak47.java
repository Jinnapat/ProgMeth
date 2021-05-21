package item.derived;

import constants.ImageHolder;
import item.base.Weapon;
import logic.ImageLogic;

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
		
		this.setX(200);
		this.setY(400);
		
		ImageLogic.resizeAndsetSprite(this, ImageHolder.getInstance().awp,60,020);
		this.setWidth(50);
		this.setHeight(30);
		this.getBoundBox().getChildren().add(imageView);
		
		System.out.println("AK47 have been create");
	}
}
