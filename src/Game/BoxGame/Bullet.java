package Game.BoxGame;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	double x;
	double y;
	double sv;
	double sh;
	int damage;
	boolean rocket;
	
	public Bullet(int x,int y,double angle,boolean isRocket){
		rocket = isRocket;
		damage = isRocket ? 50 : 3;
		this.x = x;
		this.y = y;
	    sv = Math.sin(angle)*2;
	    sh = Math.cos(angle)*2;
	}
	
	protected void paintComponent(Graphics g){
		g.setColor(Color.RED);
		g.fillOval((int)x, (int)y, 3, 3);
	}
	
	public void update(double d){
	    this.x += this.sh*(d);
	    this.y += this.sv*(d);

	}
	
}