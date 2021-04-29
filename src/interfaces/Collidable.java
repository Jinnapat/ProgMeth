package interfaces;

public interface Collidable {
	
	public abstract void checkCollide();
	
	public abstract void onCollide(Collidable target);
}
