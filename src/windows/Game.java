package windows;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import framework.KeyInputs;
import framework.ObjectId;
import objects.Block;
import objects.Player;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {

	public static int WIDTH, HEIGHT;
	private boolean running = false;
	private Thread thread;

	ObjectHandler handler;

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
		BufferStrategy bs = this.getBufferStrategy(); // gets the buffer
														// strategy from canvas
		if (bs == null) { // if canvas doesn't have a buffer strategy
			this.createBufferStrategy(3); // make buffer strategy for canvas
			return; // try again
		}

		Graphics g = bs.getDrawGraphics();
		////////// Draw here
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);
		//////////
		g.dispose();

		bs.show();

	}

	private void tick() {
		handler.tick();
	}

	private void init() {
		WIDTH = this.getWidth();
		HEIGHT = this.getHeight();
		
		handler = new ObjectHandler();
		handler.addObject(new Player(0, 0, ObjectId.Player));
		handler.addObject(new Block(100,100,ObjectId.Block));
		
		this.addKeyListener(new KeyInputs(handler.getObjectList()));
		
	}

	public synchronized void start() {

		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();

	}

	public static void main(String args[]) {
		new Window(800, 600, "Game", new Game());

	}

}
