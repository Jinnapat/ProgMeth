package item;

public abstract class Item {
	
	protected String name;
	protected String sprite;
	protected double x;
	protected double y;
	
	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(String name, String sprite, double x, double y) {
		super();
		this.name = name;
		this.sprite = sprite;
		this.x = x;
		this.y = y;
	}

	// TODO
	public void collectBy() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSprite() {
		return sprite;
	}

	public void setSprite(String sprite) {
		this.sprite = sprite;
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

	
	
}
