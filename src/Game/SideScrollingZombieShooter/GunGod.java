package Game.SideScrollingZombieShooter;

import ImageLoading.Loader;
import Game.SideScrollingZombieShooter.GameRunner;

public class GunGod {
	
	public GunGod(){
		setPlayerImage("images/charDefault.png");
	}
	
	public void setPlayerImage(String src){
		GameRunner.player.playerPic = new Loader().getPicture(src);
	}
	
	public String toString(){
		return "4";
	}
	
	public boolean canShoot(){
		return true;
	}
	
	public int angleX = 35;
	public int angleY = 18;
	
	public int damagePerShot = 3;
	public int shotsPerSecond = 6000;
	
}
