package constants;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class ImageHolder {
	private static final ImageHolder instance = new ImageHolder();

	public Image nothing = this.loadImage("nothing", "png");
	public Image awp = this.loadImage("guns/AWP", "png");
	public Image shortgun = this.loadImage("guns/shortgun", "png");
	public Image ak47 = this.loadImage("guns/Ak47", "png");
	public Image box = this.loadImage("box", "png");
	public Image heartPlus = this.loadImage("heart+", "png");
	public Image ammoStash = this.loadImage("ammoStash", "png");
	public Image flatNightBackgound = this.loadImage("flatNightBackground", "png");
	public Image gameBackgound = this.loadImage("background", "png");
	public ArrayList<Image> charecterBlack = this.loadImage("Black", "run", "png", 6);
	public Image mine = this.loadImage("mine", "png");
	
	public ImageHolder() {
		super();
		System.out.println("ImageHolder");
	}

	public static ImageHolder getInstance() {
		return instance;
	}

	private Image loadImage(String name, String fileType) {
		String path = "images/" + name + "." + fileType;
		return new Image(ClassLoader.getSystemResourceAsStream(path));
	}

	private ArrayList<Image> loadImage(String name, String action, String fileType, int number) {
		ArrayList<Image> imgList = new ArrayList<Image>();

		for (int i = 1; i <= number; i++) {
			String path = "character/" + name + '/' + action + "/" + i + "." + fileType;
			imgList.add(new Image(ClassLoader.getSystemResourceAsStream(path)));
		}

		return imgList;
	}
}
