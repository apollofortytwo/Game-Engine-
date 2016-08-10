package framework;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyInputs implements KeyListener {

	private ArrayList<GameObject> objectList;
	public KeyInputs(ArrayList<GameObject> objectList){
		this.objectList = objectList;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		for(GameObject temp: objectList){
			if(temp.getId() == ObjectId.Player){
				if(code == KeyEvent.VK_W) temp.setyVelocity(-5);
				if(code == KeyEvent.VK_S) temp.setyVelocity(5);
				if(code == KeyEvent.VK_A) temp.setxVelocity(-5);
				if(code == KeyEvent.VK_D) temp.setxVelocity(5);
				return;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		for(GameObject temp: objectList){
			if(temp.getId() == ObjectId.Player){
				if(code == KeyEvent.VK_W) temp.setyVelocity(0);
				if(code == KeyEvent.VK_S) temp.setyVelocity(0);
				if(code == KeyEvent.VK_A) temp.setxVelocity(0);
				if(code == KeyEvent.VK_D) temp.setxVelocity(0);
				return;
			}
		}
	}

}
