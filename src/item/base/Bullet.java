package item.base;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import logic.DamageLogic;
import sceneObject.GameScene;
import sceneObject.Ground;
import sceneObject.SolidObject;
import character.Character;

public class Bullet extends SolidObject {
	private double speed;
	private int damage;
	private double maxRange;
	private boolean isLeftSide;
	private boolean isHit;
	private long lastTimeTriggered;
	private AnimationTimer animationTimer;
	
	public Bullet() {
		super(5.0, 3.0);
		this.maxRange = 500;
		this.damage = 1;
		this.speed = 30;
		this.isLeftSide = false;
		this.isHit = false;
		getBoundBox().setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public Bullet(double width, double height, double x, double y) {
		this();
		this.setWidth(width);
		this.setHeight(height);
		this.setX(x);
		this.setY(y);
	}
	
	public Bullet(int damage, double speed) {
		this();
		this.setDamage(damage);
		this.setSpeed(speed);
	}

	public Bullet(double width, double height, double x, double y, int damage, double speed) {
		this(width, height, x, y);
		this.setDamage(damage);
		this.setSpeed(speed);
	}

	public void shoot(double x, double y, boolean isLeftSide) {
		System.out.println("Bang!");
		// TODO
		setLeftSide(isLeftSide);
		setX(x);
		setY(y);
		GameScene.solidObjects.add(this);
		GameScene.root.getChildren().add(getBoundBox());
		AnchorPane.setLeftAnchor(getBoundBox(), x);
		AnchorPane.setTopAnchor(getBoundBox(), y);
		checkCollide();
		Bullet self = this;

		this.animationTimer = new AnimationTimer() {

			@Override
			public void handle(long now) {

				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);

				if (now - lastTimeTriggered >= 10000000) {

					if (maxRange <= 0.0) {
						GameScene.root.getChildren().remove(getBoundBox());
						GameScene.solidObjects.remove(self);
						stopCheckCollide();
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

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = Math.max(damage, 0);
	}
	

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

	@Override
	public void onCollide(SolidObject target) {
		if (target instanceof Character) {
			Character targetCharacter = (Character)target;
			if (targetCharacter.getHealth() > 0) {
				DamageLogic.calculateDamage(this, targetCharacter);
			}
			GameScene.solidObjects.remove(this);
			GameScene.root.getChildren().remove(this.getBoundBox());
			this.setHit(true);
		} else if (target instanceof Ground) {
			GameScene.solidObjects.remove(this);
			GameScene.root.getChildren().remove(this.getBoundBox());
			this.setHit(true);
		}
	}
}
