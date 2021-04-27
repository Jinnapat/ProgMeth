package item;

public class Bullet{
	private double speed;

	public Bullet() {
		super();
		this.speed = 10;
	}

	public Bullet(double x, double y, double speed) {
//		this.x = x;
//		this.y = y;
		this.speed = speed;
		// TODO Auto-generated constructor stub
	}
	
	public void shoot() {
		System.out.println("Bang!");
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public static void main(String[] args) {
		System.out.println("Ok");
	}
	
}
