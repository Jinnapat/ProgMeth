package main;
import constants.SoundHolder;
import javafx.application.Application;
import javafx.stage.Stage;
import logic.SceneHolder;

public class RealMain extends Application{
	

	@Override
	public void start(Stage stage) throws Exception {
		
		SceneHolder sceneHolder = new SceneHolder(stage);
		sceneHolder.initialize();
		SoundHolder.getInstance().bgmPlayer.play();
		stage.setTitle("Main");
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
	
