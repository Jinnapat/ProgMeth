package sceneObject;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;

public abstract class SolidObject {
	private AnchorPane boundBox;
	private double width;
	private double height;
	private double x;
	private double y;
	private double speed_x;
	private double speed_y;
	private double friction;
	
	private ArrayList<SolidObject> collideList;
	private long lastTimeTriggered;
	
	public SolidObject(double width, double height) {
		super();
		this.width = width;
		this.height = height;
		this.x = 0.0;
		this.y = 0.0;
		this.speed_x = 0.0;
		this.speed_y = 0.0;
		this.collideList = new ArrayList<SolidObject>();
		this.friction = 0.8;
		
		this.boundBox = new AnchorPane();
		this.boundBox.setPrefSize(getWidth(), getHeight());
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
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

	
	public AnchorPane getBoundBox() {
		return boundBox;
	}

	public void setBoundBox(AnchorPane boundBox) {
		this.boundBox = boundBox;
	}

	
	public double getSpeed_x() {
		return speed_x;
	}

	public void setSpeed_x(double speed_x) {
		this.speed_x = speed_x;
	}

	public double getSpeed_y() {
		return speed_y;
	}

	public void setSpeed_y(double speed_y) {
		this.speed_y = speed_y;
	}

	
	public double getFriction() {
		return friction;
	}

	public void setFriction(double friction) {
		this.friction = friction;
	}

	public void addCollidableObject(SolidObject target) {
		this.collideList.add(target);
	}
	
	public void addAllCollidableObject(ArrayList<SolidObject> targetList) {
		for (int i = 0; i < targetList.size(); i++) {
			this.addCollidableObject(targetList.get(i));
		}
	}
	
	public void checkCollide() {
		AnimationTimer animationTimer = new AnimationTimer() {
				
			@Override
			public void handle(long now) {
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 10000000) {
					

					setSpeed_x(getSpeed_x() * getFriction());
					setSpeed_y(getSpeed_y() + GameScene.gravity_g);
					
					
					for (int i = 0; i < collideList.size(); i++) {
						SolidObject target = collideList.get(i);
						
						boolean x_collide = false;
						boolean y_collide = false;
						boolean collided = false;
						
						double targetX1 = target.getX();
						double targetX2 = targetX1 + target.getWidth();
						double targetY1 = target.getY();
						double targetY2 = targetY1 + target.getHeight();

						double x1 = getX();
						double x2 = x1 + getWidth();
						double y1 = getY();
						double y2 = y1 + getHeight();
						
						if (x1 <= targetX2 &&  x1 >= targetX1) {
							x_collide = true;
						} else if (x2 <= targetX2 &&  x2 >= targetX1) {
							x_collide = true;
						}
							
						if ((y1 <= targetY2 &&  y1 >= targetY1)) {
							y_collide = true;
						} else if ((y2 <= targetY2 &&  y2 >= targetY1)) {
							y_collide = true;
						}
						
						if (targetX1 < x2 &&  targetX1 >= x1) {
							x_collide = true;
						} else if (targetX2 <= x2 &&  targetX2 >= x1) {
							x_collide = true;
						}
						
						if ((targetY1 <= y2 &&  targetY1 >= y1)) {
							y_collide = true;
						} else if ((targetY2 <= y2 &&  targetY2 >= y1)) {
							y_collide = true;
						}
						
						collided = x_collide && y_collide;
						
						if (collided) {
							onCollide(target);
						}
						
					}
					
					setX(getX() + getSpeed_x());
					setY(getY() + getSpeed_y());
					AnchorPane.setLeftAnchor(boundBox, getX());
					AnchorPane.setTopAnchor(boundBox, getY());
				}
			};
		};
		animationTimer.start();
	}
	
	public abstract void onCollide(SolidObject target);
}
