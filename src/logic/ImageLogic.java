package logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sceneObject.SolidObject;

public class ImageLogic {
	
	public static void resizeAndsetSprite(SolidObject obj, Image image, double width, double height) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(height);
		imageView.setFitWidth(width);
		obj.setHeight(height);
		obj.setWidth(width);
		obj.setSprite(image);
	}
	
	public static Image resizeImage(SolidObject obj, Image image, double width, double height){
		Image newImage = new Image(image.getUrl(), width, height, false, false);
		obj.setHeight(height);
		obj.setWidth(width);
		return newImage;
	}
	
	public static Image resizeImage(Image image, double width, double height){
		System.out.println(image.getUrl());
		return new Image(image.getUrl(), width, height, false, false);
	}
}
