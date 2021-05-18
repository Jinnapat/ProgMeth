package item.base;
import character.Character;
import sceneObject.SolidObject;

public abstract class Item extends SolidObject{
	
	protected String name;
	protected double xPos;
	protected double yPos;
	
	
	
	public Item() {
		super(10, 10, 10, 10);
		// TODO Auto-generated constructor stub
	}

	public Item(String name, String sprite, double xPos, double yPos) {
		super(yPos, yPos, yPos, yPos);
		this.setName(name);
		this.setxPos(xPos);
		this.setyPos(yPos);
	}

	// TODO
	public abstract void collectBy(Character character);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.isBlank() ? "Unnamed": name;
	}


	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
	
}
