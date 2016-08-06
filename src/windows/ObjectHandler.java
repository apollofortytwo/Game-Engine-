package windows;

import java.awt.Graphics;
import java.util.ArrayList;

import framework.GameObject;

public class ObjectHandler {
	private ArrayList<GameObject> objectList = new ArrayList<GameObject>();
	
	public void tick(){
		for(GameObject temp: objectList){
			temp.tick(objectList);
		}
	}
	
	public void render(Graphics g){
		for(GameObject temp: objectList){
			temp.render(g);
		}
	}
	
	public void removeObject(GameObject object){
		objectList.remove(object);
	}
	public void addObject(GameObject object){
		objectList.add(object);
	}

	public ArrayList<GameObject> getObjectList() {
		return objectList;
	}

	public void setObjectList(ArrayList<GameObject> objectList) {
		this.objectList = objectList;
	}
}
