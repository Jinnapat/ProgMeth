package gui;

import constants.FontHolder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameLogic;
import logic.SceneHolder;
import scene.GameScene;
import systemMemory.Memory;

public class ReadyUI extends VBox {
	
	private Button startBtn;
	private Button backBtn;

	public ReadyUI() {
		super();
		
		this.setPrefWidth(400);
		this.setPrefHeight(800);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(100));
		this.setSpacing(20);
		this.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.setUpButtons();
	}
	
	private void setUpButtons() {
		this.startBtn = new Button("start");
		this.backBtn = new Button("back");
		
		this.startBtn.setMinWidth(200);
		this.backBtn.setMinWidth(200);
		
		this.startBtn.setFont(FontHolder.getInstance().dream24);
		this.backBtn.setFont(FontHolder.getInstance().dream24);
		
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
		System.out.println("Start");
		GameLogic.fixNameDuplicate();
		Memory.getInstance().gameCanvas.setup();
		Memory.getInstance().gameCanvas.getGameLoop().start();
		SceneHolder.switchScene(Memory.getInstance().gameScene);
	}
	
	private void backHandler() {
		System.out.println("Back to mainMenu");
		SceneHolder.switchScene(Memory.getInstance().mainMenuScene);
	}
	
	
}
