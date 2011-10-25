package Game.SideScrollingZombieShooter;

public class GunNormal extends GunGod{
	GunNormal(){
		super.shotsPerSecond = 25;
		super.angleX = 38;
		super.angleY = 15;
		setPlayerImage("images/temp.png");
	}
	
	public boolean canShoot(){
		return true;
	}
	public String toString(){
		return "1";
	}

}
