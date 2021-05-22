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
	private boolean isHit;
	
	public Bullet() {
		super(5.0, 3.0);
		this.maxRange = 500;
		this.damage = 1;
		this.speed = 30;
		this.isLeftSide = false;
		this.isHit = false;
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
	

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

	@Override
	public int getZ() {
		return PriorityConstant.BULLET;
	}

	@Override
	public void draw(GraphicsContext gc) {
		if (!this.isHit()) {
			gc.setFill(Color.GOLD);
			gc.fillRect(getX(), getY(), getWidth(), getHeight());
		}
	}

	@Override
	public void update() {
		
		maxRange -= Math.abs(getSpeed_x());
				
		if (maxRange <= 0.0) {
			this.setHit(true);
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
			this.setHit(true);
		} else if (target instanceof Ground) {
			this.setHit(true);
		}
	}
}
