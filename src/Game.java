import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import character.Scout;
import javafx.animation.AnimationTimer;

public class Game extends Application{
	
	private AnimationTimer animationTimer;
	public static String[] keyPressed;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage p) throws Exception {
		
		Scout myChar = new Scout();
		
		AnchorPane root = new AnchorPane();
		
		root.getChildren().add(myChar.getCharacterBox());
		
		Scene scene = new Scene(root, 1200, 800);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				boolean isAdded = false;

			}
			
		});
		p.setResizable(false);
		p.setScene(scene);
		p.show();
	}
}
