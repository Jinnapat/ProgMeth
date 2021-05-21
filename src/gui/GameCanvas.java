package gui;

import java.util.List;

import character.Scout;
import constants.GameConstant;
import interfaces.Movable;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import logic.GameLogic;
import logic.RenderableHolder;
import sceneObject.Ground;
import sceneObject.SolidObject;
import item.derived.Bandage;
import item.derived.DropBox;

public class GameCanvas extends Canvas{
	
	private GraphicsContext gc;
	private AnimationTimer gameLoop;
	private double lastTimeTriggered;
	
	public GameCanvas() {
		this.lastTimeTriggered = 0.0;
		this.setup();
		this.loop();

	}
	
	private void setup() {
		this.gc = this.getGraphicsContext2D();
//		this.gameObjects = new ArrayList<SolidObject>();
		this.setWidth(GameConstant.WINDOW_WIDTH);
		this.setHeight(GameConstant.WINDOW_HEIGHT);
		
//		Ground g1 = new Ground(50, 50, 50, 50, false);
		Ground g2 = new Ground(50, 50, 50, 100, false);
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
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				if (now - lastTimeTriggered >= 10000000) {
					GameCanvas.this.clearScreen();
					GameCanvas.this.update();
					
					List<SolidObject> gameOjects = RenderableHolder.getInstance().getGameObjects();
					
					for (int i = 0; i < gameOjects.size(); i++) {
						SolidObject target = gameOjects.get(i);
						target.checkCollide();
					}
					
					GameCanvas.this.draw();
					lastTimeTriggered = now;
				}
			}
			
		};
		this.gameLoop.start();
	}
	
	public void clearScreen() {
        this.gc.clearRect(0.0D, 0.0D, GameConstant.WINDOW_WIDTH, GameConstant.WINDOW_HEIGHT);
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
