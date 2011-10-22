package Game.SideScrollingZombieShooter;

import java.awt.Image;

import ImageLoading.Loader;

public class GunGod {
	
	public GunGod(){
		//setPlayerImage("image/charDefault.png");
	}
	
	public void setPlayerImage(String src){
		Image i = new Loader().getPicture("images/charDefault.png");
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
