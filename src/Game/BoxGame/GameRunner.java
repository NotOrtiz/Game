package Game.BoxGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;



import javax.swing.JPanel;

import util.Clock;

public class GameRunner extends JPanel{
	
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
	
	public GameRunner(Clock c){
		super();
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
		addListener();
	}
	
    private void addListener() {
    	//requestFocus();
    	super.setFocusable(true);
    	super.grabFocus();
    	
		addKeyListener(new KeyListener(){
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println("Pressed");
				switch(arg0.getKeyCode()){
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
				player.update();
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				System.out.println("Released");
				switch(arg0.getKeyCode()){
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
				player.update();
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				System.out.println("Typed");
			}
			
		});
    	addMouseListener(new MouseListener(){
    		/*ignore*/
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println("HI");
			}
			/*ignore*/
			@Override
			public void mouseEntered(MouseEvent arg0) {
				//System.out.println("HI");
			}
			/*ignore*/			
			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				if(arg0.getButton() == 1)
					shooting = true;
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(arg0.getButton() == 1)
					shooting = false;
			}
    		
    	});
	}

	public void run() {
            gameClock.update();
            this.repaint();
            if(shooting)
            	bulletList.add(new Bullet(200,200,30,false));
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
		g.setColor(Color.PINK);
		g.fillRect(0, 0, 400,400);
		player.paintComponent(g);
		for(Bullet b: bulletList){
			b.update(gameClock.getFrameTime());
			b.paintComponent(g);			
		}
		run();
	}
}
