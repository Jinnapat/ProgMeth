package systemMemory;

import gui.GameCanvas;
import gui.MainMenuGUI;
import gui.SelectionGUI;
import scene.EndGameScene;
import scene.GameScene;
import scene.MainMenuScene;
import scene.SelectionScene;

public class Memory {
	public static Memory instance = new Memory();
	public MainMenuScene mainMeneScene;
	public GameCanvas gameCanvas;
	public MainMenuGUI mainMenuGui;
	public SelectionGUI selectionGui;
	public GameScene gameScene;
	public SelectionScene selectionScene;
	public EndGameScene endGameScene;

	public Memory() {
	}

	public static Memory getInstance() {
		return instance;
	}
}
