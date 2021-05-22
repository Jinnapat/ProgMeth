package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SelectionGUI extends HBox{
	
	private SelectCharacterUI selectCharacterBox;
	private SelectCharacterUI selectCharacterBox2;
	
	public SelectionGUI() {
		super();
		
		this.setPadding(new Insets(20));
		
		this.selectCharacterBox = new SelectCharacterUI();
		this.selectCharacterBox2 = new SelectCharacterUI();
		
		this.getChildren().add(this.selectCharacterBox);
		this.getChildren().add(this.selectCharacterBox2);
	}
	
}
