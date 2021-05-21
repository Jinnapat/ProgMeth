package logic;

import javafx.application.Application;
import main.test4;

public class SystemLogic {
	
	public static void startGame() {
		Thread thread = new Thread(() -> {
			Application.launch(test4.class);
		});
		thread.start();
	}
}
