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

	public EndGameGUI() {
		super();
		
		this.winnerBox = new VBox();
		
		Text winnerName = new Text("unknown");
		winnerName.setFont(FontHolder.getInstance().dream64);
//		WinnerName.setText(null);
		
		Button backBtn = new Button("back to menu");
		backBtn.setFont(FontHolder.getInstance().dream24);
		
		backBtn.setOnMouseClicked((e) -> {
			this.backHandler();
		});
		
		this.winnerBox.setAlignment(Pos.CENTER);
		this.winnerBox.setSpacing(20);
		
		this.winnerBox.getChildren().add(winnerName);
		this.winnerBox.getChildren().add(backBtn);
		this.getChildren().add(this.winnerBox);
		// TODO Auto-generated constructor stub
	}

	private void backHandler() {
		// TODO Auto-generated method stub
		System.out.println("Back to mainMenu");
		SceneHolder.switchScene(Memory.getInstance().mainMeneScene);
	}
}
