package framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class GameObject {
	protected int xPosition, yPosition;
	protected int xVelocity, yVelocity;
	protected int width, height;
	protected ObjectId id;
	
	
	protected GameObject(int xPosition, int yPosition, ObjectId id){
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.id = id;
	}
	
	public int getWidth() {
		return width;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(xPosition,yPosition,width,height);
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
