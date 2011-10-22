package Game.SideScrollingZombieShooter;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;



import javax.swing.JPanel;

import ImageLoading.Loader;

import util.Clock;

public class GameRunner extends JPanel {
	
	/**
	 * 
	 */

	private static final long serialVersionUID = -8305054946885253155L;
	public static Player player = new Player("ERROR",0,0);
	Image Background;
	Clock gameClock;
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	ArrayList<Enemy> e = new ArrayList<Enemy>();
	boolean jump = false;
	boolean crouch = false;
	boolean right = false;
	boolean left = false;
	boolean shooting = false;
	
	int mouseX = 0;
	int mouseY = 0;
	
	public GameRunner(Clock c){
		super();
		Background = new Loader().getPicture("images/Background.png");
		setFocusable(true);
		gameClock = c;
		gameClock.reset();
		addListener();
	}
	
	public GameRunner( Clock c, ArrayList<String> load){
		super();
		Background = new Loader().getPicture("images/Background.png");
		loadGame(load);
		gameClock = c;
		gameClock.reset();
		setFocusable(true);
		addListener();
	}
	
    private void loadGame(ArrayList<String> load) {
		player.name = load.get(0);
		player.x = Float.parseFloat(load.get(1));
		player.y =  Float.parseFloat(load.get(2));
		byte e = Byte.parseByte(load.get(3));
		addGun(e);
		int x = Integer.parseInt(load.get(4));
		for(int i = 5; i < x+5;i+=4){
			bulletList.add(new Bullet((int)Double.parseDouble(load.get(i)),(int)Double.parseDouble(load.get(i+1)),Double.parseDouble(load.get(i+2)),Boolean.parseBoolean(load.get(i+3))));
		}
	}

	private void addListener() {
    	addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent arg0) {
				if(shooting){
					mouseX = arg0.getX();
					mouseY = arg0.getY();					
				}

				
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				if(shooting){
					mouseX = arg0.getX();
					mouseY = arg0.getY();				
				}

				
			}

    		
    	});
    	
    	addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				if(arg0.getButton() == 1){
					shooting = true;
					mouseX = arg0.getX();
					mouseY = arg0.getY();					
				}

				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(arg0.getButton() == 1){
					shooting = false;					
				}
				
			}
    		
    	});
	}
    
    public void saveGame(){
    	new Save().newSave(player,e,bulletList);
    }

	public void run() {
            gameClock.update();
            this.repaint();
            if(shooting && canShoot())
            	bulletList.add(new Bullet((int)player.x+35,(int)player.y+18,getAngle(),false));			

    }
	

	private double getAngle() {
		double pX = player.x+35;
		double pY = player.y+18;
		int xD = (int) (mouseX - pX);
		int yD = (int) (mouseY - pY);
		return Math.atan2(yD,xD);
	}
	
	private boolean canShoot() {
		return true;
	}

	public void addGun(int i){
		switch(i){
			case 1:
				new GunGod();
				break;
			case 2:
				new GunMachine();
				break;
			case 3:
				new GunRocket();
				break;
			default:
				new GunGod();
				break;
		}
	}
	
	public void paintComponent(Graphics g){
			g.drawImage(Background,0,0,null);
			player.update(gameClock.getFrameTime());
			player.paintComponent(g);
			for(int temp = 0; temp < bulletList.size(); temp++){
				if(bulletList.get(temp).update(gameClock.getFrameTime())){
					bulletList.get(temp).paintComponent(g);	
				}
				else{
					bulletList.remove(temp);
					
					if(temp!=bulletList.size()-1)
						temp--;
				}
			}
			run();	
			

	}
}
