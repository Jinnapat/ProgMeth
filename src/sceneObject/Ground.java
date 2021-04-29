package sceneObject;

import interfaces.Collidable;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Ground extends SolidObject {
	private HBox groundBox;
	private double x;
	private double y;
	
	public Ground(double width, double height, double x, double y, Color color) {
		super(width, height, x, y);
		groundBox = new HBox();
		groundBox.setPrefWidth(width);
		groundBox.setPrefHeight(height);
		groundBox.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
		setX(x);
		setY(y);
		AnchorPane.setTopAnchor(groundBox, getY());
		AnchorPane.setLeftAnchor(groundBox, getX());
	}

	public HBox getGroundBox() {
		return groundBox;
	}

	public void setGroundBox(HBox groundBox) {
		this.groundBox = groundBox;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public void checkCollide() {
		
	}

	@Override
	public void onCollide(SolidObject target) {
		// TODO Auto-generated method stub
		
	}
	
	
}
