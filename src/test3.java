import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import character.Scout;
import gui.Healthbar;
import item.base.Weapon;
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
		
		Scout myChar = new Scout();
		myChar.setX(20.0);
		myChar.setY(100.0);
		myChar.setWeapon(new Weapon());
		myChar.getWeapon().setFireRate(20);
		myChar.checkControl();
		myChar.setName("Player 1");
		myChar.setFallable(true);
		
		DropBox db = new DropBox();
		db.setX(20.0);
		db.setY(100.0);
		db.setFallable(true);
		
		new Ground(100, 20, 10, 670, Color.BLACK);
		new Ground(400, 20, 200, 530, Color.BLACK);
		new Ground(300, 20, 600, 430, Color.BLACK);
		new Ground(1200, 50, 0, 700, Color.BLACK);
		
		Healthbar player1Healthbar = myChar.getHealthBar();
		AnchorPane.setLeftAnchor(player1Healthbar.getHealthBox(), 10.0);
		
		GameScene.start();
		p.setResizable(false);
		p.setScene(GameScene.scene);
		p.show();
	}
}
