package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import systemMemory.Memory;

public class SelectionGUI extends HBox{
	
	private SelectCharacterUI selectCharacterBox;
	private SelectCharacterUI selectCharacterBox2;
	private ReadyUI readyBox;
	
	public SelectionGUI() {
		super();
		
		Memory.getInstance().selectionGui = this;
		
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20));
		this.setSpacing(20);
		
		this.selectCharacterBox = new SelectCharacterUI();
		this.selectCharacterBox2 = new SelectCharacterUI();
		this.readyBox = new ReadyUI();
		
		this.getChildren().add(this.selectCharacterBox);
		this.getChildren().add(this.selectCharacterBox2);
		this.getChildren().add(this.readyBox);
	}
	
}
