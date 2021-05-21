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

import constants.FontHolder;
import constants.GameConstant;
import constants.ImageHolder;
import constants.SoundHolder;

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
		
		
//		MediaPlayer mediaPlayer = new MediaPlayer(SoundHolder.getInstance().bgm);
//		mediaPlayer.setVolume(0.1);
//		mediaPlayer.play();
		
		this.titileBox = new HBox();
		this.menuBox = new HBox();
		
		this.titileBox.setAlignment(Pos.CENTER);
		
		this.menuBox.setAlignment(Pos.CENTER);
		this.menuBox.setPadding(new Insets(50));
		this.menuBox.setSpacing(20);
		
		Text title = new Text();
		title.setFont(FontHolder.getInstance().dream64);
		title.setText("this is new");
		
		Button play1PlayerBtn = new Button("1 player");
		Button play2PlayerBtn = new Button("2 player");
		Button optionBtn = new Button("option");
		Button exitBtn = new Button("exit");
		
		play1PlayerBtn.setFont(FontHolder.getInstance().dream24);
		play2PlayerBtn.setFont(FontHolder.getInstance().dream24);
		optionBtn.setFont(FontHolder.getInstance().dream24);
		exitBtn.setFont(FontHolder.getInstance().dream24);
		
		play1PlayerBtn.setOnMouseClicked((e) -> {
			play1PlayerHandler();
		});
		
		play2PlayerBtn.setOnMouseClicked((e) -> {
			play2PlayerHandler();
		});
		
		optionBtn.setOnMouseClicked((e) -> {
			optionHandler();
		});
		
		exitBtn.setOnMouseClicked((e) -> {
			exitHandler();
		});
		
		this.titileBox.getChildren().add(title);
		
		this.menuBox.getChildren().add(play1PlayerBtn);
		this.menuBox.getChildren().add(play2PlayerBtn);
		this.menuBox.getChildren().add(optionBtn);
		this.menuBox.getChildren().add(exitBtn);
		
		this.allBox = new VBox();
		
		allBox.setAlignment(Pos.CENTER);
		allBox.getChildren().add(this.titileBox);
		allBox.getChildren().add(this.menuBox);
		
		this.getChildren().add(allBox);
	}
	
	private void play1PlayerHandler() {
		//TODO
		System.out.println("Play1Player");
	}
	
	private void play2PlayerHandler() {
		//TODO
		System.out.println("Play2Player");
	}
	
	private void optionHandler() {
		//TODO
		System.out.println("Option");
	}
	
	private void exitHandler() {
		System.out.println("Exit");
		System.exit(0);
	}
}
