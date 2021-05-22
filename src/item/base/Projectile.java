package item.base;

import interfaces.Collidable;
import logic.RenderableHolder;
import sceneObject.Ground;

public class Projectile extends Bullet {
	
	public Projectile(double x, double y) {
		super(5.0, 5.0, x, y);
		setFallable(true);
	}
	
	@Override
	public void onCollide(Collidable target) {
		if (target instanceof Ground) {
			Ground targetGround = (Ground) target;
			if (!isHit()) {
				setHit(true);
				for (int i = 0; i < 10; i++) {
					Bullet blast = new Bullet(3.0, 3.0, getX(), targetGround.getY() - 10.0);
					blast.setSpeed(6.0);
					double angle = Math.PI * Math.random();
					blast.setSpeed_x(Math.cos(angle) * blast.getSpeed());
					blast.setSpeed_y(Math.sin(angle) * -blast.getSpeed());
					blast.setFallable(true);
					RenderableHolder.getInstance().addGarbage(this);
				}
			}
		}
	}
}
