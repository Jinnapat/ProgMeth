package main;
import constants.ImageHolder;
import constants.SoundHolder;
import javafx.application.Application;
import javafx.stage.Stage;
import logic.SceneHolder;

public class Main extends Application{
	

	@Override
	public void start(Stage stage) throws Exception {
		setup(stage);
		stage.setTitle("Main");
		stage.setResizable(false);
		stage.getIcons().add(ImageHolder.getInstance().charecterBlack.get(0));
		stage.show();
	}
	
	public static void setup(Stage stage) {
		SceneHolder sceneHolder = new SceneHolder(stage);
		sceneHolder.initialize();
		SoundHolder.getInstance().bgmPlayer.play();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
	
