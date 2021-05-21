package sceneObject;

import constants.GameConstant;
import gui.SelectionGUI;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class SelectionScene extends Scene{
	private StackPane stackPane;

	public SelectionScene(Parent arg0) {
		super(arg0);
	}
	
	public SelectionScene() {
		this(new StackPane());
		this.initialize();
	}
	
	private void initialize() {
		this.setRoot(this.stackPane = new StackPane());
		this.stackPane.setPrefSize(GameConstant.WINDOW_WIDTH, GameConstant.WINDOW_HEIGHT);
		this.stackPane.getChildren().add(new SelectionGUI());
	}
}
