package Game.SideScrollingZombieShooter;

import java.awt.Image;

import ImageLoading.Loader;

public class IGun {
	Loader imageLoader = new Loader();
	
	public IGun(){
		setPlayerImage("charDefault.png");
	}
	
	public void setPlayerImage(String src){
		Image i = imageLoader.getPlayerPicture(src);
		GameRunner.player.setImage(i);
	}
	
	public String toString(){
		return "I";
	}
	
	public int paintX = 35;
	public int paintY = 18;
	
	public int damagePerShot;
	public int shotsPerSecond;
	
}
