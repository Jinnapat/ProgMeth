package item.base;

import character.Character;
import constants.GameConstant;
import constants.PriorityConstant;
import interfaces.Collidable;
import interfaces.Movable;
import javafx.scene.canvas.GraphicsContext;

public class Utility extends Item implements Movable{
	
	protected boolean isDestroy = false;

	@Override
	public int getZ() {
		return PriorityConstant.UTILITY;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(this.getSprite(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

	@Override
	public void collectBy(Character character) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		if (isFallable()) {
			double newSpeed = getSpeed_y() + GameConstant.GRAVITY_G;
			setSpeed_y(newSpeed);
		}
	}

	@Override
	public void onCollide(Collidable target) {
	}
	
}
