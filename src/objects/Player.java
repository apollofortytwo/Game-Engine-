package objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Graphics.Animator;

public class Player extends GameObject {

	ArrayList<BufferedImage> walking_left, walking_right, walking_up, walking_down;
	Animator animator;

	public Player(int xPosition, int yPosition, ObjectId id) {
		super(xPosition, yPosition, id);
		animationSetup();
	}

	public void render(Graphics g) {
		animator.render(g);
	}

	private void animationSetup() {
		// walking left
		walking_left = new ArrayList<BufferedImage>();
		walking_left.add(sprite.getImage(0, 2, width, height));
		walking_left.add(sprite.getImage(1, 2, width, height));
		walking_left.add(sprite.getImage(2, 2, width, height));
		

		animator = new Animator(this);
		animator.loadAnimation(walking_left);
		animator.start();

	}

	public void tick(ArrayList<GameObject> objectList) {
		xPosition += xVelocity;
		yPosition += yVelocity;

		collisionDetection(objectList);

	}

	private void collisionDetection(ArrayList<GameObject> objectList) {
		for (GameObject temp : objectList) {
			if (temp.getId().equals(ObjectId.Object)) {
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
