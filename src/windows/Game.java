package windows;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import Graphics.LevelLoader;
import framework.KeyInputs;
import objects.GameObject;
import objects.ObjectId;
import objects.Player;
import tools.BufferedImageLoader;
import tools.TMXLoader;
import tools.XMLReader;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {

	public static int WIDTH, HEIGHT;
	private boolean running = false;
	private Thread thread;
	

	ObjectHandler handler;
	Camera cam;
	
	public void run() {
		init();
		this.requestFocus();

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}

	private void render() {
		WIDTH = this.getWidth();
		HEIGHT = this.getHeight();
		
		BufferStrategy bs = this.getBufferStrategy(); // gets the buffer
														// strategy from canvas
		if (bs == null) { // if canvas doesn't have a buffer strategy
			this.createBufferStrategy(3); // make buffer strategy for canvas
			return; // try again
		}

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		////////// Draw here
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g2d.scale(WIDTH * 2/HEIGHT, WIDTH * 2/HEIGHT);
		g2d.translate(-cam.getxPosition(), -cam.getyPosition());

		handler.render(g2d);
		
		
		g2d.translate(cam.getxPosition(), cam.getyPosition());
		//////////
		
		g.dispose();
		g2d.dispose();

		bs.show();

	}

	private void tick() {
		handler.tick();
		
		for(GameObject temp: handler.getObjectList()){
			if(temp.getId().equals(ObjectId.Player)){
				cam.tick(temp);
			}
		}
	}

	private void init() {
		WIDTH = this.getWidth();
		HEIGHT = this.getHeight();
		
		
		cam = new Camera(0, 0);
		
		handler = new ObjectHandler();
		
		this.addKeyListener(new KeyInputs(handler.getObjectList()));
		
		TMXLoader tmxLoader = new TMXLoader("/level.tmx");
		
		LevelLoader levelLoader = new LevelLoader(tmxLoader,handler);
		
		levelLoader.loadLevel();
		
		
		
	}

	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();

	}

	public static void main(String args[]) {
		new Window(1200, 800, "Game", new Game());

	}

}
