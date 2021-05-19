package constants;

import javafx.scene.image.Image;

public class ImageHolder {
	public Image awp = this.loadImage("AWP", "png");
	public Image shortgun = this.loadImage("shortgun", "png");
	
	
	
	public ImageHolder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static ImageHolder getInstance() {
		return new ImageHolder();
	}

	private Image loadImage(String name, String fileType) {
		String path = "images/"+name+"."+fileType;
		System.out.println(path);
		return new Image(ClassLoader.getSystemResourceAsStream(path));
	}
}
