package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.ImageView;
import logic.ImageLogic;
import logic.RenderableHolder;

import java.util.ArrayList;

import character.Character;
import character.Engineer;
import character.Heavy;
import character.Scout;
import character.Shield;
import character.Sniper;

public class SelectCharacterUI extends VBox{
	private Character character;
	private Image characterImage;
	private ImageView characterImageView;
	private TextField nameInput;
	private VBox selectCharacter;

	public SelectCharacterUI() {
		super();
		
		this.setPrefWidth(400);
		this.setPrefHeight(800);
		this.setAlignment(Pos.TOP_CENTER);
		this.setPadding(new Insets(100));
		this.setSpacing(20);
		this.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.setCharacter(new Scout());
		this.setNameInput();
		this.setSelectCharacter();
		
		this.getChildren().add(this.characterImageView);
		this.getChildren().add(this.nameInput);
		this.getChildren().add(this.selectCharacter);
	}

	public void setCharacter(Character character) {
		RenderableHolder.getInstance().addGarbage(this.character);
		this.character = character;
		this.setCharacterImage(this.character.getSprite());
	}
	
	private void setCharacter(String className) {
		switch(className) {
			case "Scout":
				this.setCharacter(new Scout());
				break;
			case "Engineer":
				this.setCharacter(new Engineer());
				break;
			case "Heavy":
				this.setCharacter(new Heavy());
				break;
			case "Shield":
				this.setCharacter(new Shield());
				break;
			case "Sniper":
				this.setCharacter(new Sniper());
				break;
		}
	}

	public void setCharacterImage(Image characterImage) {
		this.characterImage = characterImage;
		if(this.characterImageView == null) {
			this.characterImageView = new ImageView(ImageLogic.resizeImage(characterImage, 200, 200));
		}
		else {
			this.characterImageView.setImage(ImageLogic.resizeImage(characterImage, 200, 200));
		}
	}
	
	public void setNameInput() {
		this.nameInput = new TextField();
		this.nameInput.setAlignment(Pos.CENTER);
		this.nameInput.setFont(new Font(30));
		this.nameInput.setText(this.character.getName());
		
		this.nameInput.setOnKeyTyped((event) -> {
			getCharacter().setName(nameInput.getText());
		});
	}

	public void setSelectCharacter() {
		this.selectCharacter = new VBox();
		this.selectCharacter.setAlignment(Pos.CENTER);
		this.selectCharacter.setPadding(new Insets(20));
		this.selectCharacter.setSpacing(20);
		
		ArrayList<String> characterClass = new ArrayList<String>();
		characterClass.add("Scout");
		characterClass.add("Engineer");
		characterClass.add("Heavy");
		characterClass.add("Shield");
		characterClass.add("Sniper");
		
		for(int i=0; i<characterClass.size();i++) {
			
			String name = characterClass.get(i);
			Button characterBtn = new Button();
			characterBtn.setText(name);
			characterBtn.setPadding(new Insets(0, 20, 0, 20));
			characterBtn.setFont(new Font(20));
			
			characterBtn.setOnMouseClicked((event) -> {
				this.setCharacter(name);
			});
			this.selectCharacter.getChildren().add(characterBtn);
		}
	}

	public Character getCharacter() {
		return character;
	}
	
	
}
