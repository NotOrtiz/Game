package entity;

import java.awt.Color;
import java.awt.Graphics;

import main.InputHandler;

public class Player extends Entity{
	private InputHandler input;
	private final String name;
	
	int x = 0;
	int y = 0;
	
	public Player(String name, InputHandler input){
		this.name = name;
		this.input = input;
	}
	
	public void tick(){
		if(input.down.down) y+=2;
		if(input.up.down) y-=2;
		if(input.right.down) x+=2;
		if(input.left.down) x-=2;
	}

	public void render(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(x, y, 50, 50);
	}
	
	
}
