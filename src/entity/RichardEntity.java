package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class RichardEntity extends Entity{
	Random rand;
	int centerX;
	int centerY;
	int rad;
	int x;
	int y;
	float angle;
	
	public RichardEntity(Random rand){
		this.rand = rand;
		centerX = rand.nextInt(400);
		centerY = rand.nextInt(400);
		angle = rand.nextFloat()*50;
		rad = rand.nextInt(50)+20;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 15, 15);
		g.setColor(Color.BLACK);
		g.drawString(Integer.toString(rad),x,y+10);
	}
	
	public void tick() {
		moveInACircle();
	}

	private void moveInACircle() {
	    x = centerX + (int)(rad * Math.cos(angle));
	    y = centerY + (int)(rad * Math.sin(angle));
	    angle+=(1.0/60);
	}
	
}
