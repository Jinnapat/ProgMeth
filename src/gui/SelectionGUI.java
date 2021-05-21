package gui;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SelectionGUI extends HBox{
	
	private SelectCharacterUI selectCharacterBox;
	private VBox selectMap;
	
	public SelectionGUI() {
		super();
		this.selectCharacterBox = new SelectCharacterUI();
		this.selectMap = new VBox();
		
		this.getChildren().add(this.selectCharacterBox);
	}
	
}
