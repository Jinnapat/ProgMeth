package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
import logic.ImageLogic;
import character.Character;
import character.Scout;

public class SelectCharacterUI extends VBox{
	private Character character;
	private Image characterImage;
	private TextField nameInput;
	private GridPane selectCharacter;

	public SelectCharacterUI() {
		super();
		
		this.setPrefWidth(400);
		this.setPrefHeight(800);
		this.setAlignment(Pos.TOP_CENTER);
		this.setPadding(new Insets(50));
		this.setSpacing(20);
		this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.setCharacter(new Scout());
		
		this.nameInput = new TextField();
		this.nameInput.setText(this.character.getName());
		this.checkChange();
	}

	public void setCharacter(Character character) {
		this.character = character;
		this.setCharacterImage(this.character.getSprite());
	}

	public void setCharacterImage(Image characterImage) {
		this.characterImage = characterImage;
	}
	
	public void checkChange() {
		this.getChildren().add(new ImageView(ImageLogic.resizeImage(characterImage, 200, 200)));
		this.getChildren().add(this.nameInput);
	}
}
