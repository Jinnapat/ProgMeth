package logic;

import javafx.scene.Scene;
import javafx.stage.Stage;
import scene.MainMenuScene;

public class SceneHolder {
	
	private static Stage pStage;
	public MainMenuScene mainMenuScene;
	
	public SceneHolder(Stage pStage) {
		this.pStage = pStage;
	}
	
	public void initialize() {
		this.mainMenuScene = new MainMenuScene();
		switchScene(this.mainMenuScene);
	}
	
	public static void switchScene(Scene targetScene) {
		pStage.setResizable(false);
		pStage.setScene(targetScene);
		pStage.sizeToScene();
	}
}
