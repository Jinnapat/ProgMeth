package item.base;

import character.Character;
import constants.PriorityConstant;
import exception.ShootFailedException;
import interfaces.Collidable;
import interfaces.Movable;
import javafx.scene.canvas.GraphicsContext;
import logic.RenderableHolder;

public abstract class Weapon extends Item implements Movable{
	
	private int maxAmmo;
	private int currentAmmo;
	private double coolDown;
	private double fireRate;
	private int damage;
	private double bulletSpeed;
	private double range;
	private Character player;
	
	public Weapon() {
		super();
		this.setName(null);
		this.maxAmmo = 10;
		this.fireRate = 10;
		this.range = 10;
		this.setDamage(10);
		this.coolDown = 0.0;
		this.setBulletSpeed(1);
		this.setPlayer(null);
		this.refillAmmo();
		this.update();
	}
	
	public Weapon(int maxAmmo, double fireRate, int damage, double range, double runSpeed) {
		this();
		this.maxAmmo = maxAmmo;
		this.setFireRate(fireRate);
		this.setDamage(damage);
		this.coolDown = 0.0;
		this.refillAmmo();
		this.update();
	}
	
	public void refillAmmo() {
		this.currentAmmo = this.maxAmmo;
	}
	
	public void holdTrigger(double x, double y, boolean headLeft){
		if (coolDown <= 0.0) {
			if(this.currentAmmo > 0) {
				int side = 1;
				if (headLeft) {
					side = -1;
				}
				this.currentAmmo -= 1;
				try {
					this.shoot(x, y, side);
				} catch(ShootFailedException e){
					System.out.println("Shoot Failed");
				}
			} else {
				System.out.println("Can't shoot");
			}
			coolDown = 100.0;
		}
	}
	
	public abstract void shoot(double x, double y, int side) throws ShootFailedException;
	
	public void update() {
		
		if (getCoolDown() > 0.0) {
			setCoolDown(getCoolDown() - (getFireRate()));
		}

		if(player != null) {
			setX(player.getX() - getWidth()/2);
			setY(player.getY() + getHeight()/2);
		}
		
	}

	public void collectBy(Character character) {
		((Character) character).setWeapon(this);
	}

	public int getMaxAmmo() {
		return maxAmmo;
	}

	public void setMaxAmmo(int maxAmmo) {
		this.maxAmmo = maxAmmo;
		this.refillAmmo();
	}

	public int getCurrentAmmo() {
		return currentAmmo;
	}

	public void setCurrentAmmo(int currentAmmo) {
		this.currentAmmo = currentAmmo;
	}

	public double getFireRate() {
		return fireRate;
	}

	public void setFireRate(double fireRate) {
		this.fireRate = Math.max(fireRate, 0.00d);
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = Math.max(range, 0.00d);
	}

	public double getCoolDown() {
		return coolDown;
	}

	public void setCoolDown(double coolDown) {
		this.coolDown = coolDown;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getBulletSpeed() {
		return bulletSpeed;
	}

	public void setBulletSpeed(double bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}
	
	public Character getPlayer() {
		return player;
	}

	public void setPlayer(Character player) {
		this.player = player;
	}

	@Override
	public int getZ() {
		return PriorityConstant.WEAPON;
	}

	@Override
	public void draw(GraphicsContext gc) {
		if (getSprite() != null) {
			if (player != null) {
				int side = 1;
				if (player.isHeadLeft()) {
					side = -1;
				}
				double offsetX = Math.min(0.0, getSprite().getWidth() * side);
				gc.drawImage(getSprite(), getX() - offsetX, getY(), getSprite().getWidth() * side, getSprite().getHeight());
			} else {
				gc.drawImage(getSprite(), getX(), getY(), getSprite().getWidth(), getSprite().getHeight());
			}
		}
	}


	@Override
	public void onCollide(Collidable target) {
		if(this.player == null) {
			if(target instanceof Character) {
				Character targetCharacter = (Character) target;
				if(targetCharacter.getWeapon() == null) {
					targetCharacter.setWeapon(this);
				}
			}
		}
	}
	
	
}
