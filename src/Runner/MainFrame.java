package Runner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;

import Game.CharCreation;
import Game.LoadPanel;
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
	GameRunner panelGameRunner = new GameRunner();
	CharCreation panelCharCreation = new CharCreation();
	
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
				panelCharCreation.setVisible(false);
				if(panelCharCreation.fieldName.getText().equals("")){
					
				}
				else{
					Player p = new Player(panelCharCreation.fieldName.getText(),25,25);
					panelCharCreation.setVisible(false);
					panelGameRunner.player = p;
					add(panelGameRunner);
				}
				add(panelGameRunner);
				repaint();
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
