package Game.BoxGame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameRunner extends JPanel{
	
	/**
	 * 
	 */

	private static final long serialVersionUID = -8305054946885253155L;
	public Player player;
	
	public GameRunner(){
		super();
		
	}
	
	protected void paintComponent(Graphics g){
		g.setColor(Color.PINK);
		g.fillRect(0, 0, 400,400);
		player.paintComponent(g);
	}
	
}
