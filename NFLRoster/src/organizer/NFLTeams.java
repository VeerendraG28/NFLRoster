package organizer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class NFLTeams extends Canvas implements Runnable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -5318444148007442475L;
	
	/**
	 * Sets the dimension for the window
	 */
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
		
	public NFLTeams() {
				
		new Window(WIDTH, HEIGHT, "Welcome to CraneDrop!", this);
						
	}

	public synchronized void start() {
		thread = new Thread(this); //declares the thread
		thread.start(); 
		running = true; //declares the gamme as running
	}
	
	public synchronized void stop() {
		try {
			thread.join(); //stopping and killing the thread
			running = false;
		}
		catch(Exception e) {
			e.printStackTrace(); //printing error 
		}
	}
	
	public void run() {
		//popular game loop
		
		long lastTime = System.nanoTime(); //gets the time in nanoseconds
		double amountOfTicks = 60.0; //sets the ticks per frame
		double ns = 1000000000 / amountOfTicks; //divide by amount of ticks to track how many seconds have passed
		double delta = 0; //time since the game last updated
		long timer = System.currentTimeMillis(); //timer to track in milli-seconds
		int frames = 0; //number of frames per seconds being processed
		
		while(running){ //while the game is running
			long now = System.nanoTime(); //number of milliseconds within the loop
			delta += (now - lastTime) / ns; //gets the number of seconds
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			
			if(running) { // if the game is running, render images and add one to frames
				render();
				frames++;
			}
			
			if(System.currentTimeMillis() - timer > 1000) { //if the gap between the timer variable is less than 1000 milliseconds
				timer += 1000; //add 1000 to timer
				System.out.println("FPS: " + frames); //gets the FPS of the game
				frames = 0; //recalculate
			}
		}
		
		stop();
		
	}
		
	private void render() {
		BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null) {
			this.createBufferStrategy(3); //creates 3 buffers within the game
			return;
		}
		
		Graphics graphic = buffer.getDrawGraphics(); //leads to flashing lights until added the color
		graphic.setColor(Color.black); //fills the window with the color black
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
				
		graphic.dispose();
		buffer.show();
		
	}

	private void tick() {
		
	}

	public static void main(String[] args) {
		new NFLTeams();
	}
}
