package Game.BoxGame;

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
	
	void update(){
		System.out.println("Updated");
		if(right)
			x++;
		if(left)
			x--;
		if(jump)
			y++;
		if(crouch)
			y--;
	}
	
	public void setImage(Image i){
		playerPic = i;
	}
}