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
import java.util.HashMap;

import GUI.Healthbar;

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
	private HashMap<String, KeyCode> controlKeys;
	private Text nameTag;
	private Healthbar healthBar;
	private boolean onGround;
	
	public Character(double width, double height, double speed, double jumpStrength, int maxHealth) {
		super(width, height);
		this.speed = speed;
		this.jumpStrength = jumpStrength;
		this.onGround = false;
		nameTag = new Text("New Player");
		nameTag.setTextAlignment(TextAlignment.CENTER);
		healthBar = new Healthbar();
				
		controlKeys = new HashMap<String, KeyCode>();
		controlKeys.put("leftKey", KeyCode.A);
		controlKeys.put("rightKey", KeyCode.D);
		controlKeys.put("jumpKey", KeyCode.W);
		controlKeys.put("shootKey", KeyCode.SPACE);
		
		GameScene.solidObjects.add(this);
		GameScene.root.getChildren().add(getBoundBox());
		GameScene.root.getChildren().add(nameTag);
		GameScene.root.getChildren().add(healthBar.getHealthBox());
		
		checkCollide();
	}

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
		this.healthBar.displayHealth(getHealth(), maxHealth);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
		this.healthBar.displayHealth(health, this.maxHealth);
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

	
	public Healthbar getHealthBar() {
		return healthBar;
	}

	public void setHealthBar(Healthbar healthBar) {
		this.healthBar = healthBar;
	}

	public double getJumpStrength() {
		return jumpStrength;
	}

	public void setJumpStrength(double jumpStrength) {
		this.jumpStrength = jumpStrength;
	}

	public boolean isOnGround() {
		return onGround;
	}

	public void setOnGround(boolean onGround) {
		this.onGround = onGround;
	}

	public void checkControl() {
		
		this.animationTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 10000000) {
					
					if (GameScene.keyPressed.contains(controlKeys.get("leftKey"))) {
						setSpeed_x(-speed);
						setHeadLeft(true);
					}
					
					if (GameScene.keyPressed.contains(controlKeys.get("rightKey"))) {
						setSpeed_x(speed);
						setHeadLeft(false);
					}
					
					if (GameScene.keyPressed.contains(controlKeys.get("shootKey"))) {
						if (getWeapon() != null) {
							double bulletSpawnX = 0.0;
							if (isHeadLeft()) {
								bulletSpawnX = getX() - 10.0;
							} else {
								bulletSpawnX = getX() + getWidth() + 10.0;
							}
							getWeapon().shoot(bulletSpawnX, getY(), isHeadLeft());
						} else {
							System.out.println("No weapon!");
						}
					}
					
					if (GameScene.keyPressed.contains(controlKeys.get("jumpKey"))) {
						if (getSpeed_y() < 0.5 && isOnGround()) {
							setSpeed_y(-getJumpStrength());
						}
					}
					
					setOnGround(false);
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

	}
}
