package item.derived;

import character.Character;
import constants.ImageHolder;
import interfaces.Collidable;
import item.base.Utility;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import logic.DamageLogic;
import logic.ImageLogic;
import logic.RenderableHolder;
import sceneObject.GameScene;
import sceneObject.SolidObject;

public class Bandage extends Utility {

	public Bandage() {
		super();
		this.setX(50);
		this.setY(50);
		ImageLogic.resizeAndsetSprite(this, ImageHolder.getInstance().heartPlus, 32, 32);
	}

	public Bandage(double width, double height, double x, double y) {
		this();
		this.setX(x);
		this.setY(y);
		ImageLogic.resizeAndsetSprite(this, ImageHolder.getInstance().heartPlus, width, height);
	}

	@Override
	public void collectBy(Character character) {
		DamageLogic.calulateHeal(0.3, character);
	}

	@Override
	public void onCollide(Collidable target) {
		// TODO Auto-generated method stub
		if (target != null) {
			if (target instanceof Character) {
				Character targetCharacter = (Character) target;
				this.collectBy(targetCharacter);
//				GameScene.solidObjects.remove(this);
//				GameScene.root.getChildren().remove(this.getBoundBox());
				System.out.println("Get Bandage");
				this.isDestroy = true;
				RenderableHolder.getInstance().addGarbage(this);
			}
		}
	}

}
