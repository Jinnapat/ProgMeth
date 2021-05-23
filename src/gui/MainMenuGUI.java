package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import logic.SceneHolder;
import constants.FontHolder;
import constants.GameConstant;
import constants.ImageHolder;
import constants.SoundHolder;
import scene.SelectionScene;
import systemMemory.Memory;

public class MainMenuGUI extends StackPane {
	private HBox titileBox;
	private HBox menuBox;
	private VBox allBox;
	
	public MainMenuGUI() {
		
		ImageView background = new ImageView(ImageHolder.getInstance().flatNightBackgound);
		background.setFitHeight(GameConstant.WINDOW_HEIGHT);
		background.setFitWidth(GameConstant.WINDOW_WIDTH);
		background.setPreserveRatio(false);
		this.getChildren().add(background);
		
		Memory.getInstance().mainMenuGui = this;
		
		this.setUpTitleBox();
		this.setUpMenuBox();
		this.allBox = new VBox();
		allBox.setAlignment(Pos.CENTER);
		allBox.getChildren().add(this.titileBox);
		allBox.getChildren().add(this.menuBox);
		this.getChildren().add(allBox);
	}
	
	private void setUpTitleBox() {
		this.titileBox = new HBox();
		this.titileBox.setAlignment(Pos.CENTER);
		
		Text title = new Text();
		title.setFont(FontHolder.getInstance().dream64);
		title.setText("tiny shooters");
		
		this.titileBox.getChildren().add(title);
	}
	
	private void setUpMenuBox() {
		this.menuBox = new HBox();
		
		this.menuBox.setAlignment(Pos.CENTER);
		this.menuBox.setPadding(new Insets(50));
		this.menuBox.setSpacing(20);
		this.setUpButtons();
	}
	
	private void setUpButtons() {
		Button playBtn = addButtonToMenu("play");
		Button exitBtn = addButtonToMenu("exit");
		
		playBtn.setOnMouseClicked((e) -> {
			playHandler();
		});
		
		exitBtn.setOnMouseClicked((e) -> {
			exitHandler();
		});
		
	}
	
	private Button addButtonToMenu(String label) {
		Button button = new Button(label);
		button.setFont(FontHolder.getInstance().dream24);
		this.menuBox.getChildren().add(button);
		return button;
	}
	private void playHandler() {
		SceneHolder.switchScene(Memory.getInstance().selectionScene);
	}
	
	private void exitHandler() {
		System.out.println("Exit");
		System.exit(0);
	}
}
