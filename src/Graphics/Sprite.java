package Graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import objects.GameObject;
import tools.BufferedImageLoader;

public class Sprite {

	private BufferedImage spriteSheet;
	private ArrayList<BufferedImage> imageArrayList;

	public Sprite(GameObject object) {
		BufferedImageLoader loader = new BufferedImageLoader();
		spriteSheet = loader.loadImage(object.getId().getSpriteSheetPath());
		setImageArrayList(getImageArrayList(object.getWidth(), object.getHeight()));
	}

	public BufferedImage getImage(int col, int row, int width, int height) {
		BufferedImage image = spriteSheet.getSubimage(col * height, row * width, width, height);
		return image;
	}

	private ArrayList<BufferedImage> getImageArrayList(int width, int height) {
		ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>();
		for (int y = 0; y * height < spriteSheet.getHeight(); y++) {
			for (int x = 0; x * width < spriteSheet.getWidth(); x++) {
				imageList.add(this.getImage(x, y, width, height));
			}
		}
		return imageList;
	}

	public BufferedImage getSpriteSheet() {
		return spriteSheet;
	}

	public void setSpriteSheet(BufferedImage spriteSheet) {
		this.spriteSheet = spriteSheet;
	}

	public ArrayList<BufferedImage> getImageArrayList() {
		return imageArrayList;
	}

	public void setImageArrayList(ArrayList<BufferedImage> imageArrayList) {
		this.imageArrayList = imageArrayList;
	}

}
