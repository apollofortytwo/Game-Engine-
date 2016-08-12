package windows;

import objects.GameObject;

public class Camera {
	private int xPosition, yPosition;
	
	public Camera(int x, int y){
		xPosition = x;
		yPosition = y;
	}
	
	public void tick(GameObject player){
		xPosition = player.getxPosition() - Game.WIDTH/(Game.WIDTH* 2/Game.HEIGHT)/2;
		yPosition = player.getyPosition() - Game.HEIGHT/(Game.WIDTH* 2/Game.HEIGHT)/2;
		
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
}
