package item.derived;

import character.Engineer;
import constants.GameConstant;
import constants.ImageHolder;
import interfaces.Collidable;
import interfaces.Movable;
import javafx.scene.canvas.GraphicsContext;
import logic.DamageLogic;
import logic.ImageLogic;
import logic.RenderableHolder;
import sceneObject.SolidObject;
import character.Character;

public class Mine extends SolidObject implements Movable{

	private boolean triggered = false;
	
	public Mine(double width, double height, double x, double y) {
		super(width, height);
		this.setX(x);
		this.setY(y);
		ImageLogic.resizeAndsetSprite(this, ImageHolder.getInstance().mine, width, height);
	}

	@Override
	public int getZ() {
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY());
	}

	@Override
	public void onCollide(Collidable target) {
		if (target != null) {
			if (target instanceof Character && !(target instanceof Engineer) && !this.triggered) {
				Character targetCharacter = (Character) target;
				DamageLogic.calculateDamage(100, targetCharacter);
				RenderableHolder.getInstance().addGarbage(this);
				this.triggered = true;
			}
		}
	}

	@Override
	public void update() {
		double newSpeed = getSpeed_y() + GameConstant.GRAVITY_G;
		setSpeed_y(newSpeed);
	}

}
