package item;

import java.util.ArrayList;

import character.Character;

public class Weapon extends Item{
	
	private int maxAmmo;
	private int currentAmmo;
	private double fireRate;
	private double range;
	private double runSpeed; //percent
	private ArrayList<Bullet> bullets;
	
	public Weapon() {
		super();
		this.maxAmmo = 10;
		this.fireRate = 10;
		this.range = 10;
		this.runSpeed = 100.00;
		this.refillAmmo();
	}
	
	public Weapon(int maxAmmo, double fireRate, double range, double runSpeed) {
		super();
		this.maxAmmo = maxAmmo;
		this.setFireRate(fireRate);
		this.setRunSpeed(runSpeed);
		this.refillAmmo();
	}
	
	public void refillAmmo() {
		this.currentAmmo = this.maxAmmo;
		this.bullets.clear();
		this.bullets = new ArrayList<Bullet>();
		for(int i=0; i<this.maxAmmo; i++) {
			bullets.add(new Bullet(i, i, i, i));
		}
	}
	
	public void shoot() {
		if(this.currentAmmo > 0) {
			this.currentAmmo -= 1;
			this.bullets.get(currentAmmo).shoot();
			this.bullets.remove(currentAmmo);
			
			// try to create bullet ui
			
		} else {
			System.out.println("Can't shoot");
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
	
	
}
