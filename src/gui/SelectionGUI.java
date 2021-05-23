package gui;

import character.Scout;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import systemMemory.Memory;

public class SelectionGUI extends HBox{
	
	private int playerNum;
	private SelectCharacterUI selectCharacterBox;
	private SelectCharacterUI selectCharacterBox2;
	private ReadyUI readyBox;
	
	public SelectionGUI() {
		super();
		this.setPlayerNum(1);
		
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

	public void reset() {
		this.selectCharacterBox.setCharacter(new Scout());
		this.selectCharacterBox2.setCharacter(new Scout());
	}
	
	public SelectCharacterUI getSelectCharacterBox() {
		return selectCharacterBox;
	}

	public SelectCharacterUI getSelectCharacterBox2() {
		return selectCharacterBox2;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
}
