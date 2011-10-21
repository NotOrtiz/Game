package Runner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.UIManager;

import util.Clock;

import Game.CharCreation;
import Game.LoadPanel;
import Game.BoxGame.Load;
import Game.BoxGame.Player;
import Game.BoxGame.GameRunner;
import Menus.MainMenu;
import Menus.OptionPanel;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8583528350760984445L;
	MainMenu m = new MainMenu();
	OptionPanel panelOptions = new OptionPanel();
	LoadPanel panelLoad = new LoadPanel();
	GameRunner panelGameRunner;
	CharCreation panelCharCreation = new CharCreation();
	Clock c = new Clock();
	
	public MainFrame(){
		super();
		createAndShowGui();
		add(m);
		setVisible(true);
		buttonListeners();
	}
	
	private void buttonListeners() {
		
		panelOptions.buttonBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				remove(panelOptions);
				m.setVisible(true);
			}
		});
		
		m.buttonOptions.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				m.setVisible(false);
				add(panelOptions);
				repaint();
			}
			
		});
		m.buttonStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				m.setVisible(false);
				add(panelLoad);
				repaint();
			}
			
		});
		panelLoad.buttonContinue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				panelLoad.setVisible(false);
				ArrayList<String> save = new Load().loadGame();
				panelGameRunner = new GameRunner(c,save);
				add(panelGameRunner);
				repaint();
			}
			
		});
		panelLoad.buttonNew.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				panelLoad.setVisible(false);
				add(panelCharCreation);
				repaint();
			}
			
		});
		panelLoad.buttonBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				remove(panelLoad);
				m.setVisible(true);
				repaint();
			}
			
		});
		panelCharCreation.buttonStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				if(panelCharCreation.fieldName.getText().equals("")){
					
				}
				else{
					panelCharCreation.setVisible(false);
					Player p = new Player(panelCharCreation.fieldName.getText(),25,25);
					GameRunner.player = p;
					panelGameRunner = new GameRunner(c);
					add(panelGameRunner);

				}

			}
			
		});
	}

	private void createAndShowGui() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400,400);
		try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
