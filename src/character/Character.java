package character;

import interfaces.Movable;
import item.Weapon;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import sceneObject.SolidObject;
import sceneObject.GameScene;
import sceneObject.Ground;

public class Character extends SolidObject implements Movable {
	protected String name;
	protected int ammo;
	protected int maxHealth;
	protected int health;
	protected double speed;
	protected AnimationTimer animationTimer;
	protected long lastTimeTriggered;
	protected boolean isHeadLeft;
	protected double jumpStrength;
	protected Weapon weapon;
	private KeyCode leftKey;
	private KeyCode rightKey;
	private KeyCode jumpKey;
	private KeyCode shootKey;
	
	public Character(double width, double height, double speed, double jumpStrength) {
		super(width, height);
		this.speed = speed;
		this.jumpStrength = jumpStrength;
		this.leftKey = KeyCode.A;
		this.rightKey = KeyCode.D;
		this.jumpKey = KeyCode.W;
		this.shootKey = KeyCode.SPACE;
		
		this.animationTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 10000000) {
					
					if (GameScene.keyPressed.containsKey(leftKey)) {
						if (GameScene.keyPressed.get(leftKey)) {
							setSpeed_x(-speed);
							setHeadLeft(true);
						}
					}
					
					if (GameScene.keyPressed.containsKey(rightKey)) {
						if (GameScene.keyPressed.get(rightKey)) {
							setSpeed_x(speed);
							setHeadLeft(false);
			
						}
					}
					
					if (GameScene.keyPressed.containsKey(shootKey)) {
						if (GameScene.keyPressed.get(shootKey)) {
							if (getWeapon() != null) {
								getWeapon().shoot();
							} else {
								System.out.println("No weapon!");
							}
						}
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

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isHeadLeft() {
		return isHeadLeft;
	}

	public void setHeadLeft(boolean isHeadLeft) {
		this.isHeadLeft = isHeadLeft;
	}

	public KeyCode getLeftKey() {
		return leftKey;
	}

	public void setLeftKey(KeyCode leftKey) {
		this.leftKey = leftKey;
	}

	public KeyCode getRightKey() {
		return rightKey;
	}

	public void setRightKey(KeyCode rightKey) {
		this.rightKey = rightKey;
	}

	public KeyCode getJumpKey() {
		return jumpKey;
	}

	public void setJumpKey(KeyCode jumpKey) {
		this.jumpKey = jumpKey;
	}

	public KeyCode getShootKey() {
		return shootKey;
	}

	public void setShootKey(KeyCode shootKey) {
		this.shootKey = shootKey;
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
				
				if (GameScene.keyPressed.containsKey(jumpKey)) {
					if (GameScene.keyPressed.get(jumpKey)) {
						if (getSpeed_y() < 0.5) {
							setSpeed_y(-this.jumpStrength);
						}
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

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}	
}
