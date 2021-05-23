package item.base;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.DamageLogic;
import logic.RenderableHolder;
import sceneObject.Ground;
import sceneObject.SolidObject;
import systemMemory.Memory;
import character.Character;
import constants.GameConstant;
import constants.PriorityConstant;
import interfaces.Collidable;
import interfaces.Movable;

public class Bullet extends SolidObject implements Movable{
	private double speed;
	private int damage;
	private double maxRange;
	private boolean isLeftSide;
	
	public Bullet() {
		super(5.0, 3.0);
		this.maxRange = 500;
		this.damage = 1;
		this.speed = 30;
		this.isLeftSide = false;
	}
	
	public Bullet(double width, double height, double x, double y) {
		this();
		this.setWidth(width);
		this.setHeight(height);
		this.setX(x);
		this.setY(y);
	}
	
	public Bullet(int damage, double speed) {
		this();
		this.setX(0);
		this.setY(0);
		this.setDamage(damage);
		this.setSpeed(speed);
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public boolean isLeftSide() {
		return isLeftSide;
	}

	public void setLeftSide(boolean isLeftSide) {
		this.isLeftSide = isLeftSide;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = Math.max(damage, 0);
	}

	@Override
	public int getZ() {
		return PriorityConstant.BULLET;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.GOLD);
		gc.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public double getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(double maxRange) {
		this.maxRange = maxRange;
	}

	@Override
	public void update() {
		
		maxRange -= Math.abs(getSpeed_x());
				
		if (maxRange <= 0.0) {
			RenderableHolder.getInstance().addGarbage(this);
		}

		if (isFallable()) {
			this.setSpeed_y(getSpeed_y() + GameConstant.GRAVITY_G);
		}
		
		
	}

	@Override
	public void onCollide(Collidable target) {
		if (target instanceof Character) {
			Character targetCharacter = (Character)target;
			if (targetCharacter.getHealth() > 0) {
				DamageLogic.calculateDamage(this, targetCharacter);
			}
			RenderableHolder.getInstance().addGarbage(this);
		} else if (target instanceof Ground) {
			RenderableHolder.getInstance().addGarbage(this);
		}
	}
}
