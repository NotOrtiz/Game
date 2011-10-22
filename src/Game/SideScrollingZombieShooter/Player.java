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
	public boolean jump = false;
	public boolean crouch = false;
	public boolean right = false;
	public boolean left = false;
	boolean jumpUp = false;
	boolean fallDown = false;
	
	int startY;
	
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
		g.drawString("SSZS 0.00001 Alpha",0,10);
	}
	
	void update(double d){
		if(jumpUp && y > startY-80){
			y-=250*d;
		}
		else if(y <= startY && !fallDown){
			
			fallDown = true;
			jumpUp = false;
		}
		else if(y < 328 & fallDown){
			y+=250*d;
		}
		else if(y > 328){
			fallDown = false;
		}

		if(jump && (!jumpUp&&!fallDown)){
			jumpUp = true;
			jump = false;
			startY = (int) y;
		}	
		if(right)
			x+=100*d;
		if(left)
			x-=100*d;
	}
	
	public void setImage(Image i){
		playerPic = i;
	}
}