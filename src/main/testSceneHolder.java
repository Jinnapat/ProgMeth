package main;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.SceneHolder;

public class testSceneHolder extends Application{
	
	public static SceneHolder sceneHolder;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		sceneHolder = new SceneHolder(primaryStage);
		sceneHolder.initialize();
		
		primaryStage.setTitle("testSceneHolder");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
