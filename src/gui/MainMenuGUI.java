package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import constants.GameConstant;

public class MainMenuGUI extends VBox {
	private HBox titileBox;
	private HBox menuBox;
	
	public MainMenuGUI() {
//		this.setPrefSize(GameConstant.WINDOW_HEIGHT, GameConstant.WINDOW_WIDTH);
//		this.setPrefSize(100, 200);
		
		this.titileBox = new HBox();
		this.menuBox = new HBox();
		
		Text title = new Text();
		title.setText("This is Name");
		
		Button play1PlayerBtn = new Button("1 Player");
		Button play2PlayerBtn = new Button("2 Player");
		Button optionBtn = new Button("Option");
		
		play1PlayerBtn.setOnMouseClicked((e) -> {
			play1PlayerHandler();
		});
		
		play2PlayerBtn.setOnMouseClicked((e) -> {
			play2PlayerHandler();
		});
		
		optionBtn.setOnMouseClicked((e) -> {
			optionHandler();
		});
		
		this.titileBox.getChildren().add(title);
		
		this.menuBox.getChildren().add(play1PlayerBtn);
		this.menuBox.getChildren().add(play2PlayerBtn);
		this.menuBox.getChildren().add(optionBtn);
		
		this.getChildren().add(this.titileBox);
		this.getChildren().add(this.menuBox);
	}
	
	private void play1PlayerHandler() {
		//TODO
	}
	
	private void play2PlayerHandler() {
		//TODO
	}
	
	private void optionHandler() {
		//TODO
	}
}
