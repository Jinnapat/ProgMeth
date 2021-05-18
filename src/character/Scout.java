package character;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Scout extends Character{
	
	public Scout(double width, double height, double speed, double jumpStrength) {
		super(width, height, speed, jumpStrength);
		getBoundBox().setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
