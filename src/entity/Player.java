package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import main.InputHandler;

public class Player extends Entity{
	private InputHandler input;
	Random rand = new Random();
	final int middleX, middleY;
	public int x = 20*32;
	public int y = 20*32;
	public Player(int middleX, int middleY, InputHandler input){
		this.input = input;
		this.middleX = middleX;
		this.middleY = middleY;
	}
	
	public void tick(){
		if(input.down.down && y < 118*32+16) y+=3;
		if(input.up.down && y > 5*32+5) y-=3;
		if(input.right.down && x < 118*32+25) x+=3;
		if(input.left.down && x-3 > 6*32+2) x-=3;
	}

	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(middleX, middleY, 32, 32);
	}
}
