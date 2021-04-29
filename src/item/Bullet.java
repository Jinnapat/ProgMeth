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
		AnimationTimer animationTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 10000000) {
					
					setX(getX() + speed);
					AnchorPane.setTopAnchor(getBoundBox(), getY());
					AnchorPane.setLeftAnchor(getBoundBox(), getX());
					lastTimeTriggered = now;
				}
			}
		};
		
		animationTimer.start();
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
