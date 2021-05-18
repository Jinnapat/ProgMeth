package sceneObject;

import javafx.geometry.Insets;
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
		this.getBoundBox().setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
		AnchorPane.setTopAnchor(this.getBoundBox(), getY());
		AnchorPane.setLeftAnchor(this.getBoundBox(), getX());
		GameScene.solidObjects.add(this);
		GameScene.root.getChildren().add(getBoundBox());
	}

	@Override
	public void onCollide(SolidObject target) {
		// TODO Auto-generated method stub
		
	}
	
}
