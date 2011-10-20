package Game.BoxGame;

import java.awt.Image;

import ImageLoading.Loader;

public class IGun {
	Loader imageLoader = new Loader();
	
	public IGun(){
		setPlayerImage("test1.png");
	}
	
	public void setPlayerImage(String src){
		Image i = imageLoader.getPlayerPicture(src);
		GameRunner.player.setImage(i);
	}
	
	public int damagePerShot;
	public int shotsPerSecond;
	
}
