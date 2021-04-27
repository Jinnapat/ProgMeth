package item;

import character.Character;

public class Weapon extends Item{
	
	private int maxAmmo;
	private int currentAmmo;
	private double fireRate;
	private double range;
	private double runSpeed; //percent
	private Bullet bullet;
	
	public Weapon() {
		super();
		this.maxAmmo = 10;
		this.currentAmmo = this.maxAmmo;
		this.fireRate = 10;
		this.range = 10;
		this.runSpeed = 100.00;
	}
	
	public Weapon(int maxAmmo, int currentAmmo, double fireRate, double range, double runSpeed) {
		super();
		this.maxAmmo = maxAmmo;
		this.currentAmmo = currentAmmo;
		this.fireRate = fireRate;
		this.range = range;
		this.runSpeed = runSpeed;
	}
	
	public void refillAmmo() {
		this.currentAmmo = this.maxAmmo;
	}
	
	public void shoot() {
		
	}
	
	public void disarm(Character character) {
		
	}

	public void collectBy(Character character) {
		
	}
}
