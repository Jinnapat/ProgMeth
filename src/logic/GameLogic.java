package logic;

import sceneObject.SolidObject;

public class GameLogic {
	public boolean willCollide(SolidObject o1, SolidObject o2) {
		
		/////TODO/////
		double targetX1 = o2.getX();
		double targetX2 = o2.getX() + o2.getWidth();
		double targetY1 = o2.getY();
		double targetY2 = o2.getY() + o2.getHeight();
								
		
		boolean x_collide = false;
		boolean y_collide = false;
		boolean collided = false;

		double x1 = o1.getX();
		double x2 = o1.getX() + o1.getWidth();
		double y1 = o1.getY();
		double y2 = o1.getY() + o1.getHeight();
		
		if (x1 <= targetX2 &&  x1 >= targetX1) {
			x_collide = true;
		} else if (x2 <= targetX2 &&  x2 >= targetX1) {
			x_collide = true;
		}
			
		if ((y1 <= targetY2 &&  y1 >= targetY1)) {
			y_collide = true;
		} else if ((y2 <= targetY2 &&  y2 >= targetY1)) {
			y_collide = true;
		}
		
		if (targetX1 < x2 &&  targetX1 >= x1) {
			x_collide = true;
		} else if (targetX2 <= x2 &&  targetX2 >= x1) {
			x_collide = true;
		}
		
		if ((targetY1 <= y2 &&  targetY1 >= y1)) {
			y_collide = true;
		} else if ((targetY2 <= y2 &&  targetY2 >= y1)) {
			y_collide = true;
		}
		
		collided = x_collide && y_collide;
		return collided;
	}
}
