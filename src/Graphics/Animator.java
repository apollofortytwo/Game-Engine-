package Graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import objects.GameObject;

public class Animator {
	private GameObject object;
	private boolean running = false;
	private ArrayList<BufferedImage> currentAnimation;
	private int index;

	public Animator(GameObject ob) {
		object = ob;
	}

	public void loadAnimation(ArrayList<BufferedImage> animation) {
		currentAnimation = animation;
		index = 0;
	}

	public void render(Graphics g) {
		BufferedImage temp;
		if (currentAnimation != null) {
			if (running) {
				if (index > currentAnimation.size())
					index = 0;
				temp = currentAnimation.get(index);
			} else {
				temp = currentAnimation.get(0);

			}
			g.drawImage(temp, object.getxPosition(), object.getyPosition(), null);
		}

	}

	public void start() {
		running = true;
	}

	public void stop() {
		running = false;
	}
}
