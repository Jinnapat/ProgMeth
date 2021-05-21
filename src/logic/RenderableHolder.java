package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import gui.GameCanvas;
import sceneObject.SolidObject;

public class RenderableHolder {
	private List<SolidObject> gameObjects;
	private Comparator<SolidObject> comparator;
	private static final RenderableHolder instance = new RenderableHolder();
	
	
	
	public RenderableHolder() {
		this.gameObjects = new ArrayList<SolidObject>();
		comparator = (SolidObject o1, SolidObject o2) -> {
			if(o1.getZ() > o2.getZ()) {
				return 1;
			}
			return -1;
		};
		System.out.println("RenderableHolder");
	}



	public void addObject(SolidObject obj) {
		gameObjects.add(obj);
		Collections.sort(this.gameObjects, comparator);
	}
	
	public static RenderableHolder getInstance() {
		return instance;
	}


	public List<SolidObject> getGameObjects() {
		return gameObjects;
	}



	public void setGameObjects(List<SolidObject> gameObjects) {
		this.gameObjects = gameObjects;
	}
	
	
}
