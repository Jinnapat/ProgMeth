package sceneObject;

import java.util.ArrayList;

public abstract class SolidObject {
	protected double width;
	protected double height;
	protected double x;
	protected double y;
	protected ArrayList<SolidObject> collideList;
	
	public SolidObject(double width, double height, double x, double y) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.collideList = new ArrayList();
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
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
	
	public void addCollidableObject(SolidObject target) {
		this.collideList.add(target);
	}
	
	public void checkCollide() {
		Thread thread = new Thread(() -> {
			
			for (int i = 0; i < collideList.size(); i++) {
				SolidObject target = collideList.get(i);
				boolean collided = false;
				double targetX1 = target.getX();
				double targetX2 = target.getX() + target.getWidth();
				double targetY1 = target.getY();
				double targetY2 = target.getY() + target.getHeight();
				
				if (x < targetX2 &&  x > targetX1) {
					if ((y < targetY2 &&  y > targetY1)) {
						collided = true;
					}
				}
				
				if (collided) {
					System.out.println("Collide");
				}
				
			}

		});
		
		thread.start();
	}
	
	public abstract void onCollide();
}
