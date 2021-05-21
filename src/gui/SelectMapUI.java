package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.SystemLogic;

public class SelectMapUI extends VBox {
	private Button startBtn;

	public SelectMapUI() {
		super();
		this.setPrefWidth(400);
		this.setPrefHeight(800);
		this.setAlignment(Pos.TOP_CENTER);
		this.setPadding(new Insets(50));
		this.setSpacing(20);
		this.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.startBtn = new Button("Start Game");
		this.startBtn.setOnMouseClicked((e) -> {
			SystemLogic.startGame();
		});
		
		this.getChildren().add(this.startBtn);
	}
}
