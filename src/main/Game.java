package main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import map.Map;

import entity.Entity;
import entity.Player;
import gfx.SpriteSheet;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = -2476914045089723281L;
	private static final int SCALE = 1;
	private static final String NAME = "Game";
	public static final int HEIGHT = 662;
	public static final int WIDTH = 662;
	public static SpriteSheet sheet;
	static{
		 try {
			 sheet = new SpriteSheet(ImageIO.read((new File("Images/spritesheet.png"))));
			
		} catch (IOException e) {
			try {
				sheet = new SpriteSheet(ImageIO.read(Game.class.getResourceAsStream("Images/spritesheet.png")));
			} catch (IOException e1) {
			}
		}
	}	
	public static Map level = new Map(512,512);


	private InputHandler input = new InputHandler(this);
	public Player player = new Player((int) (0.5 + (WIDTH * SCALE) / 2),
			(int) (0.5 + (HEIGHT * SCALE) / 2), input);
	BufferedImage img;

	Random rand = new Random();
	int ticks;

	ArrayList<Entity> entities = new ArrayList<Entity>();

	public static ImageIcon MiniMap;
	public static ImageIcon Map;

	public static Image miniMap;
	public static Image map;

	boolean running = false;

	public Game() {

	}

	public void run() {
		init();
		long lastTime = System.nanoTime();
		double unprocessed = 0;
		double nanosecondsPerTick = 1000000000.0 / 60;
		int frames = 0;
		ticks = 0;
		long lastTimer1 = System.currentTimeMillis();

		while (running) {
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nanosecondsPerTick;
			lastTime = now;
			boolean shouldRender = false;
			while (unprocessed >= 1) {
				ticks++;
				tick();
				unprocessed -= 1;
				shouldRender = true;
			}

			if (shouldRender) {
				frames++;
				render();
			}

			if (System.currentTimeMillis() - lastTimer1 > 1000) {
				lastTimer1 += 1000;
				System.out.println(ticks + " ticks, " + frames + " fps");
				frames = 0;
				ticks = 0;
			}
		}
	}

	private void tick() {
		player.tick(ticks);
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
		level.render(g, player.x / 32, player.y / 32);
		player.render(g);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		game.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		game.setPreferredSize(new Dimension(WIDTH, HEIGHT));

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
