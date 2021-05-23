package item.base;

import constants.SoundHolder;
import interfaces.Collidable;
import javafx.scene.media.AudioClip;
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
			double spawnX = getX() - getSpeed_x();
			double spawnY = getY() - getSpeed_y();
			
			(new AudioClip(SoundHolder.getInstance().gunShot)).play();
			
			if (getSpeed_x() > 0.0) {
				spawnX -= 3.0;
			}
			
			for (int i = 0; i < 20; i++) {
				Bullet blast = new Bullet(3.0, 3.0, spawnX, spawnY);
				double angle = Math.PI * 2.0 * Math.random();
				double blastSpeed = Math.random() * 3.0 + 3.0;
				blast.setDamage(this.getDamage());
				blast.setSpeed(blastSpeed);
				blast.setSpeed_x(Math.cos(angle) * blast.getSpeed());
				blast.setSpeed_y(Math.sin(angle) * -blast.getSpeed());
				blast.setFallable(true);
				RenderableHolder.getInstance().addGarbage(this);
			}
		}
	}
}
