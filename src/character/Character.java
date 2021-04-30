package character;

import interfaces.Collidable;
import interfaces.Movable;
import item.Weapon;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import sceneObject.SolidObject;
import sceneObject.GameScene;

public class Character extends SolidObject implements Collidable, Movable {
	protected String name;
	protected int ammo;
	protected int maxHealth;
	protected int health;
	protected double speed;
	protected AnchorPane characterBox;
	protected double y_speed;
	protected AnimationTimer animationTimer;
	protected AnimationTimer animationTimer2;
	protected long lastTimeTriggered;
	protected boolean isKeyPress;
	protected Weapon weapon;

	protected boolean isHeadLeft;
	
	public Character(double width, double height, double x, double y, double speed) {
		super(width, height, x, y);
		setSpeed(speed);
		setY_speed(0.0);
		
		this.animationTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 10000000)
				{

					
					if (getY() < 400) {
						setY(getY() + GameScene.gravity_g);
					} else {
						setY_speed(0.0);
					}
					
					
					if (GameScene.keyPressed.get("a")) {
						System.out.println(getX());
						
						setX(getX() - getSpeed());
					}
					
					if (GameScene.keyPressed.get("d")) {
						setX(getX() + getSpeed());
					}
					
					if (GameScene.keyPressed.get("w")) {

					}
					
					AnchorPane.setTopAnchor(characterBox, getY());
					AnchorPane.setLeftAnchor(characterBox, getX());
					lastTimeTriggered = now;
				}
			}
		};
		
		this.animationTimer.start();
	}
	
	
	public double getY_speed() {
		return y_speed;
	}

	public void setY_speed(double y_speed) {
		if (y_speed > 0) {
			this.y_speed = y_speed;
		} else {
			this.y_speed = 0;
		}
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

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		if (speed > 0) {
			this.speed = speed;
		} else {
			this.speed = 1;
		}
		
	}

	public AnchorPane getCharacterBox() {
		return characterBox;
	}

	public void setCharacterBox(AnchorPane characterBox) {
		this.characterBox = characterBox;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}


	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onCollide(Collidable target) {
		// TODO Auto-generated method stub
		
	}
	
	
}
