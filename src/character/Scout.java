package character;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Scout extends Character{
	private AnimationTimer animationLoop;
	private double lastTriggerTime;
	private ImageView imageView;
	
	public Scout() {
		super(50.0, 50.0, 10.0, 10, 100);
		lastTriggerTime = 0.0;
		setHealth(100);
		setMaxHealth(100);
		
		String imageUrl = ClassLoader.getSystemResource("character/Black/Gunner_Black_Run.png").toString();
		imageView = new ImageView(new Image(imageUrl));
		getBoundBox().getChildren().add(imageView);
	}
}
