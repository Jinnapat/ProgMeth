package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import systemMemory.Memory;

public class SelectionGUI extends HBox{
	
	private SelectCharacterUI selectCharacterBox;
	private SelectCharacterUI selectCharacterBox2;
	private SelectMapUI selectMap;
	
	public SelectionGUI() {
		super();
		
		Memory.getInstance().selectionGui = this;
		
		this.setPadding(new Insets(20));
		
		this.selectCharacterBox = new SelectCharacterUI();
		this.selectCharacterBox2 = new SelectCharacterUI();
		this.selectMap = new SelectMapUI();
		
		this.getChildren().add(this.selectCharacterBox);
		this.getChildren().add(this.selectCharacterBox2);
		this.getChildren().add(this.selectMap);
	}
	
}
