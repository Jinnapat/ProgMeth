package gui;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class Healthbar {
	private AnchorPane healthBox;
	
	public Healthbar() {
		super();
		this.healthBox = new AnchorPane();
		this.healthBox.setBackground(new Background(new BackgroundFill(Color.CRIMSON, null, null)));
		this.healthBox.setPrefSize(200, 20);
		
		AnchorPane.setTopAnchor(healthBox, 10.0);
	}

	public AnchorPane getHealthBox() {
		return healthBox;
	}

	public void setHealthBox(AnchorPane healthBox) {
		this.healthBox = healthBox;
	}
	
	public void displayHealth(int health, int maxHealth) {
		healthBox.setPrefWidth(((double)health) / ((double)maxHealth) * 200.0);
	}
}
