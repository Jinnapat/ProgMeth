package sceneObject;

import character.Character;
import constants.GameConstant;
import constants.PriorityConstant;
import interfaces.Collidable;
import item.base.Utility;
import item.derived.Mine;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.GameLogic;
import logic.ImageLogic;
import logic.RenderableHolder;

public class Ground extends SolidObject {

	private boolean passable;

	public Ground(double width, double height, double x, double y, boolean passable) {
		super(width, height);
		this.setX(x);
		this.setY(y);
		this.passable = passable;

		Image image = new Image(ClassLoader.getSystemResource("images/Platform.png").toString());
		image = ImageLogic.resizeImage(image, width, height);
		this.setSprite(image);

		RenderableHolder.getInstance().addObject(this);
		checkCollide();
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

	private void handleCharacterFromAbove(Character targetCharacter, double deltaX) {
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
	}
	
	private void handleCharacterFromBelow(Character targetCharacter, double deltaX) {
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
	}
	private void handleCharacterFromSides(Character targetCharacter, double deltaY) {
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
	}
	
	private void handleCollideNotCharacter(SolidObject obj) {
		double bottom_y = obj.getY() + obj.getHeight();
		if (bottom_y >= this.getY() && bottom_y <= this.getY() + this.getHeight()) {

			if (obj.getSpeed_y() > 0) {
				obj.setSpeed_y(0.0);
				obj.setY(this.getY() - obj.getHeight());
			}

		}
	}
	@Override
	public void onCollide(Collidable target) {
		if (target instanceof Character) {
			Character targetCharacter = (Character) target;

			double deltaX = GameLogic.calculateCollideDeltaX((SolidObject)this, (SolidObject)target);
			double deltaY = GameLogic.calculateCollideDeltaY((SolidObject)this, (SolidObject)target);

			this.handleCharacterFromAbove(targetCharacter, deltaX);
			this.handleCharacterFromBelow(targetCharacter, deltaX);
			this.handleCharacterFromSides(targetCharacter, deltaY);

		} else if (target instanceof SolidObject) {
			this.handleCollideNotCharacter((SolidObject)target);
		}
	}

}
