package character;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Scout extends Character{
	
	public Scout(double width, double height, double x, double y, double speed, double jumpStrength) {
		super(width, height, x, y, speed, jumpStrength);
		this.draw();
	}

	public void draw() {
		getBoundBox().setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
}