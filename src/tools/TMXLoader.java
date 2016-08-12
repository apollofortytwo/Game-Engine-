package tools;

import java.util.ArrayList;

public class TMXLoader {
	private String imageSource;
	private int tileWidth, tileHeight;
	private int rowCount, colCount;
	private int[][] floor;
	private int[][] objects;
	private int[][] playerStartLocation;

	public TMXLoader(String path) {
		XMLReader xmlLoader = new XMLReader(path);
		imageSource = xmlLoader.getValueString("image", "source");
		tileWidth = xmlLoader.getValueInt("tileset", "tilewidth");
		tileHeight = xmlLoader.getValueInt("tileset", "tileheight");
		rowCount = xmlLoader.getValueInt("layer", "width");
		colCount = xmlLoader.getValueInt("layer", "height");
		setFloor(xmlLoader.getLayerArray("layer", "floor"));
		setObjects(xmlLoader.getLayerArray("layer", "objects"));
		setPlayerStartLocation(xmlLoader.getLayerArray("layer", "player"));
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getColCount() {
		return colCount;
	}

	public void setColCount(int colCount) {
		this.colCount = colCount;
	}

	public int[][] getFloor() {
		return floor;
	}

	public void setFloor(int[][] floor) {
		this.floor = floor;
	}

	public int[][] getObjects() {
		return objects;
	}

	public void setObjects(int[][] objects) {
		this.objects = objects;
	}

	public int[][] getPlayerStartLocation() {
		return playerStartLocation;
	}

	public void setPlayerStartLocation(int[][] playerStartLocation) {
		this.playerStartLocation = playerStartLocation;
	}

}
