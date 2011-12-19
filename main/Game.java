package main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import map.Map;

import entity.Player;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = -2476914045089723281L;
	private static final int SCALE = 3;
	private static final String NAME = "Game";
	public static final int HEIGHT = 120;
	public static final int WIDTH = 160;
	
	private InputHandler input = new InputHandler(this);
	public Player player = new Player("Andrew", input);
	public Map level = new Map(128,128);
	
	public final ImageIcon Background;
	
	boolean running = false;
	
	public Game(){
		Background = level.getMapImage();
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double unprocessed = 0;
		double nanosecondsPerTick = 1000000000.0 / 60;
		int frames = 0;
		int ticks = 0;
		long lastTimer1 = System.currentTimeMillis();

		init();

		while (running) {
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nanosecondsPerTick;
			lastTime = now;
			boolean shouldRender = false;
			while (unprocessed >= 1) {
				ticks++;
				tick();
				unprocessed -= 1;
				if(frames < 60) shouldRender = true;
			}
			if (shouldRender) {
				frames++;
				render();
			}
				
			if (System.currentTimeMillis() - lastTimer1 >= 1000) {
				lastTimer1 += 1000;
				System.out.println(ticks + " ticks, " + frames + " fps");
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	private void tick() {
		player.tick();
	}

	private void init() {
		
	}

	public void start() {
		running = true;
		new Thread(this).start();
	}

	public void stop() {
		running = false;
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			requestFocus();
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(Background.getImage(), 0, 0, null);
		player.render(g);
		g.dispose();
		bs.show();
	}
	public static void main(String[] args){
		Game game = new Game();
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(Game.NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(game, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}

}
