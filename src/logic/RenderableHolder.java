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
	private List<SolidObject> garbage;
	private List<SolidObject> willAddObjects;
	
	public RenderableHolder() {
		this.gameObjects = new ArrayList<SolidObject>();
		this.garbage = new ArrayList<SolidObject>();
		this.willAddObjects = new ArrayList<SolidObject>();
		
		comparator = (SolidObject o1, SolidObject o2) -> {
			if(o1.getZ() > o2.getZ()) {
				return 1;
			}
			return -1;
		};
		System.out.println("RenderableHolder");
	}

	public void addWillAddObject(SolidObject obj) {
		this.willAddObjects.add(obj);
	}
	
	public void clearWillAdd() {
		this.willAddObjects.clear();
	}
	
	public void addGarbage(SolidObject obj) {
		this.garbage.add(obj);
	}

	public void clearGarbage() {
		this.garbage.clear();
	}
	
	public List<SolidObject> getGarbage() {
		return garbage;
	}

	public void addObject(SolidObject obj) {
		gameObjects.add(obj);
	}
	
	public static RenderableHolder getInstance() {
		return instance;
	}
	
	public void reRange() {
		Collections.sort(this.gameObjects, comparator);
	}

	public List<SolidObject> getGameObjects() {
		return gameObjects;
	}

	public void setGameObjects(List<SolidObject> gameObjects) {
		this.gameObjects = gameObjects;
	}

	public List<SolidObject> getWillAddObjects() {
		return willAddObjects;
	}
}
