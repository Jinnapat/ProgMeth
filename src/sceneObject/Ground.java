package sceneObject;

import java.util.ArrayList;

import character.Character;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Ground extends SolidObject {
	
	public Ground(double width, double height, double x, double y) {
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
	public void onCollide(SolidObject target) {
		if (target instanceof Character) {
			Character targetCharacter = (Character)target;
			
			double x1 = getX();
			double x2 = getX() + getWidth();
			double tx1 = target.getX();
			double tx2 = target.getX() + target.getWidth();
			
			double y1 = getY();
			double y2 = getY() + getHeight();
			double ty1 = target.getY();
			double ty2 = target.getY() + target.getHeight();
			
			double deltaX = calculateDelta(x1, x2, tx1, tx2);
			double deltaY = calculateDelta(y1, y2, ty1, ty2);
			
			if (targetCharacter.getSpeed_y() > 0.0) {
				if (deltaX > 10.0) {
					double bottom_y = targetCharacter.getY() + targetCharacter.getHeight() + targetCharacter.getSpeed_y();
					if (bottom_y >= this.getY() && bottom_y <= this.getY() + this.getHeight()) {
						targetCharacter.setSpeed_y(0);
						targetCharacter.setY(getY() - targetCharacter.getHeight());
						targetCharacter.setOnGround(true);
					}
				}
			}
			
			if (deltaY > 3.0) {
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
	}
	
}
