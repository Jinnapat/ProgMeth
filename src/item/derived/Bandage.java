package item.derived;

import character.Character;
import constants.ImageHolder;
import interfaces.Collidable;
import item.base.Utility;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import logic.DamageLogic;
import logic.ImageLogic;
import sceneObject.GameScene;
import sceneObject.SolidObject;

public class Bandage extends Utility{

	public Bandage() {
		super();
		this.setX(50);
		this.setY(50);
		this.setSprite(ImageHolder.getInstance().heartPlus);
		// TODO Auto-generated constructor stub
	}
	
	public Bandage(double width, double height, double x, double y, Color color) {
		this();
		this.setX(x);
		this.setY(y);
		this.getBoundBox().setPrefWidth(width);
		this.getBoundBox().setPrefHeight(height);
	}

	@Override
	public void collectBy(Character character) {
		// TODO Auto-generated method stub
		DamageLogic.calulateHeal(0.3, character);
	}

	@Override
	public void onCollide(Collidable target) {
		// TODO Auto-generated method stub
		if(target != null) {
			if(target instanceof Character) {
				Character targetCharacter = (Character) target;
				DamageLogic.calulateHeal(0.3, targetCharacter);
				GameScene.solidObjects.remove(this);
				GameScene.root.getChildren().remove(this.getBoundBox());
				System.out.println("Get Bandage");
			}
		}
	}

}
