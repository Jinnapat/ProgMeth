package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.SceneHolder;
import scene.GameScene;
import systemMemory.Memory;

public class ReadyUI extends VBox {
	
	Button startBtn;
	Button backBtn;

	public ReadyUI() {
		super();
		
		this.setPrefWidth(400);
		this.setPrefHeight(800);
		this.setAlignment(Pos.TOP_CENTER);
		this.setPadding(new Insets(100));
		this.setSpacing(20);
		this.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.startBtn = new Button("Start");
		this.backBtn = new Button("Back");
		
		this.startBtn.setOnMouseClicked((e) -> {
			this.startHandler();
		});
		
		this.backBtn.setOnMouseClicked((e) -> {
			this.backHandler();
		});
		
		this.getChildren().add(this.startBtn);
		this.getChildren().add(this.backBtn);
	}
	
	private void startHandler() {
		// TODO Auto-generated method stub
		System.out.println("Start");
		Memory.getInstance().gameCanvas.setup();
		Memory.getInstance().gameCanvas.getGameLoop().start();
		SceneHolder.switchScene(Memory.getInstance().gameScene);
	}
	
	private void backHandler() {
		// TODO Auto-generated method stub
		System.out.println("Back to mainMenu");
		SceneHolder.switchScene(Memory.getInstance().mainMeneScene);
	}
	
	
}
