package sceneObject;

import java.util.HashMap;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class GameScene {
	public static HashMap<KeyCode, Boolean> keyPressed = new HashMap();
	public static AnchorPane root = new AnchorPane();
	public static Scene scene = new Scene(root, 1200, 800);
	public static double gravity_g = 0.3;
	
	public GameScene() {};
	
	public static void start() {
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				KeyCode k = arg0.getCode();
				if (keyPressed.containsKey(k)) {
					if (!keyPressed.get(k)) {
						keyPressed.replace(k, true);
					}
				} else {
					keyPressed.put(k, true);
				}
			}
			
		});
		
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				KeyCode k = arg0.getCode();
				if (keyPressed.containsKey(k)) {
					keyPressed.replace(k, false);
				}
			}
			
		});
	}

}
