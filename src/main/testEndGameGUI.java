package main;
import javafx.application.Application;
import javafx.stage.Stage;
import logic.SceneHolder;
import scene.EndGameScene;
import scene.SelectionScene;
import systemMemory.Memory;

public class testEndGameGUI extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		SceneHolder sh = new SceneHolder(primaryStage);
		sh.initialize();
		primaryStage.setResizable(false);
		System.out.println(Memory.getInstance().endGameScene);
		primaryStage.setScene(Memory.getInstance().endGameScene);
		primaryStage.setTitle("This is EndGame");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
