import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import GUI.Healthbar;
import character.Scout;
import item.Weapon;
import sceneObject.GameScene;
import sceneObject.Ground;

public class Game extends Application{
	
	public static void main(String[] args) {
		launch(args);
	} 

	@Override
	public void start(Stage p) throws Exception {
		
		Scout myChar = new Scout();
		myChar.setX(20.0);
		myChar.setY(500.0);
		myChar.setWeapon(new Weapon());
		myChar.getWeapon().setFireRate(20);
		myChar.checkControl();
		myChar.setName("Player 1");
		
		Scout myChar2 = new Scout();
		myChar2.setX(500.0);
		myChar2.setY(500.0);
		myChar2.getControlKeys().put("leftKey", KeyCode.LEFT);
		myChar2.getControlKeys().put("rightKey", KeyCode.RIGHT);
		myChar2.getControlKeys().put("jumpKey", KeyCode.UP);
		myChar2.getControlKeys().put("shootKey", KeyCode.ENTER);
		myChar2.checkControl();
		myChar2.setName("Player 2");
		
		new Ground(100, 20, 10, 670, Color.BLACK);
		new Ground(400, 20, 200, 530, Color.BLACK);
		new Ground(300, 20, 600, 430, Color.BLACK);
		new Ground(1200, 50, 0, 700, Color.BLACK);
		
		Healthbar player1Healthbar = new Healthbar(100, 100);
		GameScene.root.getChildren().add(player1Healthbar.getHealthBox());
		
		GameScene.start();
		p.setTitle("Team Six");
		p.setResizable(false);
		p.setScene(GameScene.scene);
		p.show();
	}
}
