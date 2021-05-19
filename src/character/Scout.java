package character;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Scout extends Character{
	
	public Scout() {
		super(50.0, 50.0, 10.0, 10, 100);
		setHealth(100);
		setMaxHealth(100);
		getBoundBox().setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
