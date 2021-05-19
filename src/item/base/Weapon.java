package item.base;

import java.util.ArrayList;

import character.Character;
import javafx.animation.AnimationTimer;
import sceneObject.SolidObject;

public class Weapon extends Item{
	
	private int maxAmmo;
	private int currentAmmo;
	private double coolDown;
	private double fireRate;
	private int damage;
	private double range;
	private double runSpeed; //percent
	private ArrayList<Bullet> bullets;
	private long lastTimeTriggered;
	
	public Weapon() {
		super();
		this.maxAmmo = 10;
		this.fireRate = 10;
		this.range = 10;
		this.runSpeed = 100.00;
		this.coolDown = 0.0;
		this.bullets = new ArrayList<Bullet>();
		this.refillAmmo();
		this.update();
	}
	
	public Weapon(int maxAmmo, double fireRate, int damage, double range, double runSpeed) {
		super();
		this.maxAmmo = maxAmmo;
		this.setFireRate(fireRate);
		this.setRunSpeed(runSpeed);
		this.setDamage(damage);
		this.coolDown = 0.0;
		this.bullets = new ArrayList<Bullet>();
		this.refillAmmo();
		this.update();
//		AnimationTimer animationTimer = new AnimationTimer() {
//			
//			@Override
//			public void handle(long now) {
//				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
//				
//				if (now - lastTimeTriggered >= 10000000) {
//					
//					if (getCoolDown() > 0.0) {
//						setCoolDown(getCoolDown() - (getFireRate()));
//					}
//					
//					lastTimeTriggered = now;
//				}
//			}
//			
//		};
//		
//		animationTimer.start();
	}
	
	public void refillAmmo() {
		this.currentAmmo = this.maxAmmo;
		this.bullets.clear();
		for(int i=0; i<this.maxAmmo; i++) {
			bullets.add(new Bullet(this.damage));
		}
	}
	
	public void shoot(double x, double y, boolean isLeftSide) {

		if (coolDown <= 0.0) {
			if(this.currentAmmo > 0) {
				this.currentAmmo -= 1;
				this.bullets.get(currentAmmo).shoot(x, y, isLeftSide);
				this.bullets.remove(currentAmmo);
				
				// try to create bullet ui
				
			} else {
				System.out.println("Can't shoot");
			}
			coolDown = 100.0;
		}
	}
	
	private void update() {
		AnimationTimer animationTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 10000000) {
					
					if (getCoolDown() > 0.0) {
						setCoolDown(getCoolDown() - (getFireRate()));
					}
					
					lastTimeTriggered = now;
				}
			}
			
		};
		
		animationTimer.start();
	}

	public void collectBy(Character character) {
		((Character) character).setWeapon(this);
	}

	public int getMaxAmmo() {
		return maxAmmo;
	}

	public void setMaxAmmo(int maxAmmo) {
		this.maxAmmo = maxAmmo;
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

	@Override
	public void onCollide(SolidObject target) {
		// TODO Auto-generated method stub
		
	}
	
	
}
