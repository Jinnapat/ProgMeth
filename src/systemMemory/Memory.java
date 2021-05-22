package systemMemory;

import gui.GameCanvas;
import scene.GameScene;
import scene.MainMenuScene;
import scene.SelectionScene;
import character.Character;

public class Memory {
	public static Memory instance = new Memory();
	public MainMenuScene mainMeneScene;
	public GameCanvas gameCanvas;
	public GameScene gameScene;
	public SelectionScene selectionScene;
	
	public Memory() {}
	
	public static Memory getInstance() {
		return instance;
	}
}
