package sceneObject;

import character.Character;
import item.derived.DropBox;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Ground extends SolidObject {
	
	public Ground(double width, double height, double x, double y, Color color) {
		super(width, height);
		this.setX(x);
		this.setY(y);
		this.getBoundBox().setPrefWidth(width);
		this.getBoundBox().setPrefHeight(height);
		
		Image image = new Image(ClassLoader.getSystemResource("images/Platform.png").toString());
		int tileNumber = (int) (width / 50);
		double blockWidth = width / tileNumber;
		for (int i = 0; i < tileNumber; i++) {
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(height);
			imageView.setFitWidth(blockWidth);
			AnchorPane.setLeftAnchor(imageView, i * blockWidth);
			this.getBoundBox().getChildren().add(imageView);
		}
		
		AnchorPane.setTopAnchor(this.getBoundBox(), getY());
		AnchorPane.setLeftAnchor(this.getBoundBox(), getX());
		GameScene.solidObjects.add(this);
		GameScene.root.getChildren().add(getBoundBox());
		checkCollide();
	}

	@Override
	public void onCollide(SolidObject target) {
		if (target instanceof Character) {
			Character targetCharacter = (Character)target;
			double bottom_y = targetCharacter.getY() + targetCharacter.getHeight();
			if (bottom_y >= this.getY() && bottom_y <= this.getY() + this.getHeight()) {
				
				if (targetCharacter.getSpeed_y() > 0) {
					targetCharacter.setSpeed_y(0.0);
					targetCharacter.setY(this.getY() - targetCharacter.getHeight());
				}
				
				targetCharacter.setOnGround(true);
				
			} else if (targetCharacter.getSpeed_y() > 0.0) {
				
				double left_x = targetCharacter.getX();
				if (left_x >= this.getX() && left_x <= this.getX() + this.getWidth()) {
					if (targetCharacter.getSpeed_x() < 0.0) {
						targetCharacter.setX(this.getX() + this.getWidth());
						targetCharacter.setSpeed_x(0.0);
					}
				}
				
				double right_x = targetCharacter.getX() + targetCharacter.getWidth();
				if (right_x >= this.getX() && right_x <= this.getX() + this.getWidth()) {
					if (targetCharacter.getSpeed_x() > 0.0) {
						targetCharacter.setX(this.getX() - targetCharacter.getWidth());
						targetCharacter.setSpeed_x(0.0);
					}
				}	
			}
		} else if(target instanceof DropBox) {
			DropBox targetDropBox = (DropBox) target;
			double bottom_y = targetDropBox.getY() + targetDropBox.getHeight();
			if (bottom_y >= this.getY() && bottom_y <= this.getY() + this.getHeight()) {
				
				if (targetDropBox.getSpeed_y() > 0) {
					targetDropBox.setSpeed_y(0.0);
					targetDropBox.setY(this.getY() - targetDropBox.getHeight());
				}
				
//				targetDropBox.setOnGround(true);
				
			}
		}
	}
	
}
