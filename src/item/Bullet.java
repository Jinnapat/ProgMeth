package item;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import sceneObject.GameScene;
import sceneObject.SolidObject;

public class Bullet extends SolidObject{
	private double speed;
	private long lastTimeTriggered;
	
	public Bullet(double width, double height, double x, double y) {
		super(width, height, x, y);
		this.speed = 10;
		getBoundBox().setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void shoot() {
		System.out.println("Bang!");
		// TODO

	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public void onCollide(SolidObject target) {
		// TODO Auto-generated method stub
		
	}
	
}
