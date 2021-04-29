package sceneObject;

import java.util.HashMap;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class GameScene {
	public static HashMap<String, Boolean> keyPressed = new HashMap();
	public static AnchorPane root = new AnchorPane();
	public static Scene scene = new Scene(root, 1200, 800);
	public static double gravity_g = 5;
	
	public GameScene() {};
	
	public static void start() {
		keyPressed.put("a", false);
		keyPressed.put("s", false);
		keyPressed.put("d", false);
		keyPressed.put("w", false);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				String k = arg0.getText();
				if (!keyPressed.get(k)) {
					keyPressed.replace(k, true);
					System.out.println(keyPressed);
				}
			}
			
		});
		
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				String k = arg0.getText();
				keyPressed.replace(k, false);
				System.out.println(keyPressed);
			}
			
		});
	}

}
