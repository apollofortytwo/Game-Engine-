package objects;

import Graphics.Sprite;

public enum ObjectId {
	Player("/player.png", 32, 32),
	Floor("/tileset.png", 32, 32),
	Object("/tileset.png", 32, 32);
	
	private String spriteSheetPath;
	private int width, height;
	
	private ObjectId(String spriteSheetPath, int width, int height){
		this.spriteSheetPath = spriteSheetPath;
		this.setWidth(width);
		this.setHeight(height);
	}

	public String getSpriteSheetPath() {
		return spriteSheetPath;
	}

	public void setSpriteSheetPath(String spriteSheetPath) {
		this.spriteSheetPath = spriteSheetPath;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight(){
		return this.height;
	}



}
