package item.base;

import character.Character;
import constants.GameConstant;
import constants.PriorityConstant;
import interfaces.Collidable;
import interfaces.Movable;
import javafx.scene.canvas.GraphicsContext;

public class Utility extends Item implements Movable{
	
	protected boolean isDestroy;
	protected int coolDown;
	protected double createX;
	protected double createY;
	
	public Utility(double x, double y) {
		super();
		this.createX = x;
		this.createY = y;
		this.setX(x);
		this.setY(y);
		this.isDestroy = false;
		this.coolDown = -1;
	}

	@Override
	public int getZ() {
		return PriorityConstant.UTILITY;
	}

	@Override
	public void draw(GraphicsContext gc) {
		if (!this.isDestroy) {
			gc.drawImage(this.getSprite(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
		}
		
	}

	@Override
	public void collectBy(Character character) {
		
	}

	@Override
	public void update() {
		double newSpeed = getSpeed_y() + GameConstant.GRAVITY_G;
		setSpeed_y(newSpeed);
		if (this.coolDown > 0) {
			this.coolDown -= 1;
		}
		
		if (this.coolDown == 0) {
			this.setX(this.createX);
			this.setY(this.createY);
			this.isDestroy = false;
			this.coolDown = -1;
		}
	}

	@Override
	public void onCollide(Collidable target) {
	}
	
}
