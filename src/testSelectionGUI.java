import javafx.application.Application;
import javafx.stage.Stage;
import sceneObject.MainMenuScene;
import sceneObject.SelectionScene;

public class testSelectionGUI extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		SelectionScene scene = new SelectionScene();
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("This is Selection");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
