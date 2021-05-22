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
import scene.GameScene;

public class test5 extends Application{

	@Override
	public void start(Stage stage) throws Exception {

		GameScene gs = new GameScene();
		
//		gs.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent arg0) {
//				KeyCode k = arg0.getCode();
//				if (!(GameConstant.keyPressed.contains(k))) {
//					GameConstant.keyPressed.add(k);
//				}
//			}
//			
//		});
//		
//		gs.setOnKeyReleased(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent arg0) {
//				KeyCode k = arg0.getCode();
//				GameConstant.keyPressed.remove(k);
//			}
//			
//		});
		
		stage.setTitle("Test 5");
		stage.setScene(gs);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
