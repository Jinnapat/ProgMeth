package main;
import constants.GameConstant;
import gui.GameCanvas;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.SceneHolder;
import scene.GameScene;

public class RealMain extends Application{
	

	@Override
	public void start(Stage stage) throws Exception {
		
		SceneHolder sceneHolder = new SceneHolder(stage);
		sceneHolder.initialize();
		
		stage.setTitle("Main");
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
	
