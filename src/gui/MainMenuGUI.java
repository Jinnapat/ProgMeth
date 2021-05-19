package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import constants.FontHolder;
import constants.GameConstant;

public class MainMenuGUI extends VBox {
	private HBox titileBox;
	private HBox menuBox;
	
	public MainMenuGUI() {
//		this.setPrefSize(GameConstant.WINDOW_HEIGHT, GameConstant.WINDOW_WIDTH);
//		this.setPrefSize(100, 200);
		this.setPadding(new Insets(20));
		this.setAlignment(Pos.CENTER);
		
		
		this.titileBox = new HBox();
		this.menuBox = new HBox();
		
		this.titileBox.setAlignment(Pos.CENTER);
		
		this.menuBox.setAlignment(Pos.CENTER);
		this.menuBox.setPadding(new Insets(20));
		this.menuBox.setSpacing(20);
		
		Text title = new Text();
		title.setFont(FontHolder.getInstance().dream64);
		title.setText("this is new");
		
		Button play1PlayerBtn = new Button("1 player");
		Button play2PlayerBtn = new Button("2 player");
		Button optionBtn = new Button("option");
		
		play1PlayerBtn.setFont(FontHolder.getInstance().dream24);
		play2PlayerBtn.setFont(FontHolder.getInstance().dream24);
		optionBtn.setFont(FontHolder.getInstance().dream24);
		
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
