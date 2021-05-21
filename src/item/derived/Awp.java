package item.derived;

import constants.ImageHolder;
import item.base.Weapon;
import javafx.scene.image.ImageView;
import logic.ImageLogic;

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
		
		this.setX(300);
		this.setY(400);
		
		ImageLogic.resizeAndsetSprite(this, ImageHolder.getInstance().awp,100, 30);
		this.setWidth(50);
		this.setHeight(30);
		this.getBoundBox().getChildren().add(imageView);
		
		System.out.println("AWP have been create");
	}
	
	
}
