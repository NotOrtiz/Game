package Game.SideScrollingZombieShooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;



import javax.swing.JPanel;

import util.Clock;

public class GameRunner extends JPanel {
	
	/**
	 * 
	 */

	private static final long serialVersionUID = -8305054946885253155L;
	public static Player player = new Player("ERROR",0,0);
	Clock gameClock;
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	
	boolean jump = false;
	boolean crouch = false;
	boolean right = false;
	boolean left = false;
	boolean shooting = false;
	
	int mouseX = 0;
	int mouseY = 0;
	
	public GameRunner(Clock c){
		super();
		setFocusable(true);
		gameClock = c;
		addListener();
	}
	
	public GameRunner( Clock c, ArrayList<String> load){
		super();
		
		player.name = load.get(0);
		player.x = Float.parseFloat(load.get(1));
		player.y =  Float.parseFloat(load.get(2));
		byte e = Byte.parseByte(load.get(3));
		addGun(e);
		gameClock = c;
		setFocusable(true);
		addListener();
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
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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

	public void run() {
            gameClock.update();
            this.repaint();
            if(shooting && canShoot())
            	bulletList.add(new Bullet((int)player.x+35,(int)player.y+18,getAngle(),false));
    }
	

	private double getAngle() {
		double pX = player.x+50;
		double pY = player.y+15;
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
				new IGun();
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
			default:
				new IGun();
				break;
		}
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 400,400);
		g.setColor(Color.BLACK);
		player.update(gameClock.getFrameTime());
		player.paintComponent(g);
		for(int temp = 0; temp < bulletList.size(); temp++){
			if(bulletList.get(temp).update(gameClock.getFrameTime()))
				bulletList.get(temp).paintComponent(g);	
			else{
				bulletList.remove(temp);
				if(temp!=bulletList.size()-1)
					temp--;
			}
		}
		run();
	}
	
	public void handlePress(int x){
		switch(x){
			case KeyEvent.VK_A:
				player.left = true;
				break;
			case KeyEvent.VK_S:
				player.crouch = true;
				break;
			case KeyEvent.VK_D:
				player.right = true;
				break;
			case KeyEvent.VK_W:
				player.jump = true;
				break;	
		}
	}
	
	public void handleRelease(int x){
		switch(x){
			case KeyEvent.VK_A:
				player.left = false;
				break;
			case KeyEvent.VK_S:
				player.crouch = false;
				break;
			case KeyEvent.VK_D:
				player.right = false;
				break;
			case KeyEvent.VK_W:
				player.jump = false;
				break;	
		}
	}
}
