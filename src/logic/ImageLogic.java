package logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sceneObject.SolidObject;

public class ImageLogic {
	public static ImageView resizeImageToImageView(SolidObject obj, Image image, double width, double height) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(height);
		imageView.setFitWidth(width);
		obj.setHeight(height);
		obj.setWidth(width);
		return imageView;
	}
}
