package gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import character.Heavy;
import character.Scout;
import constants.FontHolder;
import constants.GameConstant;
import constants.ImageHolder;
import constants.SoundHolder;
import interfaces.Movable;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import logic.RenderableHolder;
import sceneObject.Ground;
import sceneObject.SolidObject;
import systemMemory.Memory;
import item.derived.AmmoStash;
import item.derived.Awp;
import item.derived.Bandage;
import item.derived.DropBox;

public class GameCanvas extends Canvas{
	
	private GraphicsContext gc;
	private AnimationTimer gameLoop;
	private List<SolidObject> gameObjects;
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
		gameObjects = (ArrayList<SolidObject>) RenderableHolder.getInstance().getGameObjects();
		this.setWidth(GameConstant.WINDOW_WIDTH);
		this.setHeight(GameConstant.WINDOW_HEIGHT);
		this.loadResource();
		Memory.getInstance().gameCanvas = this;
		
		Heavy myChar = new Heavy();
		myChar.setX(100.0);
		myChar.setY(500.0);
		myChar.setCheckControls(true);
		myChar.setName("Player 1");
		myChar.setFallable(true);
		
		Scout myChar2 = new Scout();
		myChar2.setX(1050.0);
		myChar2.setY(500.0);
		myChar2.setHeadLeft(true);
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
		
		new Bandage(30.0, 30.0, 585.0, 400.0);
		new Bandage(30.0, 30.0, 585.0, 700.0);
		
		new AmmoStash(30.0, 30.0, 50.0, 50.0);
		new AmmoStash(30.0, 30.0, 1120.0, 50.0);
		
		new DropBox(30.0, 30.0, 50.0, 700.0);
		new DropBox(30.0, 30.0, 1120.0, 700.0);
	}
	
	private void loop() {
		this.gameLoop = new AnimationTimer() {

			@Override
			public void handle(long now) {
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 10000000) {
					GameCanvas.this.clearScreen();
					GameCanvas.this.draw();
					GameCanvas.this.reRange();
					GameCanvas.this.update();
					
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
	
	private void reRange() {
		List<SolidObject> willAddObjects = RenderableHolder.getInstance().getWillAddObjects();
		List<SolidObject> garbage = RenderableHolder.getInstance().getGarbage();
		
		
		for (int i = 0; i < gameObjects.size(); i++) {
			SolidObject target = gameObjects.get(i);
			target.checkCollide();
			target.setX(target.getX() + target.getSpeed_x());
			target.setY(target.getY() + target.getSpeed_y());
		}
		
		for (int i = 0; i < willAddObjects.size(); i++) {
			gameObjects.add(willAddObjects.get(i));
		}
		RenderableHolder.getInstance().clearWillAdd();
		
		for (int i = 0; i < garbage.size(); i++) {
			gameObjects.remove(garbage.get(i));
		}

		RenderableHolder.getInstance().clearGarbage();
		RenderableHolder.getInstance().reRange();
	}

	private void update() {
		if(RenderableHolder.getInstance().getGameObjects()!=null) {
			for(SolidObject obj: RenderableHolder.getInstance().getGameObjects()) {
				if(obj instanceof Movable) {
					try {
						((Movable) obj).update();
					} catch(Exception e){
						
					}
				}
			}
		}
	}
	
	private void draw() {
		
		Iterator<SolidObject> point2 = this.gameObjects.iterator();
		
		while(point2.hasNext()) {
			SolidObject obj = (SolidObject) point2.next();
			obj.draw(gc);
		}
	}
	
	
	private void loadResource() {
		new RenderableHolder();
		new ImageHolder();
		new SoundHolder();
		new FontHolder();
	}
	
}
