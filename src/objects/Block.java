package objects;

import java.awt.Graphics;
import java.util.ArrayList;

import Graphics.Sprite;

public class Block extends GameObject {
	int index;

	public Block(int xPosition, int yPosition, ObjectId id, int index) {
		super(xPosition, yPosition, id);
		this.index = index;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(this.sprite.getImageArrayList().get(index), xPosition, yPosition, null);

	}

	@Override
	public void tick(ArrayList<GameObject> objectList) {

	}

}
