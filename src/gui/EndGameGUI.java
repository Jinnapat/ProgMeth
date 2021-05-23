package gui;

import constants.FontHolder;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.SceneHolder;
import systemMemory.Memory;

public class EndGameGUI extends StackPane{
	
	private VBox winnerBox;
	private Text winnerName;

	public EndGameGUI() {
		super();
		Memory.getInstance().endGameGui = this;
		
		this.winnerBox = new VBox();
		this.winnerBox.setAlignment(Pos.CENTER);
		this.winnerBox.setSpacing(20);
		this.getChildren().add(this.winnerBox);
		this.fillWinnerBox();
	}

	private void fillWinnerBox() {
		this.winnerName = new Text();
		this.setWinnerName(null);
		this.winnerName.setFont(FontHolder.getInstance().dream32);
		
		Button backBtn = new Button("back to menu");
		backBtn.setFont(FontHolder.getInstance().dream24);
		
		backBtn.setOnMouseClicked((e) -> {
			this.backHandler();
		});
		
		this.winnerBox.getChildren().add(this.winnerName);
		this.winnerBox.getChildren().add(backBtn);
	}
	
	private void backHandler() {
		System.out.println("Back to mainMenu");
		SceneHolder.switchScene(Memory.getInstance().mainMeneScene);
	}

	public Text getWinnerName() {
		return winnerName;
	}

	public void setWinnerName(String name) {
		if(name == null) {
			name = "Unknown";
		}
		this.winnerName.setText(name.toLowerCase() + " is the winner");
	}
	
	
}
