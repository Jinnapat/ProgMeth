package character;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Scout extends Character{
	
	public Scout(double width, double height, double x, double y, double speed) {
		super(width, height, x, y, speed);
		this.draw();
	}

	public void draw() {
		HBox faceBox = new HBox();
		faceBox.setPrefSize(10.0, 10.0);
		faceBox.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.characterBox = new AnchorPane();
		this.characterBox.setPrefSize(width, height);
		this.characterBox.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.characterBox.getChildren().add(faceBox);
		AnchorPane.setTopAnchor(faceBox, 10.0);
		AnchorPane.setLeftAnchor(faceBox, 10.);
	}
}
