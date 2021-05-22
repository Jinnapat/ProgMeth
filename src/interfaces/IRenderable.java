package interfaces;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderable {
	public int getZ();
	public void draw(GraphicsContext gc);
}
