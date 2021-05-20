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
		myChar.setX(100.0);
		myChar.setY(500.0);
		myChar.setCheckControls(true);
		myChar.setName("Player 1");
		myChar.setFallable(true);
		
		Scout myChar2 = new Scout();
		myChar2.setHealth(100);
		myChar2.setX(1050.0);
		myChar2.setY(500.0);
		myChar2.getControlKeys().put("leftKey", KeyCode.LEFT);
		myChar2.getControlKeys().put("rightKey", KeyCode.RIGHT);
		myChar2.getControlKeys().put("jumpKey", KeyCode.UP);
		myChar2.getControlKeys().put("shootKey", KeyCode.ENTER);
		myChar2.setCheckControls(true);
		myChar2.setName("Player 2");
		myChar2.setFallable(true);
		
		//Ground
		new Ground(1100, 50, 50, 750, false);
		new Ground(50, 50, 450, 700, false);
		new Ground(50, 50, 700, 700, false);
		
		// wall
		new Ground(50, 50, 300, 520, false);
		new Ground(50, 50, 850, 520, false);
		new Ground(50, 50, 300, 570, false);
		new Ground(50, 50, 850, 570, false);
		new Ground(50, 50, 300, 620, false);
		new Ground(50, 50, 850, 620, false);
		
		// roof
		new Ground(100, 20, 300, 500, true);
		new Ground(240, 20, 480, 500, true);
		new Ground(100, 20, 800, 500, true);
		
		// left platforms
		new Ground(100, 20, 50, 620, true);
		new Ground(50, 40, 150, 600, true);
		
		new Ground(100, 20, 50, 470, true);
		new Ground(50, 40, 150, 450, true);
		
		new Ground(100, 20, 50, 320, true);
		new Ground(50, 40, 150, 300, true);
		
		new Ground(100, 20, 50, 170, true);
		new Ground(50, 40, 150, 150, true);
		
		//right platforms
		new Ground(100, 20, 1050, 620, true);
		new Ground(50, 40, 1000, 600, true);
		
		new Ground(100, 20, 1050, 470, true);
		new Ground(50, 40, 1000, 450, true);
		
		new Ground(100, 20, 1050, 320, true);
		new Ground(50, 40, 1000, 300, true);
		
		new Ground(100, 20, 1050, 170, true);
		new Ground(50, 40, 1000, 150, true);
		
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
