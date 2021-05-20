package sceneObject;

import constants.GameConstant;
import gui.MainMenuGUI;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class MainMenuScene extends Scene{
	private StackPane stackPane;

	public MainMenuScene(Parent arg0) {
		super(arg0);
	}
	
	public MainMenuScene() {
		this(new StackPane());
		this.initialize();
	}
	
	private void initialize() {
		this.setRoot(this.stackPane = new StackPane());
		this.stackPane.setPrefSize(GameConstant.WINDOW_WIDTH, GameConstant.WINDOW_HEIGHT);
		this.stackPane.getChildren().add(new MainMenuGUI());
	}
}
