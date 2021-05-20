package item.derived;

import character.Character;
import item.base.Item;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import sceneObject.GameScene;
import sceneObject.SolidObject;
import character.Character;

public class DropBox extends Item{
	
	public DropBox(double width, double height, double x, double y, Color color) {
		super();
		this.setX(x);
		this.setY(y);
		this.getBoundBox().setPrefWidth(width);
		this.getBoundBox().setPrefHeight(height);
		this.getBoundBox().setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
		
		checkCollide();
	}

	@Override
	public void collectBy(Character character) {
		// TODO Auto-generated method stub
		character.setWeapon(null);
	}

	@Override
	public void onCollide(SolidObject target) {
		// TODO Auto-generated method stub
		
	}

}
