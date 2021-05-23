package scene;

import constants.GameConstant;
import gui.GameCanvas;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import systemMemory.Memory;

public class GameScene extends Scene{
	private StackPane stackPane;

	public GameScene(Parent arg0) {
		super(arg0);
	}
	
	public GameScene() {
		this(new StackPane());
		this.initialize();
		Memory.getInstance().gameScene = this;
	}
	
	private void initialize() {
		this.setRoot(this.stackPane = new StackPane());
		this.stackPane.setPrefSize(GameConstant.WINDOW_WIDTH, GameConstant.WINDOW_HEIGHT);
		this.stackPane.getChildren().add(new GameCanvas());
		this.addKeyEvents();
	}
	
	private void addKeyEvents() {
		this.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				KeyCode k = arg0.getCode();
				if (!(GameConstant.keyPressed.contains(k))) {
					GameConstant.keyPressed.add(k);
				}
			}
		});
		
		this.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				KeyCode k = arg0.getCode();
				GameConstant.keyPressed.remove(k);
			}
		});
	}
}
