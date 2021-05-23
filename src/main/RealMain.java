package main;
import constants.ImageHolder;
import javafx.application.Application;
import javafx.stage.Stage;
import logic.SceneHolder;

public class RealMain extends Application{
	

	@Override
	public void start(Stage stage) throws Exception {
		
		SceneHolder sceneHolder = new SceneHolder(stage);
		sceneHolder.initialize();
		
		stage.setTitle("Main");
		stage.getIcons().add(ImageHolder.getInstance().charecterBlack.get(0));
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
	
