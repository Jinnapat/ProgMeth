package systemMemory;

import gui.GameCanvas;
import gui.MainMenuGUI;
import gui.SelectionGUI;

public class Memory {
	public static Memory instance = new Memory();
	public GameCanvas gameCanvas;
	public MainMenuGUI mainMenuGui;
	public SelectionGUI selectionGui;
	
	public Memory() {}
	
	public static Memory getInstance() {
		return instance;
	}
}
