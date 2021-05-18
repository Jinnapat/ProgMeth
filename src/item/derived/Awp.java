package item.derived;

import constants.ImageHolder;
import item.base.Weapon;

public class Awp extends Weapon{

	public Awp() {
		super(100, 2, 1000, 50);
		this.setSprite(ImageHolder.getInstance().awp);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Awp awp = new Awp();
		System.out.println(awp.getSprite());
	}
}
