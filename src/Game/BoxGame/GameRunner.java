package Game.BoxGame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import util.Clock;

public class GameRunner extends JPanel{
	
	/**
	 * 
	 */

	private static final long serialVersionUID = -8305054946885253155L;
	public static Player player = new Player("ERROR",0,0);
	Clock gameClock = new Clock();
	Bullet b;
	
	public GameRunner(){
		super();
		b = new Bullet(0, 0, 30, false);
		run();
	}
	
    public void run() {
    	while(true)
    	{
    		paintComponent(getGraphics());
        	gameClock.update();
    	}
    }
	

	public void addGun(int i){
		switch(i){
			case 1:
				new GunNormal();
				break;
			case 2:
				new GunMachine();
				break;
			case 3:
				new GunRocket();
				break;
			case 4:
				new GunGod();
				break;
		}
	}

	
	public void paintComponent(Graphics g){
		g.setColor(Color.PINK);
		g.fillRect(0, 0, 400,400);
		player.paintComponent(g);
		b.update(gameClock.getFrameTime());
		b.paintComponent(g);
	}
}
