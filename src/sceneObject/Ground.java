package sceneObject;

import java.util.ArrayList;

import character.Character;
import interfaces.Collidable;
import item.base.Utility;
import javafx.geometry.Insets;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import logic.ImageLogic;

public class Ground extends SolidObject{
	
	private boolean passable;

	public Ground(double width, double height, double x, double y, boolean passsable) {
		super(width, height);
		this.setX(x);
		this.setY(y);
		this.getBoundBox().setPrefWidth(width);
		this.getBoundBox().setPrefHeight(height);
		this.passable = passsable;
		
		Image image = new Image(ClassLoader.getSystemResource("images/Platform.png").toString());
		image = ImageLogic.resizeImage(image, width, height);
		this.setSprite(image);
		
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
			
			if (!passable) {
				if (targetCharacter.getSpeed_y() < 0.0) {
					if (deltaX > 10.0) {
						double top_y = targetCharacter.getY() + targetCharacter.getSpeed_y();
						if (top_y >= this.getY() && top_y <= this.getY() + this.getHeight()) {
							targetCharacter.setSpeed_y(0);
							targetCharacter.setY(getY() + getHeight());
						}
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
		} else if(target instanceof Utility) {
			Utility targetUtility = (Utility) target;
			double bottom_y = targetUtility.getY() + targetUtility.getHeight();
			if (bottom_y >= this.getY() && bottom_y <= this.getY() + this.getHeight()) {
				
				if (targetUtility.getSpeed_y() > 0) {
					targetUtility.setSpeed_y(0.0);
					targetUtility.setY(this.getY() - targetUtility.getHeight());
				}
				
				
			}
			System.out.println("yPos: "+targetUtility.getY());

		}
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		int tileNumber = (int) (this.getWidth() / 50);
		double blockWidth = this.getWidth() / tileNumber;
		for (int i = 0; i < tileNumber; i++) {
//			System.out.println(blockWidth);	
			gc.drawImage(this.getSprite(), this.getX() + i*blockWidth, this.getY(), blockWidth, this.getHeight());
		}
	}

	@Override
	public boolean isDestroy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onCollide(Collidable target) {
		// TODO Auto-generated method stub
		if (target instanceof Character) {
			Character targetCharacter = (Character)target;
			
			double x1 = getX();
			double x2 = getX() + getWidth();
			double tx1 = targetCharacter.getX();
			double tx2 = targetCharacter.getX() + targetCharacter.getWidth();
			
			double y1 = getY();
			double y2 = getY() + getHeight();
			double ty1 = targetCharacter.getY();
			double ty2 = targetCharacter.getY() + targetCharacter.getHeight();
			
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
			
			if (!passable) {
				if (targetCharacter.getSpeed_y() < 0.0) {
					if (deltaX > 10.0) {
						double top_y = targetCharacter.getY() + targetCharacter.getSpeed_y();
						if (top_y >= this.getY() && top_y <= this.getY() + this.getHeight()) {
							targetCharacter.setSpeed_y(0);
							targetCharacter.setY(getY() + getHeight());
						}
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
		} else if(target instanceof Utility) {
			Utility targetUtility = (Utility) target;
			double bottom_y = targetUtility.getY() + targetUtility.getHeight();
			if (bottom_y >= this.getY() && bottom_y <= this.getY() + this.getHeight()) {
				
				if (targetUtility.getSpeed_y() > 0) {
					targetUtility.setSpeed_y(0.0);
					targetUtility.setY(this.getY() - targetUtility.getHeight());
				}
				
				
			}
			System.out.println("yPos: "+targetUtility.getY());

		}
	}
	
}
