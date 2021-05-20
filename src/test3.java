import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import character.Heavy;
import character.Scout;
import gui.Healthbar;
import item.base.Weapon;
import item.derived.Awp;
import item.derived.DropBox;
import sceneObject.GameScene;
import sceneObject.Ground;

public class test3 extends Application{
	
	public static void main(String[] args) {
		launch(args);
	} 

	@Override
	public void start(Stage p) throws Exception {
		ImageView background = new ImageView(new Image(ClassLoader.getSystemResource("images/background.png").toString()));
		background.setFitHeight(800);
		background.setPreserveRatio(true);
		GameScene.root.getChildren().add(background);
		
		Heavy myChar = new Heavy();
		myChar.setWeapon(new Awp());
		myChar.setX(100.0);
		myChar.setY(500.0);
		myChar.setCheckControls(true);
		myChar.setName("Player 1");
		myChar.setFallable(true);
		
		DropBox db = new DropBox(10, 10, 10, 10, Color.RED);
		db.setX(200.0);
		db.setY(0);
		db.setFallable(true);
		
		new Ground(100, 20, 10, 670);
		new Ground(5000, 200, 0, 500);
		
		Healthbar player1Healthbar = myChar.getHealthBar();
		AnchorPane.setLeftAnchor(player1Healthbar.getHealthBox(), 10.0);
		
		GameScene.start();
		p.setResizable(false);
		p.setScene(GameScene.scene);
		p.show();
	}
}
