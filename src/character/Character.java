package character;

import interfaces.Movable;
import item.Weapon;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sceneObject.SolidObject;
import sceneObject.GameScene;
import sceneObject.Ground;
import java.util.HashMap;

public class Character extends SolidObject implements Movable {
	protected String name;
	protected int maxHealth;
	protected int health;
	protected double speed;
	protected AnimationTimer animationTimer;
	protected long lastTimeTriggered;
	protected boolean isHeadLeft;
	protected double jumpStrength;
	protected Weapon weapon;
	private HashMap<String, KeyCode> controlKeys = new HashMap<String, KeyCode>();
	private Text nameTag;
	
	public Character(double width, double height, double speed, double jumpStrength) {
		super(width, height);
		this.speed = speed;
		this.jumpStrength = jumpStrength;
		nameTag = new Text("New Player");
		nameTag.setTextAlignment(TextAlignment.CENTER);
		
		controlKeys = new HashMap<String, KeyCode>();
		controlKeys.put("leftKey", KeyCode.A);
		controlKeys.put("rightKey", KeyCode.D);
		controlKeys.put("jumpKey", KeyCode.W);
		controlKeys.put("shootKey", KeyCode.SPACE);
		
		GameScene.solidObjects.add(this);
		GameScene.root.getChildren().add(getBoundBox());
		GameScene.root.getChildren().add(nameTag);
		
		checkCollide();
	}

	public void draw(double x, double y) {};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.nameTag.setText(name);
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

	public Text getNameTag() {
		return nameTag;
	}

	public void setNameTag(Text nameTag) {
		this.nameTag = nameTag;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public HashMap<String, KeyCode> getControlKeys() {
		return controlKeys;
	}

	public void setControlKeys(HashMap<String, KeyCode> controlKeys) {
		this.controlKeys = controlKeys;
	}

	public void checkControl() {
		this.animationTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 10000000) {
					
					if (GameScene.keyPressed.containsKey(controlKeys.get("leftKey"))) {
						if (GameScene.keyPressed.get(controlKeys.get("leftKey"))) {
							setSpeed_x(-speed);
							setHeadLeft(true);
						}
					}
					
					if (GameScene.keyPressed.containsKey(controlKeys.get("rightKey"))) {
						if (GameScene.keyPressed.get(controlKeys.get("rightKey"))) {
							setSpeed_x(speed);
							setHeadLeft(false);
			
						}
					}
					
					if (GameScene.keyPressed.containsKey(controlKeys.get("shootKey"))) {
						if (GameScene.keyPressed.get(controlKeys.get("shootKey"))) {
							if (getWeapon() != null) {
								double bulletSpawnX = 0.0;
								if (isHeadLeft()) {
									bulletSpawnX = getX();
								} else {
									bulletSpawnX = getX() + getWidth();
								}
								getWeapon().shoot(bulletSpawnX, getY(), isHeadLeft());
							} else {
								System.out.println("No weapon!");
							}
						}
					}
					
					AnchorPane.setTopAnchor(getNameTag(), getY() - 20);
					AnchorPane.setLeftAnchor(getNameTag(), getX() - 20);
					AnchorPane.setTopAnchor(getBoundBox(), getY());
					AnchorPane.setLeftAnchor(getBoundBox(), getX());
					lastTimeTriggered = now;
				}
			}
		};
		
		this.animationTimer.start();
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
				
				if (GameScene.keyPressed.containsKey(controlKeys.get("jumpKey"))) {
					if (GameScene.keyPressed.get(controlKeys.get("jumpKey"))) {
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
}
