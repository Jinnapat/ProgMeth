package character;

import interfaces.Collidable;
import interfaces.IRenderable;
import interfaces.Movable;
import item.base.Weapon;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sceneObject.SolidObject;
import sceneObject.GameScene;

import java.util.ArrayList;
import java.util.HashMap;

import constants.GameConstant;
import constants.PriorityConstant;
import gui.Healthbar;

public class Character extends SolidObject implements Movable, IRenderable {
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
	private String state;
	private int curImage = 0;
	private ArrayList<Image> runImages;
	private ArrayList<Image> idleImages;
	private ArrayList<Image> dieImages;
	private boolean checkControls;
	private int animationDelay;
	private int currentAnimationDelay;
	
	public Character(double width, double height, double speed, double jumpStrength, int maxHealth, String color) {
		super(width, height);
		this.state = "idle";
		this.speed = speed;
		this.jumpStrength = jumpStrength;
		this.onGround = false;
		this.checkControls = false;
		this.animationDelay = 10;
		this.currentAnimationDelay = this.animationDelay;
		
		nameTag = new Text("New Player");
		nameTag.setTextAlignment(TextAlignment.CENTER);
		nameTag.setWrappingWidth(200);
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
		runImages = new ArrayList<Image>();
		idleImages = new ArrayList<Image>();
		dieImages = new ArrayList<Image>();
		
		for (int i = 1; i <= 6; i++) {
			runImages.add(new Image(ClassLoader.getSystemResource("character/" + color + "/run/" + i + ".png").toString(), 0.0, 50.0, true, false));
		}
		for (int i = 1; i <= 5; i++) {
			idleImages.add(new Image(ClassLoader.getSystemResource("character/" + color + "/idle/" + i + ".png").toString(), 0.0, 50.0, true, false));
		}
		for (int i = 1; i <= 8; i++) {
			dieImages.add(new Image(ClassLoader.getSystemResource("character/" + color + "/die/" + i + ".png").toString(), 0.0, 50.0, true, false));
		}
		
		this.setSprite(this.runImages.get(0));
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
		if (health <= 0) {
			setCheckControls(false);
			this.curImage = 0;
			setState("dying");
		}
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
		System.out.println(this.getName() + " get Weapon: " + weapon.getName());
		weapon.setPlayer(this);
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	public boolean isCheckControls() {
		return checkControls;
	}

	public void setCheckControls(boolean checkControls) {
		this.checkControls = checkControls;
	}

	@Override
	public int getZ() {
		return PriorityConstant.CHARACTER;
	}

	@Override
	public void draw(GraphicsContext gc) {
		currentAnimationDelay -= 1;
		if (currentAnimationDelay <= 0) {
			curImage += 1;
			currentAnimationDelay = animationDelay;
		}
		
		int side = 1;
		if (isHeadLeft) {
			side = -1;
		}
		if (getState() == "idle") {
			curImage = (curImage) % idleImages.size();
			Image image = idleImages.get(curImage);
			gc.drawImage(image, this.getX() - Math.min(0.0, image.getWidth() * side), this.getY(), image.getWidth() * side, image.getHeight());
		} else if (getState() == "running") {
			curImage = (curImage) % runImages.size();
			Image image = runImages.get(curImage);
			gc.drawImage(image, this.getX() - Math.min(0.0, image.getWidth() * side), this.getY(), image.getWidth() * side, image.getHeight());
		} else if (getState() == "dying") {
			curImage = Math.min(curImage, dieImages.size() - 1);
			Image image = dieImages.get(curImage);
			gc.drawImage(image, this.getX() - Math.min(0.0, image.getWidth() * side), this.getY(), image.getWidth() * side, image.getHeight());
		}
		
	}

	@Override
	public boolean isDestroy() {
		return false;
	}

	@Override
	public void update() {
		
		setSpeed_x(getSpeed_x() * getFriction());
		
		if (isFallable()) {
			double newSpeed = getSpeed_y() + GameConstant.GRAVITY_G;
			if (newSpeed <= GameConstant.MAX_SPEED_Y) {
				setSpeed_y(newSpeed);
			}
			setY(getY() + getSpeed_y());
		}
			
		if (isCheckControls()) {
			if (GameConstant.keyPressed.contains(controlKeys.get("leftKey"))) {
				setSpeed_x(-speed);
				setHeadLeft(true);
				setState("running");

			} else if (GameConstant.keyPressed.contains(controlKeys.get("rightKey"))) {
				setSpeed_x(speed);
				setHeadLeft(false);
				setState("running");
			} else {
				setState("idle");
			}
			
			if (GameConstant.keyPressed.contains(controlKeys.get("shootKey"))) {
				if (getWeapon() != null) {
					double bulletSpawnX = 0.0;
					if (isHeadLeft()) {
						bulletSpawnX = getX() - 10.0;
					} else {
						bulletSpawnX = getX() + getWidth() + 10.0;
					}
					getWeapon().shoot(bulletSpawnX, getY() + 25.0, isHeadLeft());
				} else {
					System.out.println("No weapon!");
				}
			}
			
			if (GameConstant.keyPressed.contains(controlKeys.get("jumpKey"))) {
				if (getSpeed_y() < 0.5 && isOnGround()) {
					setSpeed_y(-getJumpStrength());
				}
			}
		}
		setOnGround(false);
		setX(getX() + getSpeed_x());
		
	}

	@Override
	public void onCollide(Collidable target) {}
}