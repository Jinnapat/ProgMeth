import javafx.application.Application;
import javafx.stage.Stage;
import sceneObject.MainMenuScene;
import sceneObject.OptionScene;

public class test2 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		OptionScene scene = new OptionScene();
		primaryStage.setScene(scene);
		primaryStage.setTitle("This is Option");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
