import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

import character.Scout;
import item.Weapon;
import sceneObject.GameScene;
import sceneObject.Ground;
import sceneObject.SolidObject;

public class Game extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage p) throws Exception {
		
		Scout myChar = new Scout(50.0, 50.0, 10.0, 10);
		myChar.setX(20.0);
		myChar.setY(500.0);
		
		Scout myChar2 = new Scout(50.0, 50.0, 10.0, 10);
		myChar2.setX(500.0);
		myChar2.setY(500.0);
		myChar2.setLeftKey(KeyCode.LEFT);
		myChar2.setRightKey(KeyCode.RIGHT);
		myChar2.setJumpKey(KeyCode.UP);
		myChar2.setShootKey(KeyCode.ENTER);
		
		Ground ground1 = new Ground(100, 20, 10, 670, Color.BLACK);
		Ground ground2 = new Ground(400, 20, 200, 530, Color.BLACK);
		Ground ground3 = new Ground(300, 20, 600, 430, Color.BLACK);
		Ground base = new Ground(1200, 50, 0, 700, Color.BLACK);
		
		ArrayList<SolidObject> solidObjects = new ArrayList<SolidObject>();
		solidObjects.add(ground1);
		solidObjects.add(ground2);
		solidObjects.add(ground3);
		solidObjects.add(base);

		myChar.addAllCollidableObject(solidObjects);
		myChar2.addAllCollidableObject(solidObjects);
		//myChar.setWeapon(new Weapon());
		myChar.checkCollide();
		myChar2.checkCollide();
		
		GameScene.root.getChildren().add(myChar.getBoundBox());
		GameScene.root.getChildren().add(myChar2.getBoundBox());
		GameScene.root.getChildren().add(ground1.getGroundBox());
		GameScene.root.getChildren().add(ground2.getGroundBox());
		GameScene.root.getChildren().add(ground3.getGroundBox());
		GameScene.root.getChildren().add(base.getGroundBox());
		
		GameScene.start();
		p.setResizable(false);
		p.setScene(GameScene.scene);
		p.show();
	}
}
