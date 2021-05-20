package character;

import interfaces.Movable;
import item.base.Weapon;
import javafx.animation.AnimationTimer;
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

import gui.Healthbar;

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
	private String state;
	protected ImageView imageView;
	private AnimationTimer animationLoop;
	private double lastTriggerTime;
	private int curImage = 0;
	private ArrayList<Image> runImages;
	private ArrayList<Image> idleImages;
	private ArrayList<Image> dieImages;
	private boolean checkControls;
	
	public Character(double width, double height, double speed, double jumpStrength, int maxHealth, String color) {
		super(width, height);
		this.state = "idle";
		this.speed = speed;
		this.jumpStrength = jumpStrength;
		this.onGround = false;
		this.checkControls = false;
		nameTag = new Text("New Player");
		nameTag.setTextAlignment(TextAlignment.CENTER);
		nameTag.setWrappingWidth(200);
		healthBar = new Healthbar();
		lastTriggerTime = 0.0;
		
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
		checkControl();
		runImages = new ArrayList<Image>();
		idleImages = new ArrayList<Image>();
		dieImages = new ArrayList<Image>();
		
		for (int i = 1; i <= 6; i++) {
			runImages.add(new Image(ClassLoader.getSystemResource("character/" + color + "/run/" + i + ".png").toString()));
		}
		for (int i = 1; i <= 5; i++) {
			idleImages.add(new Image(ClassLoader.getSystemResource("character/" + color + "/idle/" + i + ".png").toString()));
		}
		for (int i = 1; i <= 8; i++) {
			dieImages.add(new Image(ClassLoader.getSystemResource("character/" + color + "/die/" + i + ".png").toString()));
		}
		
		imageView = new ImageView(idleImages.get(curImage));
		imageView.setFitHeight(50.0);
		imageView.setPreserveRatio(true);
		getBoundBox().getChildren().add(imageView);
		
		this.animationLoop = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				
				lastTriggerTime = (lastTriggerTime < 0 ? now : lastTriggerTime);
				
				if (now - lastTriggerTime >= 100000000) {
					if (getState() == "idle") {
						curImage = (curImage + 1) % idleImages.size();
						imageView.setImage(idleImages.get(curImage));
					} else if (getState() == "running") {
						curImage = (curImage + 1) % runImages.size();
						imageView.setImage(runImages.get(curImage));
					} else if (getState() == "dying") {
						curImage = Math.min(curImage + 1, dieImages.size() - 1);
						imageView.setImage(dieImages.get(curImage));
					}
					lastTriggerTime = now;
				}
			}
		};
		
		this.animationLoop.start();
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

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
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

	public void checkControl() {
		
		this.animationTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 10000000) {
					
					if (isCheckControls()) {
						if (GameScene.keyPressed.contains(controlKeys.get("leftKey"))) {
							setSpeed_x(-speed);
							setHeadLeft(true);
							getImageView().setScaleX(-1.0);
							setState("running");
	
						} else if (GameScene.keyPressed.contains(controlKeys.get("rightKey"))) {
							setSpeed_x(speed);
							setHeadLeft(false);
							getImageView().setScaleX(1.0);
							setState("running");
						} else {
							setState("idle");
						}
						
						if (GameScene.keyPressed.contains(controlKeys.get("shootKey"))) {
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
						
						if (GameScene.keyPressed.contains(controlKeys.get("jumpKey"))) {
							if (getSpeed_y() < 0.5 && isOnGround()) {
								setSpeed_y(-getJumpStrength());
							}
						}
					}
					setOnGround(false);
					double nameTagX = (getX() + (getWidth() / 2.0)) - (getNameTag().getWrappingWidth() / 2.0);
					AnchorPane.setTopAnchor(getNameTag(), getY() - 20);
					AnchorPane.setLeftAnchor(getNameTag(), nameTagX);
					AnchorPane.setTopAnchor(getBoundBox(), getY());
					AnchorPane.setLeftAnchor(getBoundBox(), getX());
					lastTimeTriggered = now;
				}
			}
		};
		
		this.animationTimer.start();
	}
	
	@Override
	public void onCollide(SolidObject target) {}
}