package Graphics;

import objects.Block;
import objects.ObjectId;
import objects.Player;
import tools.TMXLoader;
import windows.ObjectHandler;

public class LevelLoader {
	TMXLoader loader;

	ObjectHandler handler;

	public LevelLoader(TMXLoader loader, ObjectHandler handler) {
		this.loader = loader;
		this.handler = handler;

	}

	public void loadLevel() {
		loadFloor();
		loadObjects();
		loadPlayer();
		
		
	}
	
	public void loadPlayer() {
		for (int x = 0; x < loader.getColCount(); x++) {
			for (int y = 0; y < loader.getRowCount(); y++) {
				int index = loader.getPlayerStartLocation()[x][y];
				if (index != 0) {
					handler.addObject(new Player(y * loader.getTileWidth(), x * loader.getTileHeight(), ObjectId.Player));
				}

			}
		}
	}
	
	public void loadFloor() {
		for (int x = 0; x < loader.getColCount(); x++) {
			for (int y = 0; y < loader.getRowCount(); y++) {
				int index = loader.getFloor()[x][y];
				if (index != 0) {
					handler.addObject(new Block(y * loader.getTileWidth(), x * loader.getTileHeight(), ObjectId.Floor, index - 1));
				}

			}
		}
	}

	public void loadObjects() {
		for (int x = 0; x < loader.getColCount(); x++) {
			for (int y = 0; y < loader.getRowCount(); y++) {
				int index = loader.getObjects()[x][y];
				if (index != 0) {
					handler.addObject(new Block(y * loader.getTileWidth(), x * loader.getTileHeight(), ObjectId.Object, index - 1));
				}

			}
		}
	}


}
