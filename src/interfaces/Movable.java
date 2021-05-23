package interfaces;

import exception.PositionException;

public interface Movable {
	void update() throws PositionException;
}
