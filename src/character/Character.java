package character;

import interfaces.Collidable;
import interfaces.IRenderable;
import interfaces.Movable;
import item.base.Weapon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import sceneObject.SolidObject;
import java.util.ArrayList;
import java.util.HashMap;
import constants.GameConstant;
import constants.PriorityConstant;

public abstract class Character extends SolidObject implements Movable, IRenderable {
	protected String name;
	protected int maxHealth;
	protected int health;
	protected double speed;
	protected boolean isHeadLeft;
	protected double jumpStrength;
	protected Weapon weapon;
	protected int standStillTime = 0;
	private HashMap<String, KeyCode> controlKeys;
	private boolean onGround;
	private String state;
	private int curImage = 0;
	private ArrayList<Image> runImages;
	private ArrayList<Image> idleImages;
	private ArrayList<Image> dieImages;
	private boolean checkControls;
	private int currentAnimationDelay;

	public Character(double width, double height, double speed, double jumpStrength, int maxHealth, String color) {
		super(width, height);
		this.name = "";
		this.speed = speed;
		this.jumpStrength = jumpStrength;
		this.currentAnimationDelay = GameConstant.CHARACTER_ANIMATION_DELAY;
		this.setMaxHealth(maxHealth);
		this.setHealth(maxHealth);
		this.state = "idle";
		
		controlKeys = new HashMap<String, KeyCode>();
		controlKeys.put("leftKey", KeyCode.A);
		controlKeys.put("rightKey", KeyCode.D);
		controlKeys.put("jumpKey", KeyCode.W);
		controlKeys.put("shootKey", KeyCode.SPACE);

		this.loadSprites(color);
		this.setSprite(this.idleImages.get(0));
	}

	private void loadSprites(String color) {
		runImages = new ArrayList<Image>();
		idleImages = new ArrayList<Image>();
		dieImages = new ArrayList<Image>();
		
		for (int i = 1; i <= 6; i++) {
			runImages.add(
					new Image(ClassLoader.getSystemResource("character/" + color + "/run/" + i + ".png").toString(),
							0.0, 50.0, true, false));
		}
		for (int i = 1; i <= 5; i++) {
			idleImages.add(
					new Image(ClassLoader.getSystemResource("character/" + color + "/idle/" + i + ".png").toString(),
							0.0, 50.0, true, false));
		}
		for (int i = 1; i <= 8; i++) {
			dieImages.add(
					new Image(ClassLoader.getSystemResource("character/" + color + "/die/" + i + ".png").toString(),
							0.0, 50.0, true, false));
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setHealth(int newHealth) {
		if (newHealth <= 0) {
			this.health = 0;
			this.setCheckControls(false);
			this.curImage = 0;
			setState("dying");
		} else if (newHealth > getMaxHealth()) {
			this.health = getMaxHealth();
		} else {
			this.health = newHealth;
		}
	}

	public boolean isHeadLeft() {
		return isHeadLeft;
	}

	public void setHeadLeft(boolean isHeadLeft) {
		this.isHeadLeft = isHeadLeft;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon newWeapon) {
		this.weapon = newWeapon;
		if (newWeapon != null) {
			weapon.setPlayer(this);
		}
	}

	public HashMap<String, KeyCode> getControlKeys() {
		return controlKeys;
	}

	public void setControlKeys(HashMap<String, KeyCode> controlKeys) {
		this.controlKeys = controlKeys;
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
			currentAnimationDelay = GameConstant.CHARACTER_ANIMATION_DELAY;
		}

		if (getState() == "idle") {
			this.curImage = (curImage) % idleImages.size();
			this.updateImage(gc, idleImages);
		} else if (getState() == "running") {
			this.curImage = (curImage) % runImages.size();
			this.updateImage(gc, runImages);
		} else if (getState() == "dying") {
			this.curImage = Math.min(curImage, dieImages.size() - 1);
			this.updateImage(gc, dieImages);
		}

		this.displayTags(gc);
	}

	private void updateImage(GraphicsContext gc, ArrayList<Image> images) {
		int side = 1;
		if (this.isHeadLeft) {
			side = -1;
		}
		
		Image image = images.get(curImage);
		double offsetX = Math.min(0.0, image.getWidth() * side);
		gc.drawImage(image, this.getX() - offsetX, this.getY(), image.getWidth() * side, image.getHeight());
	}
	
	private void displayTags(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		double tagX = getX() - GameConstant.TAGS_OFFSET_X;
		double tagY = getY() - GameConstant.AMMO_TAG_OFFSET_Y;
		if (getWeapon() == null) {
			gc.fillText("No gun", tagX, tagY);
		} else {
			gc.fillText(getWeapon().getName() + " : " + getWeapon().getCurrentAmmo(), tagX, tagY);
		}
		gc.fillText(getName(), tagX, getY() - GameConstant.NAME_TAG_OFFSET_Y);
		gc.setFill(Color.CRIMSON);
		gc.fillRect(tagX, getY() - GameConstant.TAGS_OFFSET_X, getWidth() * getHealth() / getMaxHealth(), GameConstant.HEALTHBAR_HEIGHT);
	}
	
	@Override
	public void update() {
		this.updateNaturalForces();

		if (isCheckControls()) {
			this.handleControls();
			this.upStandStillTime();
		}

		this.act();
		setOnGround(false);

	}

	private void handleControls() {

		ArrayList<KeyCode> keyPressed = GameConstant.keyPressed;
		if (keyPressed.contains(controlKeys.get("leftKey"))) {
			this.handleMoveLeft();
			
		} else if (keyPressed.contains(controlKeys.get("rightKey"))) {
			this.handleMoveRight();
		} else {
			setState("idle");
		}

		if (keyPressed.contains(controlKeys.get("shootKey"))) {
			this.handleShoot();
		}

		if (keyPressed.contains(controlKeys.get("jumpKey"))) {
			this.handleJump();
		}
	}
	
	private void upStandStillTime() {
		boolean takeAction = false;
		ArrayList<KeyCode> keyPressed = GameConstant.keyPressed;
		if (keyPressed.contains(controlKeys.get("leftKey"))) {
			takeAction = true;
		}
		if (keyPressed.contains(controlKeys.get("rightKey"))) {
			takeAction = true;	
		}
		if (keyPressed.contains(controlKeys.get("shootKey"))) {
			takeAction = true;
		}
		if (keyPressed.contains(controlKeys.get("jumpKey"))) {
			takeAction = true;
		}

		if (takeAction) {
			this.standStillTime = 0;
		}
		this.standStillTime += 1;
	}
	
	private void updateNaturalForces() {
		setSpeed_x(getSpeed_x() * getFriction());

		double newSpeed = getSpeed_y() + GameConstant.GRAVITY_G;
		setSpeed_y(newSpeed);

		if (getY() > GameConstant.WINDOW_HEIGHT + this.getHeight()) {
			this.setHealth(0);
		}
	}
	
	private void handleMoveLeft() {
		setSpeed_x(-speed);
		setHeadLeft(true);
		setState("running");
	}
	
	private void handleMoveRight() {
		setSpeed_x(speed);
		setHeadLeft(false);
		setState("running");
	}
	
	private void handleJump() {
		if (getSpeed_y() < 0.5 && isOnGround()) {
			setSpeed_y(-getJumpStrength());
		}
	}
	
	private void handleShoot() {
		if (getWeapon() != null) {
			double bulletSpawnX = 0.0;
			if (isHeadLeft()) {
				bulletSpawnX = getX() - GameConstant.BULLET_SPAWN_OFFSET_X;
			} else {
				bulletSpawnX = getX() + getWidth() + GameConstant.BULLET_SPAWN_OFFSET_X;
			}
			getWeapon().holdTrigger(bulletSpawnX, getY() + (getHeight() / 2.0), isHeadLeft());
		} else {
			System.out.println("No weapon!");
		}
	}
	
	@Override
	public void onCollide(Collidable target) {
	}

	public abstract void act();
}