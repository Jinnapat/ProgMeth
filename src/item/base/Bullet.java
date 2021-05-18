package item.base;

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
	private double maxRange;
	private boolean isLeftSide;
	private long lastTimeTriggered;
	private AnimationTimer animationTimer;
	
	public Bullet() {
		super(5.0, 3.0, 0.0, 0.0);
		this.maxRange = 500;
		this.speed = 5;
		this.isLeftSide = false;
		getBoundBox().setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public Bullet(double width, double height, double x, double y) {
		super(width, height, x, y);
		this.maxRange = 500;
		this.speed = 5;
		this.isLeftSide = false;
		getBoundBox().setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void shoot(double x, double y, boolean isLeftSide) {
		System.out.println("Bang!");
		// TODO
		setLeftSide(isLeftSide);
		setX(x);
		setY(y);
		GameScene.root.getChildren().add(getBoundBox());
		AnchorPane.setLeftAnchor(getBoundBox(), x);
		AnchorPane.setTopAnchor(getBoundBox(), y);
		
		this.animationTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 10000000) {
					
					if (maxRange <= 0.0) {
						GameScene.root.getChildren().remove(getBoundBox());
						animationTimer.stop();
					}
					
					if (isLeftSide()) {
						setX(getX() - getSpeed());
					} else {
						setX(getX() + getSpeed());
					}
					
					maxRange -= getSpeed();
					AnchorPane.setLeftAnchor(getBoundBox(), getX());
					lastTimeTriggered = now;
				}
			}
		};
		
		this.animationTimer.start();
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	
	public boolean isLeftSide() {
		return isLeftSide;
	}

	public void setLeftSide(boolean isLeftSide) {
		this.isLeftSide = isLeftSide;
	}

	@Override
	public void onCollide(SolidObject target) {
		// TODO Auto-generated method stub
		
	}
	
}
