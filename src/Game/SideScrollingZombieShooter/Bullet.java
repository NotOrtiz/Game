package Game.SideScrollingZombieShooter;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	double x;
	double y;
	double sv;
	double sh;
	int damage;
	boolean rocket;
	double angle;
	
	public Bullet(int x,int y,double angle,boolean isRocket){
		rocket = isRocket;
		damage = isRocket ? 50 : 3;
		this.x = x;
		this.y = y;
		this.angle = angle;
	    sv = Math.sin(angle)*2;
	    sh = Math.cos(angle)*2;
	}
	
	protected void paintComponent(Graphics g){
		g.setColor(Color.RED);
		g.fillOval((int)x, (int)y, 5, 5);
	}
	
	public boolean update(double d){
	    this.x += this.sh*(d*75);
	    this.y += this.sv*(d*75);
	    if(x < 0)
	    	return false;
	    if(x > 400)
	    	return false;
	    if(y < 0)
	    	return false;
	    if(y > 400)
	    	return false;
	    return true;
	}
	
	public String toString(){
		return x+" : "+y+" : "+angle;
	}
	
}
