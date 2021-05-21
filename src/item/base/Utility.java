package item.base;

import character.Character;
import constants.GameConstant;
import constants.PriorityConstant;
import interfaces.Collidable;
import interfaces.Movable;
import javafx.scene.canvas.GraphicsContext;
import logic.DamageLogic;
import sceneObject.SolidObject;

public class Utility extends Item implements Movable{
	
	protected boolean isDestroy = false;

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return PriorityConstant.UTILITY;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		/////////TODO////////////
		gc.drawImage(this.getSprite(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

	@Override
	public boolean isDestroy() {
		// TODO Auto-generated method stub
		return this.isDestroy;
	}

	@Override
	public void collectBy(Character character) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(this.isFallable()) {
			double newSpeed = getSpeed_y() + GameConstant.GRAVITY_G;
			if (newSpeed <= GameConstant.MAX_SPEED_Y) {
				setSpeed_y(newSpeed);
			}
		}
	}

	@Override
	public void onCollide(Collidable target) {
	}
	
}
