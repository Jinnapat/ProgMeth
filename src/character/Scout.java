package character;

import interfaces.Collidable;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Scout extends Character{
	
	public Scout() {
		super();
		this.setX(10.0);
		this.setY(10.0);
		this.draw(x, y);
	}

	public void draw(double x, double y) {
		this.characterBox = new HBox();
		this.characterBox.setPrefSize(50.0, 50.0);
		this.characterBox.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	@Override
	public void OnCollide(Collidable target) {
		
	}
}
