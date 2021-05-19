package character;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Scout extends Character{
	private AnimationTimer animationLoop;
	private double lastTriggerTime;
	private int curImage = 0;
	private ArrayList<Image> runImages;
	private ArrayList<Image> idleImages;
	public Scout() {
		super(50.0, 50.0, 10.0, 10, 100);
		lastTriggerTime = 0.0;
		setHealth(100);
		setMaxHealth(100);
		runImages = new ArrayList<Image>();
		idleImages = new ArrayList<Image>();
		
		for (int i = 0; i < 6; i++) {
			runImages.add(new Image(ClassLoader.getSystemResource("character/Black/run/" + (i+1) + ".png").toString()));
		}
		for (int i = 0; i < 5; i++) {
			idleImages.add(new Image(ClassLoader.getSystemResource("character/Black/idle/" + (i+1) + ".png").toString()));
		}
		
		imageView = new ImageView(idleImages.get(curImage));
		imageView.setFitHeight(50.0);
		imageView.setPreserveRatio(true);
		getBoundBox().getChildren().add(imageView);
		
		this.animationLoop = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				
				lastTriggerTime = (lastTriggerTime < 0 ? now : lastTriggerTime);
				
				if (now - lastTriggerTime >= 100000000) {
					if (getState() == "idle") {
						curImage = (curImage + 1) % idleImages.size();
						imageView.setImage(idleImages.get(curImage));
					} else if (getState() == "running") {
						curImage = (curImage + 1) % runImages.size();
						imageView.setImage(runImages.get(curImage));
					}
					lastTriggerTime = now;
				}
			}
		};
		
		this.animationLoop.start();
	}
}
