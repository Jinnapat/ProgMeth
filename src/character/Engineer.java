package character;

import item.base.Weapon;
import item.derived.Ak47;
import item.derived.Mine;
import logic.RenderableHolder;

public class Engineer extends Character {
	
	private Mine lastMine;
	
	public Engineer() {
		super(50.0, 50.0, 5.0, 10.0, 100, "Yellow");
		this.lastMine = null;
		Weapon assaultRifle = new Ak47();
		setWeapon(assaultRifle);
	}
	
	@Override
	public void act() {
		if (this.standStillTime >= 300) {
			if (this.lastMine != null) {
				if (!this.lastMine.isTriggered()) {
					RenderableHolder.getInstance().addGarbage(lastMine);
				}
			}
			this.standStillTime = 0;
			this.lastMine = new Mine(30.0, 10.0, getX(), getY());
		}
	}

}
