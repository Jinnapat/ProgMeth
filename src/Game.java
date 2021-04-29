import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import character.Scout;
import sceneObject.GameScene;
import sceneObject.Ground;

public class Game extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage p) throws Exception {
		
		Scout myChar = new Scout(50.0, 50.0, 10.0, 10.0, 15.0);
		Ground ground1 = new Ground(100, 10, 10, 400, Color.BLACK);
		Ground ground2 = new Ground(100, 10, 200, 200, Color.BLACK);
		Ground base = new Ground(1200, 50, 0, 700, Color.BLACK);
		
		myChar.addCollidableObject(ground1);
		GameScene.root.getChildren().add(myChar.getCharacterBox());
		GameScene.root.getChildren().add(ground1.getGroundBox());
		GameScene.root.getChildren().add(ground2.getGroundBox());
		GameScene.root.getChildren().add(base.getGroundBox());
		
		GameScene.start();
		p.setResizable(false);
		p.setScene(GameScene.scene);
		p.show();
	}
}
