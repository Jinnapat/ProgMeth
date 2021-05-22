package systemMemory;

import gui.GameCanvas;
import scene.GameScene;
import scene.MainMenuScene;

public class Memory {
	public static Memory instance = new Memory();
	public MainMenuScene mainMeneScene;
	public GameCanvas gameCanvas;
	public GameScene gameScene;
	
	public Memory() {}
	
	public static Memory getInstance() {
		return instance;
	}
}
