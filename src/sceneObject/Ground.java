package sceneObject;

import character.Character;
import constants.GameConstant;
import constants.PriorityConstant;
import interfaces.Collidable;
import item.base.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.ImageLogic;
import logic.RenderableHolder;

public class Ground extends SolidObject {

	private boolean passable;

	public Ground(double width, double height, double x, double y, boolean passsable) {
		super(width, height);
		this.setX(x);
		this.setY(y);
		this.passable = passsable;

		Image image = new Image(ClassLoader.getSystemResource("images/Platform.png").toString());
		image = ImageLogic.resizeImage(image, width, height);
		this.setSprite(image);

		RenderableHolder.getInstance().addObject(this);
		checkCollide();
	}

	public double calculateDelta(double x1, double x2, double tx1, double tx2) {
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

	@Override
	public int getZ() {
		return PriorityConstant.GROUND;
	}

	@Override
	public void draw(GraphicsContext gc) {
		int tileNumber = (int) (this.getWidth() / 50);
		double blockWidth = this.getWidth() / tileNumber;
		for (int i = 0; i < tileNumber; i++) {
			gc.drawImage(this.getSprite(), this.getX() + i * blockWidth, this.getY(), blockWidth, this.getHeight());
		}
	}

	@Override
	public void onCollide(Collidable target) {
		if (target instanceof Character) {
			Character targetCharacter = (Character) target;

			double x1 = getX();
			double x2 = getX() + getWidth();
			double tx1 = targetCharacter.getX();
			double tx2 = targetCharacter.getX() + targetCharacter.getWidth();

			double y1 = getY();
			double y2 = getY() + getHeight();
			double ty1 = targetCharacter.getY();
			double ty2 = targetCharacter.getY() + targetCharacter.getHeight();

			double deltaX = calculateDelta(x1, x2, tx1, tx2);
			double deltaY = calculateDelta(y1, y2, ty1, ty2);

			if (targetCharacter.getSpeed_y() > 0.0) {
				if (deltaX > 10.0) {
					double bottom_y = targetCharacter.getY() + targetCharacter.getHeight()
							+ targetCharacter.getSpeed_y();
					if (bottom_y >= this.getY() && bottom_y <= this.getY() + this.getHeight()) {
						targetCharacter.setSpeed_y(0);
						targetCharacter.setY(getY() - targetCharacter.getHeight());
						targetCharacter.setOnGround(true);
					}
				}
			}

			if (!passable) {
				if (targetCharacter.getSpeed_y() < 0.0) {
					if (deltaX > GameConstant.CHARACTER_PHYSIC_X_OFFSET) {
						double top_y = targetCharacter.getY() + targetCharacter.getSpeed_y();
						if (top_y >= this.getY() && top_y <= this.getY() + this.getHeight()) {
							targetCharacter.setSpeed_y(0);
							targetCharacter.setY(getY() + getHeight());
						}
					}
				}
			}

			if (deltaY > GameConstant.CHARACTER_PHYSIC_Y_OFFSET) {
				double left_x = targetCharacter.getX() + targetCharacter.getSpeed_x();
				if (left_x >= this.getX() && left_x <= this.getX() + this.getWidth()) {
					targetCharacter.setSpeed_x(0.0);
				}

				double right_x = targetCharacter.getX() + targetCharacter.getWidth() + targetCharacter.getSpeed_x();
				if (right_x >= this.getX() && right_x <= this.getX() + this.getWidth()) {
					targetCharacter.setSpeed_x(0.0);
				}
			}
		} else if (target instanceof Utility) {
			Utility targetUtility = (Utility) target;
			double bottom_y = targetUtility.getY() + targetUtility.getHeight();
			if (bottom_y >= this.getY() && bottom_y <= this.getY() + this.getHeight()) {

				if (targetUtility.getSpeed_y() > 0) {
					targetUtility.setSpeed_y(0.0);
					targetUtility.setY(this.getY() - targetUtility.getHeight());
				}

			}
		}
	}

}
