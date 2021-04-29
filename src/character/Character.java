package character;

import interfaces.Movable;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import sceneObject.SolidObject;
import sceneObject.GameScene;
import sceneObject.Ground;

public class Character extends SolidObject implements Movable {
	protected String name;
	protected int ammo;
	protected int health;
	protected double speed;
	protected AnimationTimer animationTimer;
	protected long lastTimeTriggered;
	protected boolean isHeadLeft;
	protected double jumpStrength;
	
	public Character(double width, double height, double x, double y, double speed, double jumpStrength) {
		super(width, height, x, y);
		this.speed = speed;
		this.jumpStrength = jumpStrength;
		
		this.animationTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 10000000) {
					
					
					if (GameScene.keyPressed.get(KeyCode.A)) {
						setSpeed_x(-speed);
					}
					
					if (GameScene.keyPressed.get(KeyCode.D)) {
						setSpeed_x(speed);
					}
					
					AnchorPane.setTopAnchor(getBoundBox(), getY());
					AnchorPane.setLeftAnchor(getBoundBox(), getX());
					lastTimeTriggered = now;
				}
			}
		};
		
		this.animationTimer.start();
	}

	public void draw(double x, double y) {};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	@Override
	public void onCollide(SolidObject target) {
		
		if (target instanceof Ground) {
			
			double bottom_y = getY() + getHeight();
			if (bottom_y >= target.getY() && bottom_y <= target.getY() + target.getHeight()) {
				
				if (getSpeed_y() > 0) {
					setSpeed_y(0.0);
					setY(target.getY() - getHeight());
				}
				
				if (GameScene.keyPressed.get(KeyCode.W)) {
					if (getSpeed_y() < 0.5) {
						setSpeed_y(-this.jumpStrength);
					}
				}
			} else if (getSpeed_y() > 0.0) {
			
				double left_x = getX();
				if (left_x >= target.getX() && left_x <= target.getX() + target.getWidth()) {
					if (getSpeed_x() < 0.0) {
						setX(target.getX() + target.getWidth());
						setSpeed_x(0.0);
					}
				}
				
				double right_x = getX() + getWidth();
				if (right_x >= target.getX() && right_x <= target.getX() + target.getWidth()) {
					if (getSpeed_x() > 0.0) {
						setX(target.getX() - getWidth());
						setSpeed_x(0.0);
					}
				}
				
			}
		}
	}

	
	
}
