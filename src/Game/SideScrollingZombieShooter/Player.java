package Game.SideScrollingZombieShooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import ImageLoading.Loader;

public class Player
{
	public String name;
	Image playerPic;
	float x;
	float y;
	String gunName = "1";
	boolean jump = false;
	boolean crouch = false;
	boolean right = false;
	boolean left = false;
	
	public Player(String name, float x, float y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		playerPic = new Loader().getPlayerPicture();
	}
	
	
	protected void paintComponent(Graphics g){
		g.drawImage(playerPic, (int)x, (int)y, null);
		g.setColor(Color.BLACK);
		g.drawString(name,25,20);
	}
	
	void update(double d){
		if(right)
			x+=100*d;
		if(left)
			x-=100*d;
		if(jump)
			y-=100*d;
		if(crouch)
			y+=100*d;
	}
	
	public void setImage(Image i){
		playerPic = i;
	}
}