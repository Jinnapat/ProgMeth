package gui;

import character.Scout;
import interfaces.Movable;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import logic.RenderableHolder;
import sceneObject.Ground;
import sceneObject.SolidObject;
import item.derived.Bandage;
import item.derived.DropBox;

public class GameCanvas extends Canvas{
	
	private GraphicsContext gc;
	private AnimationTimer gameLoop;
	
	public GameCanvas() {
		this.setup();
		this.loop();

	}
	
	private void setup() {
		this.gc = this.getGraphicsContext2D();
//		this.gameObjects = new ArrayList<SolidObject>();
		this.setWidth(600);
		this.setHeight(400);
		
//		Ground g1 = new Ground(50, 50, 50, 50, false);
//		Ground g2 = new Ground(50, 50, 50, 100, false);
		Ground g3 = new Ground(600, 50, 0, 300, false);
		
		Scout myChar = new Scout();
		myChar.setX(100.0);
		myChar.setY(50.0);
		myChar.setCheckControls(true);
		myChar.setName("Player 1");
		myChar.setFallable(true);
		
		DropBox db = new DropBox();
		db.setFallable(true);
		
		Bandage bd = new Bandage();
		bd.setX(100);
		bd.setFallable(true);
	}
	
	private void loop() {
		this.gameLoop = new AnimationTimer() {

			@Override
			public void handle(long now) {
				GameCanvas.this.clearScreen();
				GameCanvas.this.update();
				GameCanvas.this.draw();
			}
			
		};
		this.gameLoop.start();
	}
	
	public void clearScreen() {
        this.gc.clearRect(0.0D, 0.0D, 800, 600);
    }
	
	private void update() {
		if(RenderableHolder.getInstance().getGameObjects()!=null) {
			for(SolidObject obj: RenderableHolder.getInstance().getGameObjects()) {
				if(obj instanceof Movable) {
					((Movable) obj).update();
				}
			}
		}
	}
	
	private void draw() {
		if(RenderableHolder.getInstance().getGameObjects()!=null) {
			for(SolidObject obj: RenderableHolder.getInstance().getGameObjects()) {
				obj.draw(gc);
			}
		}
	}
}
