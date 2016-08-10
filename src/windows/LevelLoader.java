package windows;

import java.awt.image.BufferedImage;

import framework.ObjectId;
import objects.Block;
import objects.Player;

public class LevelLoader {
	int width, height;

	public LevelLoader(BufferedImage image, ObjectHandler handler) {
		width = image.getWidth();
		height = image.getHeight();
		for(int x = 0; x < width; x++){ //loops through each pixel
			for(int y = 0; y < height; y++){
				int pixel = image.getRGB(x, y);
				System.out.println(pixel);
				//Some Binary shit
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 255 && green == 255 & blue == 255){ //white pixel
					handler.addObject(new Block(x*32, y*32, ObjectId.Block));
				}
				if(red == 255 && green == 0 & blue == 0){
					System.out.println("player found");
					handler.addObject(new Player(x*32,y*32,ObjectId.Player));
				}
			}
		}
	}
}
