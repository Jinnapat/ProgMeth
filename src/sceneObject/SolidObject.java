package sceneObject;

import interfaces.Collidable;
import interfaces.IRenderable;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import logic.GameLogic;
import logic.RenderableHolder;
import java.util.List;

import constants.GameConstant;

public abstract class SolidObject implements IRenderable, Collidable{
	private double width;
	private double height;
	private double x;
	private double y;
	private double speed_x;
	private double speed_y;
	private double friction;
	private boolean fallable;
	private Image sprite;
	
	public SolidObject(double width, double height) {
		super();
		this.width = width;
		this.height = height;
		this.x = 0.0;
		this.y = 0.0;
		this.speed_x = 0.0;
		this.speed_y = 0.0;
		this.friction = 0.8;
		this.fallable = false;
		RenderableHolder.getInstance().addWillAddObject(this);
	}
	
	public SolidObject(double width, double height, double x, double y) {
		this(width, height);
		this.x = x;
		this.y = y;
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
		if (speed_y > GameConstant.MAX_SPEED_Y) {
			this.speed_y = GameConstant.MAX_SPEED_Y;
		} else {
			this.speed_y = speed_y;
		}
	}

	public double getFriction() {
		return friction;
	}

	public void setFriction(double friction) {
		this.friction = friction;
	}
	
	
	public boolean isFallable() {
		return fallable;
	}

	public void setFallable(boolean fallable) {
		this.fallable = fallable;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
	
	public void checkCollide() {
		List<SolidObject> gameOjects = RenderableHolder.getInstance().getGameObjects();
		
		for (int i = 0; i < gameOjects.size(); i++) {
			SolidObject target = gameOjects.get(i);
			
			if (GameLogic.willCollide(this, target)) {
				onCollide(target);
			}
		}

	}
}
