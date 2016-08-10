package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import framework.GameObject;
import framework.ObjectId;

public class Block extends GameObject {
	
	public Block(int xPosition, int yPosition, ObjectId id){
		super(xPosition, yPosition, id);
		width = 32;
		height = 32;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawRect(xPosition, yPosition, width, height);
	}

	@Override
	public void tick(ArrayList<GameObject> objectList) {


	}

}
