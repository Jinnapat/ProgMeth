package item.base;

import character.Character;
import constants.GameConstant;
import interfaces.Collidable;
import interfaces.IRenderable;
import interfaces.Movable;
import javafx.scene.canvas.GraphicsContext;
import logic.RenderableHolder;
import sceneObject.SolidObject;

public class Utility extends Item implements Movable, IRenderable{
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(this.getSprite(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

	@Override
	public boolean isDestroy() {
		return false;
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
		// TODO Auto-generated method stub
		
	}
	
}
