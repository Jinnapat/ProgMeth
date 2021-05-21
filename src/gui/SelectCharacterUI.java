package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
import logic.ImageLogic;
import character.Character;
import character.Scout;
import constants.ImageHolder;

public class SelectCharacterUI extends VBox{
	private Character character;
	private Image characterImage;
	private 
	private Button selectBtn;

	public SelectCharacterUI() {
		super();
		
		this.setPrefWidth(400);
		this.setPrefHeight(800);
		this.setAlignment(Pos.TOP_CENTER);
		this.setPadding(new Insets(50));
		this.setSpacing(20);
		this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.setCharacter(new Scout());
		
	}

	public void setCharacter(Character character) {
		this.character = character;
		System.out.println(this.character.getSprite());
		this.setCharacterImage(this.character.getSprite());
	}

	public void setCharacterImage(Image characterImage) {
		this.characterImage = characterImage;
		this.checkChange();
	}
	
	public void checkChange() {
		this.getChildren().add(new ImageView(ImageLogic.resizeImage(characterImage, 200, 200)));
	}
}
