import constants.GameConstant;
import gui.GameCanvas;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class test4 extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				KeyCode k = arg0.getCode();
				if (!(GameConstant.keyPressed.contains(k))) {
					GameConstant.keyPressed.add(k);
				}
			}
			
		});
		
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				KeyCode k = arg0.getCode();
				GameConstant.keyPressed.remove(k);
			}
			
		});
		
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
