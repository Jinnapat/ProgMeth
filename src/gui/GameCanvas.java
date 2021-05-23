package gui;

import java.util.ArrayList;
import java.util.List;

import character.Character;
import constants.FontHolder;
import constants.GameConstant;
import constants.ImageHolder;
import constants.SoundHolder;
import exception.PositionException;
import interfaces.Movable;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import logic.GameLogic;
import logic.RenderableHolder;
import logic.SceneHolder;
import sceneObject.Ground;
import sceneObject.SolidObject;
import systemMemory.Memory;
import item.derived.AmmoStash;
import item.derived.Bandage;
import item.derived.DropBox;

public class GameCanvas extends Canvas{
	
	private GraphicsContext gc;
	private AnimationTimer gameLoop;
	private List<SolidObject> gameObjects;
	private double lastTimeTriggered;
	private Image backgroundImage;
	
	public GameCanvas() {
		super();
		this.gc = this.getGraphicsContext2D();
		this.backgroundImage = ImageHolder.getInstance().gameBackgound;
		this.lastTimeTriggered = 0.0;
		this.setWidth(GameConstant.WINDOW_WIDTH);
		this.setHeight(GameConstant.WINDOW_HEIGHT);
		this.loadResource();
		Memory.getInstance().gameCanvas = this;
		this.setup();
		this.loop();
	}
	
	public void setup() {
		RenderableHolder.getInstance().getWillAddObjects().clear();
		gameObjects = (ArrayList<SolidObject>) RenderableHolder.getInstance().getGameObjects();
		gameObjects.clear();
		GameConstant.keyPressed.clear();
		
		this.setUpPlayer1();
		this.setUpPlayer2();
		this.createSceneObjects();
	}
	
	private void setUpPlayer1() {
		Character myChar = Memory.getInstance().selectionGui.getSelectCharacterBox().getCharacter();
		gameObjects.add(myChar);
		gameObjects.add(myChar.getWeapon());
		myChar.setX(100.0);
		myChar.setY(500.0);
		myChar.setCheckControls(true);
	}
	
	private void setUpPlayer2() {
		Character myChar2 = Memory.getInstance().selectionGui.getSelectCharacterBox2().getCharacter();
		gameObjects.add(myChar2);
		gameObjects.add(myChar2.getWeapon());
		myChar2.setX(1050.0);
		myChar2.setY(500.0);
		myChar2.setHeadLeft(true);
		myChar2.getControlKeys().put("leftKey", KeyCode.LEFT);
		myChar2.getControlKeys().put("rightKey", KeyCode.RIGHT);
		myChar2.getControlKeys().put("jumpKey", KeyCode.UP);
		myChar2.getControlKeys().put("shootKey", KeyCode.ENTER);
		myChar2.setCheckControls(true);
	}

	private void createSceneObjects() {
		this.createGrounds();
		this.createHouse();
		this.createVerticalPlatforms();
		this.createUtilities();
	}
	
	private void createGrounds() {
		//Ground
		new Ground(1100, 50, 50, 750, false);
		new Ground(50, 50, 450, 700, false);
		new Ground(50, 50, 700, 700, false);
		
	}
	
	private void createHouse() {
		// wall
		new Ground(50, 50, 300, 520, false);
		new Ground(50, 50, 850, 520, false);
		new Ground(50, 50, 300, 570, false);
		new Ground(50, 50, 850, 570, false);
		new Ground(50, 50, 300, 620, false);
		new Ground(50, 50, 850, 620, false);
		
		// roof
		new Ground(100, 50, 300, 470, true);
		new Ground(240, 50, 480, 470, true);
		new Ground(100, 50, 800, 470, true);
	}
	
	private void createVerticalPlatforms() {
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
	}
	
	private void createUtilities() {
		new Bandage(30.0, 30.0, 585.0, 400.0);
		new Bandage(30.0, 30.0, 585.0, 700.0);
		
		new AmmoStash(30.0, 30.0, 50.0, 50.0);
		new AmmoStash(30.0, 30.0, 1120.0, 50.0);
		
		new DropBox(30.0, 30.0, 50.0, 700.0);
		new DropBox(30.0, 30.0, 1120.0, 700.0);
	}
	
	public void loop() {
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
	}
	
	public void clearScreen() {
        this.gc.clearRect(0.0D, 0.0D, GameConstant.WINDOW_WIDTH, GameConstant.WINDOW_HEIGHT);
        this.gc.drawImage(backgroundImage, 0.0, 0.0);
        if(GameLogic.isEndGame()) {
        	Memory.getInstance().selectionGui.reset();
        	this.gameLoop.stop();
			SceneHolder.switchScene(Memory.getInstance().endGameScene);
		}
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
			SolidObject t = garbage.get(i);
			gameObjects.remove(t);
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
					} catch(PositionException e){
						System.out.println("Position is not valid");
					}
				}
			}
		}
	}
	
	private void draw() {
		if(RenderableHolder.getInstance().getGameObjects()!=null) {
			for(SolidObject obj: RenderableHolder.getInstance().getGameObjects()) {
				obj.draw(this.gc);
			}
		}
	}
	
	private void loadResource() {
		new RenderableHolder();
		new ImageHolder();
		new SoundHolder();
		new FontHolder();
	}

	public AnimationTimer getGameLoop() {
		return gameLoop;
	}
	
	
}
