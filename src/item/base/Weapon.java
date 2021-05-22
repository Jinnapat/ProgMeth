package item.base;

import java.util.ArrayList;

import character.Character;
import character.Scout;
import interfaces.Collidable;
import interfaces.Movable;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import logic.RenderableHolder;
import sceneObject.SolidObject;

public class Weapon extends Item implements Movable{
	
	private int maxAmmo;
	private int currentAmmo;
	private double coolDown;
	private double fireRate;
	private int damage;
	private double bulletSpeed;
	private double range;
	private double runSpeed; //percent
	private ArrayList<Bullet> bullets;
	private Character player;
	
	public Weapon() {
		super();
		this.setName(null);
		this.maxAmmo = 10;
		this.fireRate = 10;
		this.range = 10;
		this.setDamage(10);
		this.runSpeed = 100.00;
		this.coolDown = 0.0;
		this.setBulletSpeed(1);
		this.setPlayer(null);
		this.refillAmmo();
		this.update();
		RenderableHolder.getInstance().addObject(this);
	}
	
	public Weapon(int maxAmmo, double fireRate, int damage, double range, double runSpeed) {
		this();
		this.maxAmmo = maxAmmo;
		this.setFireRate(fireRate);
		this.setRunSpeed(runSpeed);
		this.setDamage(damage);
		this.coolDown = 0.0;
		this.refillAmmo();
		this.update();
	}
	
	public void refillAmmo() {
		this.currentAmmo = this.maxAmmo;
		if(this.bullets == null) {
			this.bullets = new ArrayList<Bullet>();
		}
		this.bullets.clear();
		
		for(int i=0; i<this.maxAmmo; i++) {
			bullets.add(new Bullet(this.damage, this.bulletSpeed));
		}
	}
	
	public void shoot(double x, double y, boolean isLeftSide) {

		if (coolDown <= 0.0) {
			if(this.currentAmmo > 0) {
				this.currentAmmo -= 1;
//				Bullet bl = new Bullet(this.damage, this.bulletSpeed);
//				bl.shoot(x, y, isLeftSide);
				this.bullets.get(currentAmmo).shoot(x, y, isLeftSide);
				System.out.println(this.currentAmmo);
			} else {
				System.out.println("Can't shoot");
			}
			coolDown = 100.0;
		}
	}
	
	public void update() {
		
		if (getCoolDown() > 0.0) {
			setCoolDown(getCoolDown() - (getFireRate()));
		}

		if(player != null) {
			setX(player.getX() - getWidth()/2);
			setY(player.getY() + getHeight()/2);
			if(getImageView() != null) {
				if(player.isHeadLeft()) {
					getImageView().setScaleX(-1.0);
				}else {
					getImageView().setScaleX(1.0);
				}
			}
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

	public double getRunSpeed() {
		return runSpeed;
	}

	public void setRunSpeed(double runSpeed) {
		this.runSpeed = Math.max(runSpeed, 0.00d);
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
		return 9;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		//////////////TODO///////////////
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
