package objects;

import java.awt.Color;
import java.awt.Graphics;

import framework.GameObject;
import framework.ObjectId;

public class Player extends GameObject {
	
	public Player(int xPosition, int yPosition, ObjectId id) {
		super(xPosition, yPosition, id);
		width = 32;
		height = 32;
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect(xPosition, yPosition, width, height);
		
	}

	public void tick() {
		xPosition += xVelocity;
		yPosition += yVelocity;
		
		
		
	}

}
