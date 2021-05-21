package constants;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

public class GameConstant {
	public GameConstant() {}
	public static final double WINDOW_WIDTH = 1200.0D;
	public static final double WINDOW_HEIGHT = 800.0D;
	public static final double MAX_SPEED_Y = 10.0;
	public static final double GRAVITY_G = 0.3;
	public static final double CHARACTER_PHYSIC_X_OFFSET = 10.0;
	public static final double CHARACTER_PHYSIC_Y_OFFSET = 3.0;
	public static final ArrayList<KeyCode> keyPressed = new ArrayList<KeyCode>();
}
