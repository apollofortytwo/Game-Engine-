package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

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
		g.fillRect(xPosition, yPosition, width, height);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.red);
		g2d.draw(getTopBounds());
		g2d.draw(getBottomBounds());
		g2d.draw(getLeftBounds());
		g2d.draw(getRightBounds());
	}

	private Rectangle getTopBounds() {
		return new Rectangle(xPosition + (width / 4), yPosition, width / 2, height / 2);
	}

	private Rectangle getBottomBounds() {
		return new Rectangle(xPosition + (width / 4), yPosition + (height / 2), width / 2, height / 2);
	}

	private Rectangle getLeftBounds() {
		return new Rectangle(xPosition, yPosition + (height * 1 / 8), width / 4, height * 3 / 4);
	}

	private Rectangle getRightBounds() {
		return new Rectangle(xPosition + (width) - (width / 4), yPosition + (height * 1 / 8), width / 4,
				height * 3 / 4);
	}

	public void tick(ArrayList<GameObject> objectList) {
		xPosition += xVelocity;
		yPosition += yVelocity;

		collisionDetection(objectList);

	}

	private void collisionDetection(ArrayList<GameObject> objectList) {
		for (GameObject temp : objectList) {
			if (temp.getId().equals(ObjectId.Block)) {
				if (getBottomBounds().intersects(temp.getBounds())) {
					setyPosition(temp.getyPosition() - getHeight());
				}
				if (getTopBounds().intersects(temp.getBounds())) {
					setyPosition(temp.getyPosition() + temp.getHeight());
				}
				if (getLeftBounds().intersects(temp.getBounds())) {
					setxPosition(temp.getxPosition() + temp.getWidth());
				}
				if (getRightBounds().intersects(temp.getBounds())) {
					setxPosition(temp.getxPosition() - getWidth());
				}
			}
		}
	}

}
