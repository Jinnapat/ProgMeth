import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Game extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage p) throws Exception {
		// TODO Auto-generated method stub
		HBox root = new HBox();
		
		Scene scene = new Scene(root);
		
		System.out.println("test");
		p.setScene(scene);
		p.show();
	}
}
