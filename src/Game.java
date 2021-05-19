import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import character.Engineer;
import character.Heavy;
import character.Scout;
import character.Sniper;
import constants.GameConstant;
import gui.Healthbar;
import item.base.Weapon;
import sceneObject.GameScene;
import sceneObject.Ground;

public class Game extends Application{
	
	public static void main(String[] args) {
		launch(args);
	} 

	@Override
	public void start(Stage p) throws Exception {
		ImageView background = new ImageView(new Image(ClassLoader.getSystemResource("images/background.png").toString()));
		background.setFitHeight(GameConstant.WINDOW_HEIGHT);
		background.setPreserveRatio(true);
		GameScene.root.getChildren().add(background);
		
		Heavy myChar = new Heavy();
		myChar.setX(20.0);
		myChar.setY(500.0);
		myChar.setWeapon(new Weapon());
		myChar.getWeapon().setFireRate(20);
		myChar.checkControl();
		myChar.setName("Player 1");
		myChar.setFallable(true);
		
		Scout myChar2 = new Scout();
		myChar2.setHealth(100);
		myChar2.setX(500.0);
		myChar2.setY(500.0);
		myChar2.setWeapon(new Weapon());
		myChar2.getWeapon().setFireRate(20);
		myChar2.getControlKeys().put("leftKey", KeyCode.LEFT);
		myChar2.getControlKeys().put("rightKey", KeyCode.RIGHT);
		myChar2.getControlKeys().put("jumpKey", KeyCode.UP);
		myChar2.getControlKeys().put("shootKey", KeyCode.ENTER);
		myChar2.checkControl();
		myChar2.setName("Player 2");
		myChar2.setFallable(true);
		
		new Ground(100, 20, 10, 670, Color.BLACK);
		new Ground(400, 20, 200, 530, Color.BLACK);
		new Ground(300, 20, 600, 430, Color.BLACK);
		new Ground(1200, 50, 0, 700, Color.BLACK);
		
		Healthbar player1Healthbar = myChar.getHealthBar();
		AnchorPane.setLeftAnchor(player1Healthbar.getHealthBox(), 10.0);
		
		Healthbar player2Healthbar = myChar2.getHealthBar();
		AnchorPane.setRightAnchor(player2Healthbar.getHealthBox(), 10.0);
		
		GameScene.start();
		p.setResizable(false);
		p.setScene(GameScene.scene);
		p.show();
	}
}
