package Runner;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.UIManager;

import util.Clock;

import Game.CharCreation;
import Game.LoadPanel;
import Game.PausePanel;
import Game.SideScrollingZombieShooter.Load;
import Game.SideScrollingZombieShooter.Player;
import Game.SideScrollingZombieShooter.GameRunner;

import Menus.MainMenu;
import Menus.OptionPanel;

public class MainFrame extends JFrame implements KeyEventDispatcher{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8583528350760984445L;
	MainMenu panelMainMenu = new MainMenu();
	OptionPanel panelOptions = new OptionPanel();
	LoadPanel panelLoad = new LoadPanel();
	CharCreation panelCharCreation = new CharCreation();
	Clock c = new Clock();
	GameRunner panelGameRunner = new GameRunner(c);

	boolean playing = false;
	boolean paused = false;
	PausePanel panelPause = new PausePanel();
	
	public MainFrame(){
		super();
		createAndShowGui();
		add(panelMainMenu);
	    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
	    manager.addKeyEventDispatcher(this);
		buttonListeners();
	}
	
	private void buttonListeners() {
		
		panelOptions.buttonBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				remove(panelOptions);
				panelMainMenu.setVisible(true);
			}
		});
		
		panelMainMenu.buttonOptions.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				panelMainMenu.setVisible(false);
				add(panelOptions);
				repaint();
			}
			
		});
		panelMainMenu.buttonStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				panelMainMenu.setVisible(false);
				panelLoad.setVisible(true);
				add(panelLoad);
				repaint();
			}
			
		});
		panelLoad.buttonContinue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {

				try{
					panelLoad.setVisible(false);
					ArrayList<String> save = new Load().loadGame();
					panelGameRunner = new GameRunner(c,save);	
					playing = true;
					add(panelGameRunner);
				}catch(Exception e){panelLoad.setVisible(true);}


			}
			
		});
		panelLoad.buttonNew.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				panelLoad.setVisible(false);
				panelCharCreation.setVisible(true);
				add(panelCharCreation);
				repaint();
			}
			
		});
		panelLoad.buttonBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				remove(panelLoad);
				panelMainMenu.setVisible(true);
				repaint();
			}
			
		});
		panelCharCreation.buttonStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				if(panelCharCreation.fieldName.getText().equals("")){
					
				}
				else{
					double startTime = c.getElapsedTime();
					panelCharCreation.setVisible(false);
					Player p = new Player(panelCharCreation.fieldName.getText(),0,325);
					panelGameRunner = new GameRunner(c);
					GameRunner.player = p;
					playing = true;
					panelCharCreation.fieldName.setText("");
					c.update();
					System.out.println(c.getElapsedTime()-startTime);
					add(panelGameRunner);

				}

			}
			
		});	
		panelPause.buttonSaveAndExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				remove(panelPause);
				remove(panelGameRunner);
				panelGameRunner.saveGame();
				playing = false;
				paused = false;
				panelGameRunner = new GameRunner(c);
				add(panelMainMenu);
				panelMainMenu.setVisible(true);
			}
			
		});	
	}

	private void createAndShowGui() {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400,400);
		try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public boolean dispatchKeyEvent(KeyEvent e) {
    	if(playing){
            if (e.getID() == KeyEvent.KEY_PRESSED) {
            	if(e.getKeyCode() == KeyEvent.VK_ESCAPE && !paused){
            		paused = true;
            		panelGameRunner.setVisible(false);
            		add(panelPause);
            	}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE && paused){
            		paused = false;
            		remove(panelPause);
            		panelGameRunner.setVisible(true);
            	}
            	else if(!paused){
            		switch(e.getKeyCode()){
	        			case KeyEvent.VK_A:
	        				GameRunner.player.left = true;
	        				break;
	        			case KeyEvent.VK_S:
	        				GameRunner.player.crouch = true;
	        				break;
	        			case KeyEvent.VK_D:
	        				GameRunner.player.right = true;
	        				break;
	        			case KeyEvent.VK_W:
	        				GameRunner.player.jump = true;
	        				break;	
	        			case KeyEvent.VK_B:
	        				GameRunner.changeweapon = true;
	        				break;
            		}
            	}
            }
            if (e.getID() == KeyEvent.KEY_RELEASED) {
            	if(!paused)
            		switch(e.getKeyCode()){
	        			case KeyEvent.VK_A:
	        				GameRunner.player.left = false;
	        				break;
	        			case KeyEvent.VK_S:
	        				GameRunner.player.crouch = false;
	        				break;
	        			case KeyEvent.VK_D:
	        				GameRunner.player.right = false;
	        				break;
	        			case KeyEvent.VK_W:
	        				GameRunner.player.jump = false;
	        				break;	
            		}
            }		
    	}

        return false;
    }


}

