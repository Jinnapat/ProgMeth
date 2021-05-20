import javafx.application.Application;
import javafx.stage.Stage;
import sceneObject.MainMenuScene;

public class test extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MainMenuScene scene = new MainMenuScene();
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("This is Title");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
