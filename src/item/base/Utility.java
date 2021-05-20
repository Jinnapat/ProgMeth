package item.base;

import character.Character;
import javafx.scene.canvas.GraphicsContext;
import sceneObject.SolidObject;

public class Utility extends Item{

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		/////////TODO////////////
		gc.drawImage(this.getSprite(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

	@Override
	public boolean isDestroy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onCollide(SolidObject target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collectBy(Character character) {
		// TODO Auto-generated method stub
		
	}
	
}
