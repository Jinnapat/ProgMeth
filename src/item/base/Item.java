package item.base;
import character.Character;
import sceneObject.GameScene;
import sceneObject.SolidObject;

public abstract class Item extends SolidObject{
	
	protected String name;
	protected double xPos;
	protected double yPos;
	
	
	public Item() {
		super(10, 10, 10, 10);
		this.setName(null);
		super.checkCollide();
		
		GameScene.solidObjects.add(this);
		GameScene.root.getChildren().add(this.getBoundBox());
	}
	
	public Item(String name) {
		this();
		this.setName(name);
		// TODO Auto-generated constructor stub
	}

	public Item(String name, double xPos, double yPos) {
		this();
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
		if(name == null || name.isBlank()) {
			this.name = "Unnamed";
		} else {
			this.name = name;
		}
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
