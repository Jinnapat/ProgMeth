package logic;

import sceneObject.SolidObject;
import systemMemory.Memory;
import character.Character;

public class GameLogic {
	
	public static double calculateDelta(double x1, double x2, double tx1, double tx2) {
		if (x1 >= tx1 && x1 <= tx2) {
			if (x2 >= tx1 && x2 <= tx2) {
				return x2 - x1;
			} else {
				return tx2 - x1;
			}
		} else {
			if (x2 >= tx1 && x2 <= tx2) {
				return x2 - tx1;
			} else {
				return tx2 - tx1;
			}
		}
	}
	
	public static double calculateCollideDeltaX(SolidObject o1, SolidObject o2) {
		double x1 = o1.getX();
		double x2 = o1.getX() + o1.getWidth();
		double tx1 = o2.getX();
		double tx2 = o2.getX() + o2.getWidth();
		return calculateDelta(x1, x2, tx1, tx2);
		
	}
	
	public static double calculateCollideDeltaY(SolidObject o1, SolidObject o2) {
		double y1 = o1.getY();
		double y2 = o1.getY() + o1.getHeight();
		double ty1 = o2.getY();
		double ty2 = o2.getY() + o2.getHeight();
		return calculateDelta(y1, y2, ty1, ty2);
		
	}
	
	public static boolean willCollide(SolidObject o1, SolidObject o2) {

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

		if (x1 <= targetX2 && x1 >= targetX1) {
			x_collide = true;
		} else if (x2 <= targetX2 && x2 >= targetX1) {
			x_collide = true;
		}

		if ((y1 <= targetY2 && y1 >= targetY1)) {
			y_collide = true;
		} else if ((y2 <= targetY2 && y2 >= targetY1)) {
			y_collide = true;
		}

		if (targetX1 < x2 && targetX1 >= x1) {
			x_collide = true;
		} else if (targetX2 <= x2 && targetX2 >= x1) {
			x_collide = true;
		}

		if ((targetY1 <= y2 && targetY1 >= y1)) {
			y_collide = true;
		} else if ((targetY2 <= y2 && targetY2 >= y1)) {
			y_collide = true;
		}

		collided = x_collide && y_collide;
		return collided;
	}

	public static boolean isEndGame() {
		Character P1 = Memory.getInstance().selectionGui.getSelectCharacterBox().getCharacter();
		Character P2 = Memory.getInstance().selectionGui.getSelectCharacterBox2().getCharacter();
		if (P1.getState().equals("dying")) {
			Memory.getInstance().endGameGui.setWinnerName(P2.getName());
			return true;
		} else if(P2.getState().equals("dying")) {
			Memory.getInstance().endGameGui.setWinnerName(P1.getName());
			return true;
		}
		return false;
	}
	
	public static void fixNameDuplicate() {
		String name1 = Memory.getInstance().selectionGui.getSelectCharacterBox().getCharacter().getName();
		String name2 = Memory.getInstance().selectionGui.getSelectCharacterBox2().getCharacter().getName();
		
		if(name1.equals(name2)) {
			Memory.getInstance().selectionGui.getSelectCharacterBox2().getCharacter().setName(name2 + " 1");
		}
	}
}
