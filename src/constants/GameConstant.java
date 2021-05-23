package constants;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

public class GameConstant {
	public GameConstant() {}
	// Window constants
	public static final double WINDOW_WIDTH = 1200.0D;
	public static final double WINDOW_HEIGHT = 800.0D;
	
	// Physics constants
	public static final double MAX_SPEED_Y = 10.0;
	public static final double GRAVITY_G = 0.3;
	public static final double CHARACTER_PHYSIC_X_OFFSET = 10.0;
	public static final double CHARACTER_PHYSIC_Y_OFFSET = 3.0;
	
	// Gameplay constants
	public static final ArrayList<KeyCode> keyPressed = new ArrayList<KeyCode>();
	public static final int UTILITY_COOLDOWN = 500;
	public static final int CHARACTER_ANIMATION_DELAY = 7;
	public static final double TAGS_OFFSET_X = 10.0;
	public static final double NAME_TAG_OFFSET_Y = 23.0;
	public static final double AMMO_TAG_OFFSET_Y = 13.0;
	public static final double HEALTHBAR_OFFSET_Y = 5.0;
	public static final double HEALTHBAR_HEIGHT = 5.0;
	
	// gun constants
	public static final double BULLET_SPAWN_OFFSET_X = 15.0;
	public static final double BULLET_SPAWN_OFFSET_Y = 10;
}
