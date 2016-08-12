package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Graphics.Sprite;

public abstract class GameObject {
	protected int xPosition, yPosition;
	protected int xVelocity, yVelocity;
	protected int width, height;
	protected ObjectId id;
	protected Sprite sprite;

	protected GameObject(int xPosition, int yPosition, ObjectId id) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.width = id.getWidth();
		this.height = id.getHeight();
		this.id = id;
		sprite = new Sprite(this);
	}

	protected Rectangle getTopBounds() {
		return new Rectangle(xPosition + (width / 4), yPosition, width / 2, height / 2);
	}

	protected Rectangle getBottomBounds() {
		return new Rectangle(xPosition + (width / 4), yPosition + (height / 2), width / 2, height / 2);
	}

	protected Rectangle getLeftBounds() {
		return new Rectangle(xPosition, yPosition + (height * 1 / 8), width / 4, height * 3 / 4);
	}

	protected Rectangle getRightBounds() {
		return new Rectangle(xPosition + (width) - (width / 4), yPosition + (height * 1 / 8), width / 4,
				height * 3 / 4);
	}

	public int getWidth() {
		return width;
	}

	public Rectangle getBounds() {
		return new Rectangle(xPosition, yPosition, width, height);
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public abstract void render(Graphics g);

	public int getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(int yVelocity) {
		this.yVelocity = yVelocity;
	}

	public int getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public abstract void tick(ArrayList<GameObject> objectList);

}
