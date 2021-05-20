package gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import logic.RenderableHolder;
import sceneObject.Ground;
import sceneObject.SolidObject;

public class GameCanvas extends Canvas{
	
	private GraphicsContext gc;
	
	public GameCanvas() {
		this.setup();
		this.loop();

	}
	
	private void setup() {
		this.gc = this.getGraphicsContext2D();
//		this.gameObjects = new ArrayList<SolidObject>();
		this.setWidth(600);
		this.setHeight(400);
		
//		Ground g1 = new Ground(500, 50, 0, 100, false);
		Ground g2 = new Ground(50, 50, 50, 100, false);
		Ground g3 = new Ground(50, 50, 100, 100, false);
		
	}
	
	private void loop() {
		this.update();
		this.draw();
	}
	
	private void update() {
		
	}
	
	private void draw() {
		if(RenderableHolder.getInstance().getGameObjects()!=null) {
			for(SolidObject obj: RenderableHolder.getInstance().getGameObjects()) {
				obj.draw(gc);
			}
		}
	}
}
