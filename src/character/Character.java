package character;

import interfaces.Collidable;
import interfaces.Movable;
import item.Weapon;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class Character implements Collidable, Movable {
	protected String name;
	protected int ammo;
	protected int maxHealth;
	protected int health;
	protected int speed;
	protected HBox characterBox;
	protected double x;
	protected double y;
	protected AnimationTimer animationTimer;
	protected AnimationTimer animationTimer2;
	protected long lastTimeTriggered;
	protected boolean isKeyPress;
	protected Weapon weapon;
	
	public Character() {
		this.animationTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 10000000)
				{
					if (y < 400) {
						setY(y + 1);
					}
					
					if (isKeyPress) {
						setX(x + 1);
					}
					AnchorPane.setTopAnchor(characterBox, y);
					lastTimeTriggered = now;
				}
			}
		};
		
		this.animationTimer.start();
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public HBox getCharacterBox() {
		return characterBox;
	}

	public void setCharacterBox(HBox characterBox) {
		this.characterBox = characterBox;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@Override
	public void OnCollide(Collidable target) {}

	
	
}
