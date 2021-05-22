package systemMemory;

import gui.GameCanvas;

public class Memory {
	public static Memory instance = new Memory();
	public GameCanvas gameCanvas;
	
	public Memory() {}
	
	public static Memory getInstance() {
		return instance;
	}
}
