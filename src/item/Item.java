package Item;

public abstract class Item {
	
	protected String name;
	protected String sprite;
	int x;
	int y;
	
	public Item(String name, String sprite, int x, int y) {
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
