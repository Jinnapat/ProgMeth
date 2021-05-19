package constants;

import javafx.scene.text.Font;

public class FontHolder {
	private static final FontHolder instance = new FontHolder();
	public Font dream24 = this.loadFont("Dream_MMA", 24);
	// can add new font
	
	public static FontHolder getInstance() {
		return instance;
	}
	
	public FontHolder() {}
	
	public Font loadFont(String name, int size) {
		return Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/" + name + ".tff"), size);
	}
}
