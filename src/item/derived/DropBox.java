package item.derived;

import character.Character;
import constants.ImageHolder;
import interfaces.Collidable;
import item.base.Item;
import item.base.Utility;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import logic.ImageLogic;
import logic.RenderableHolder;
import sceneObject.GameScene;
import sceneObject.SolidObject;
import character.Character;

public class DropBox extends Utility{
	
	public DropBox() {
		super();
		this.setX(50);
		this.setY(50);
		this.setSprite(ImageHolder.getInstance().box);
		RenderableHolder.getInstance().addObject(this);
	}
	
	public DropBox(double width, double height, double x, double y) {
		this();
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
	}

	@Override
	public void collectBy(Character character) {
		character.setWeapon(null);
	}

	@Override
	public void onCollide(Collidable target) {
		if(target instanceof Character) {
			Character targetCharacter = (Character) target;
			collectBy(targetCharacter);
			RenderableHolder.getInstance().addGarbage(this);
			System.out.println("Get DropBox");
		}
	}

}
