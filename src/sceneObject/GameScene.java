package sceneObject;

import java.util.ArrayList;

import constants.GameConstant;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class GameScene {
	public static ArrayList<KeyCode> keyPressed = new ArrayList<KeyCode>();
	public static AnchorPane root = new AnchorPane();
	public static Scene scene = new Scene(root, GameConstant.WINDOW_WIDTH, GameConstant.WINDOW_HEIGHT);
	public static ArrayList<SolidObject> solidObjects = new ArrayList<SolidObject>();
	
	public GameScene() {};
	
	public static void start() {
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				KeyCode k = arg0.getCode();
				if (!(keyPressed.contains(k))) {
					keyPressed.add(k);
				}
			}
			
		});
		
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				KeyCode k = arg0.getCode();
				keyPressed.remove(k);
			}
			
		});
	}

}
