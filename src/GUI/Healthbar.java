package GUI;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class Healthbar {
	private AnchorPane healthBox;
	private int health;
	private int maxHealth;
	
	public Healthbar(int health, int max_health) {
		super();
		this.healthBox = new AnchorPane();
		this.health = health;
		this.maxHealth = max_health;
		this.healthBox.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		this.healthBox.setPrefSize(200, 50);
		AnchorPane.setTopAnchor(healthBox, 20.0);
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public AnchorPane getHealthBox() {
		return healthBox;
	}

	public void setHealth_box(AnchorPane healthBox) {
		this.healthBox = healthBox;
	}
	
	
}
