package item.base;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.DamageLogic;
import logic.RenderableHolder;
import sceneObject.GameScene;
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
	private boolean isShot;
	
	public Bullet() {
		super(5.0, 3.0);
		this.maxRange = 500;
		this.damage = 1;
		this.speed = 30;
		this.isLeftSide = false;
		this.isHit = false;
		this.isShot = false;
//		Memory.getInstance().gameCanvas.addInstance(this);
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

	public void shoot(double x, double y, boolean isLeftSide) {
		System.out.println("Bang!");
		if (isLeftSide) {
			setSpeed_x(getSpeed() * -1);
		} else {
			setSpeed_x(getSpeed());
		}
		setX(x);
		setY(y);
		this.isShot = true;
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
		if (this.isShot) {
			gc.setFill(Color.GOLD);
			gc.fillRect(getX(), getY(), 5, 2);
		}
	}

	@Override
	public void update() {
		if (this.isShot) {
			if (maxRange <= 0.0) {
				this.isShot = false;
				RenderableHolder.getInstance().addGarbage(this);
			}
			maxRange -= Math.abs(getSpeed());
		}
	}

	@Override
	public void onCollide(Collidable target) {
		if (target instanceof Character) {
			Character targetCharacter = (Character)target;
			if (targetCharacter.getHealth() > 0) {
				DamageLogic.calculateDamage(this, targetCharacter);
			}
			this.isShot = false;
			this.setHit(true);
		} else if (target instanceof Ground) {
			this.isShot = false;
			this.setHit(true);
		}
	}
}
