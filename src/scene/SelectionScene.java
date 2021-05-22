package scene;

import constants.GameConstant;
import gui.SelectionGUI;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import systemMemory.Memory;

public class SelectionScene extends Scene{
	private StackPane stackPane;
	private SelectionGUI selectionGUI;
	
	public SelectionScene(Parent arg0) {
		super(arg0);
	}
	
	public SelectionScene() {
		this(new StackPane());
		this.initialize();
		Memory.getInstance().selectionScene = this;
	}
	
	private void initialize() {
		this.selectionGUI = new SelectionGUI();
		this.setRoot(this.stackPane = new StackPane());
		this.stackPane.setPrefSize(GameConstant.WINDOW_WIDTH, GameConstant.WINDOW_HEIGHT);
		this.stackPane.getChildren().add(this.selectionGUI);
	}

	public SelectionGUI getSelectionGUI() {
		return selectionGUI;
	}
	
}
