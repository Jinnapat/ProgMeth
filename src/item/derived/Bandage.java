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

public class Bandage extends Utility{

	public Bandage() {
		super();
		this.setX(50);
		this.setY(50);
		this.setSprite(ImageHolder.getInstance().heartPlus);
	}
	
	public Bandage(double width, double height, double x, double y) {
		this();
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
	}

	@Override
	public void collectBy(Character character) {
		DamageLogic.calulateHeal(0.3, character);
	}

	@Override
	public void onCollide(Collidable target) {
		if(target instanceof Character) {
			Character targetCharacter = (Character) target;
			collectBy(targetCharacter);
			RenderableHolder.getInstance().addGarbage(this);
			System.out.println("Healed");
		}
	}

}
