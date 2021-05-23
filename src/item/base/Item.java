package item.base;
import character.Character;
import sceneObject.SolidObject;

public abstract class Item extends SolidObject{
	
	protected String name;
	
	public Item() {
		super(10, 10, 10, 10);
		this.setName(null);
	}
	
	public Item(String name) {
		this();
		this.setName(name);
	}

	public Item(String name, double xPos, double yPos) {
		this();
		this.setName(name);
		this.setX(xPos);
		this.setY(yPos);
	}

	public abstract void collectBy(Character character);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.isBlank()) {
			this.name = "Unnamed";
		} else {
			this.name = name;
		}
	}

}
