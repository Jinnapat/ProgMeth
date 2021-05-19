package character;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Scout extends Character{
	private AnimationTimer animationLoop;
	private double lastTriggerTime;
	
	public Scout() {
		super(50.0, 50.0, 10.0, 10, 100);
		lastTriggerTime = 0.0;
		setHealth(100);
		setMaxHealth(100);
		
		String imageUrl = ClassLoader.getSystemResource("character/Black/run/black_run_1.png").toString();
		imageView = new ImageView(new Image(imageUrl));
		imageView.setFitHeight(50.0);
		imageView.setPreserveRatio(true);
		getBoundBox().getChildren().add(imageView);
	}
}