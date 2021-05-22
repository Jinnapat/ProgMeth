package item.base;

import interfaces.Collidable;
import logic.RenderableHolder;
import sceneObject.Ground;

public class Projectile extends Bullet {
	
	public Projectile(int damage, double bulletSpeed) {
		super(damage, bulletSpeed);
		setSpeed(5);
	}
	
	@Override
	public void onCollide(Collidable target) {
		if (target instanceof Ground) {
			if (!isHit()) {
				setHit(true);
				for (int i = 0; i < 10; i++) {
					Bullet blast = new Bullet();
					double angle = Math.PI * 2.0 * Math.random();
					blast.setWidth(5);
					blast.setHeight(5);
					blast.setSpeed_x(Math.cos(angle) * getSpeed());
					blast.setSpeed_y(Math.sin(angle) * getSpeed());
					blast.setFallable(true);
					System.out.println(blast.getX());
					System.out.println(blast.getY());
					RenderableHolder.getInstance().addGarbage(this);
				}
			}
		}
	}
}
