package constants;

import javafx.scene.image.Image;

public class ImageHolder {
	private static final ImageHolder instance = new ImageHolder();
	public Image awp = this.loadImage("AWP", "png");
	public Image shortgun = this.loadImage("shortgun", "png");
	
	
	
	public ImageHolder() {
		super();
	}
	
	public static ImageHolder getInstance() {
		return instance;
	}

	private Image loadImage(String name, String fileType) {
		String path = "images/"+name+"."+fileType;
//		System.out.println(path);
		return new Image(ClassLoader.getSystemResourceAsStream(path));
	}
}
