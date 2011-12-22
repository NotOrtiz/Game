package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import main.InputHandler;

public class Player extends Entity {
	private InputHandler input;
	Random rand = new Random();
	final int middleX, middleY;
	public int x = 20 * 32;
	public int y = 20 * 32;

	public Player(int middleX, int middleY, InputHandler input) {
		this.input = input;
		this.middleX = middleX;
		this.middleY = middleY;
	}

	public void tick() {
		if (input.down.down && y < 250 * 32 + 16)
			y += 32;
		if (input.up.down && y > 6 * 32 + 5)
			y -= 32;
		if (input.right.down && x < 255 * 32 + 25)
			x += 32;
		if (input.left.down && x - 3 > 12 * 32 + 2)
			x -= 32;
	}

	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(middleX + 2, middleY + 2, 33, 33);
	}
}
