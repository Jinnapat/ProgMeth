import gui.GameCanvas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class test4 extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setTitle("Test4");
		GameCanvas gameCanvas = new GameCanvas();
		root.getChildren().add(gameCanvas);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
