package scene;

import constants.GameConstant;
import gui.EndGameGUI;
import gui.SelectionGUI;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import systemMemory.Memory;

public class EndGameScene extends Scene{
	private StackPane stackPane;

	public EndGameScene(Parent arg0) {
		super(arg0);
	}
	
	public EndGameScene() {
		this(new StackPane());
		this.initialize();
		Memory.getInstance().endGameScene = this;
	}
	
	private void initialize() {
		this.setRoot(this.stackPane = new StackPane());
		this.stackPane.setPrefSize(GameConstant.WINDOW_WIDTH, GameConstant.WINDOW_HEIGHT);
		this.stackPane.getChildren().add(new EndGameGUI());
	}
}
