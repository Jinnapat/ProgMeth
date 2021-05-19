package gui;

import constants.GameConstant;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class OptionScene extends Scene{
	private StackPane stackPane;

	public OptionScene(Parent arg0) {
		super(arg0);
	}
	
	public OptionScene() {
		this(new StackPane());
		this.initialize();
	}
	
	private void initialize() {
		this.setRoot(this.stackPane = new StackPane());
		this.stackPane.setPrefSize(GameConstant.WINDOW_WIDTH, GameConstant.WINDOW_HEIGHT);
		this.stackPane.getChildren().add(new OptionGUI());
	}
}
