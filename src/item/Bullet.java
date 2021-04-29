package item;

public class Bullet{
	private double xPos;
	private double yPos;
	private double speed;

	public Bullet() {
		super();
		this.speed = 10;
	}

	public Bullet(double xPos, double yPos, double speed) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
		// TODO Auto-generated constructor stub
	}
	
	public void shoot() {
		System.out.println("Bang!");
		// TODO
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
}
