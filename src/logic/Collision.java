package logic;

import sceneObject.SolidObject;

public class Collision {
	private boolean collided;
	private double intersectX;
	private double intersectY;
	private SolidObject target;
	private double angle;
	
	

	public Collision(boolean collided, double intersectX, double intersectY, SolidObject target, double angle) {
		super();
		this.collided = collided;
		this.intersectX = intersectX;
		this.intersectY = intersectY;
		this.target = target;
		this.angle = angle;
	}

	public boolean isCollided() {
		return collided;
	}

	public void setCollided(boolean collided) {
		this.collided = collided;
	}

	public double getIntersectX() {
		return intersectX;
	}

	public void setIntersectX(double intersectX) {
		this.intersectX = intersectX;
	}

	public double getIntersectY() {
		return intersectY;
	}

	public void setIntersectY(double intersectY) {
		this.intersectY = intersectY;
	}

	public SolidObject getTarget() {
		return target;
	}

	public void setTarget(SolidObject target) {
		this.target = target;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
}
