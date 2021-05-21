package gui;

import java.util.List;

import character.Heavy;
import character.Scout;
import constants.GameConstant;
import interfaces.Movable;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import logic.RenderableHolder;
import sceneObject.Ground;
import sceneObject.SolidObject;
import item.derived.Bandage;
import item.derived.DropBox;

public class GameCanvas extends Canvas{
	
	private GraphicsContext gc;
	private AnimationTimer gameLoop;
	private double lastTimeTriggered;
	private Image backgroundImage;
	
	public GameCanvas() {
		this.backgroundImage = new Image(ClassLoader.getSystemResource("images/background.png").toString(), GameConstant.WINDOW_WIDTH, GameConstant.WINDOW_HEIGHT, true, false);
		this.lastTimeTriggered = 0.0;
		this.setup();
		this.loop();

	}
	
	private void setup() {
		this.gc = this.getGraphicsContext2D();
//		this.gameObjects = new ArrayList<SolidObject>();
		this.setWidth(GameConstant.WINDOW_WIDTH);
		this.setHeight(GameConstant.WINDOW_HEIGHT);
		
		Heavy myChar = new Heavy();
		myChar.setX(100.0);
		myChar.setY(500.0);
		myChar.setCheckControls(true);
		myChar.setName("Player 1");
		myChar.setFallable(true);
		
		Scout myChar2 = new Scout();
		myChar2.setHealth(100);
		myChar2.setX(1050.0);
		myChar2.setY(500.0);
		myChar2.getControlKeys().put("leftKey", KeyCode.LEFT);
		myChar2.getControlKeys().put("rightKey", KeyCode.RIGHT);
		myChar2.getControlKeys().put("jumpKey", KeyCode.UP);
		myChar2.getControlKeys().put("shootKey", KeyCode.ENTER);
		myChar2.setCheckControls(true);
		myChar2.setName("Player 2");
		myChar2.setFallable(true);
		
		//Ground
		new Ground(1100, 50, 50, 750, false);
		new Ground(50, 50, 450, 700, false);
		new Ground(50, 50, 700, 700, false);
		
		// wall
		new Ground(50, 50, 300, 520, false);
		new Ground(50, 50, 850, 520, false);
		new Ground(50, 50, 300, 570, false);
		new Ground(50, 50, 850, 570, false);
		new Ground(50, 50, 300, 620, false);
		new Ground(50, 50, 850, 620, false);
		
		// roof
		new Ground(100, 20, 300, 500, true);
		new Ground(240, 20, 480, 500, true);
		new Ground(100, 20, 800, 500, true);
		
		// left platforms
		new Ground(100, 20, 50, 620, true);
		new Ground(50, 40, 150, 600, true);
		
		new Ground(100, 20, 50, 470, true);
		new Ground(50, 40, 150, 450, true);
		
		new Ground(100, 20, 50, 320, true);
		new Ground(50, 40, 150, 300, true);
		
		new Ground(100, 20, 50, 170, true);
		new Ground(50, 40, 150, 150, true);
		
		//right platforms
		new Ground(100, 20, 1050, 620, true);
		new Ground(50, 40, 1000, 600, true);
		
		new Ground(100, 20, 1050, 470, true);
		new Ground(50, 40, 1000, 450, true);
		
		new Ground(100, 20, 1050, 320, true);
		new Ground(50, 40, 1000, 300, true);
		
		new Ground(100, 20, 1050, 170, true);
		new Ground(50, 40, 1000, 150, true);
		
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
					List<SolidObject> garbage = RenderableHolder.getInstance().getGarbage();
					
					for (int i = 0; i < gameOjects.size(); i++) {
						SolidObject target = gameOjects.get(i);
						target.checkCollide();
						target.setX(target.getX() + target.getSpeed_x());
						target.setY(target.getY() + target.getSpeed_y());
					}
					
					for (int i = 0; i < garbage.size(); i++) {
						gameOjects.remove(garbage.get(i));
					}
					RenderableHolder.getInstance().clearGarbage();
					GameCanvas.this.draw();
					lastTimeTriggered = now;
				}
			}
			
		};
		this.gameLoop.start();
	}
	
	public void clearScreen() {
        this.gc.clearRect(0.0D, 0.0D, GameConstant.WINDOW_WIDTH, GameConstant.WINDOW_HEIGHT);
        this.gc.drawImage(backgroundImage, 0.0, 0.0);
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
