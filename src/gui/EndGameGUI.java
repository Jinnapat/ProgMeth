package gui;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class EndGameGUI extends StackPane{
	
	private HBox winnerBox;

	public EndGameGUI() {
		super();
		
		this.winnerBox = new HBox();
		
		Text WinnerName = new Text("UnKnown");
		
		this.winnerBox.getChildren().add(WinnerName);
		this.getChildren().add(this.winnerBox);
		// TODO Auto-generated constructor stub
	}
}
