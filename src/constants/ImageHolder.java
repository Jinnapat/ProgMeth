package constants;

import javafx.scene.image.Image;

public class ImageHolder {
	private static final ImageHolder instance = new ImageHolder();

	public Image nothing = this.loadImage("nothing", "png");
	public Image awp = this.loadImage("guns/AWP", "png");
	public Image shortgun = this.loadImage("guns/shortgun", "png");
	public Image ak47 = this.loadImage("guns/Ak47", "png");
	public Image box = this.loadImage("box", "png");

	public ImageHolder() {
		super();
	}

	public static ImageHolder getInstance() {
		return instance;
	}

	private Image loadImage(String name, String fileType) {
		String path = "images/" + name + "." + fileType;
		return new Image(ClassLoader.getSystemResourceAsStream(path));
	}
}
