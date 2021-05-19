package item.derived;

import constants.ImageHolder;
import item.base.Weapon;

public class Awp extends Weapon{

	public Awp() {
		super(10000, 100, 1000, 50);
		this.setSprite(ImageHolder.getInstance().awp);
		System.out.println("AWP have been create");
	}
	
//	public static void main(String[] args) {
//		Awp awp = new Awp();
//		System.out.println(awp.getSprite());
//	}
}
