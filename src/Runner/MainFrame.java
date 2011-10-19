package Runner;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;

import Menus.MainMenu;
import Menus.OptionPanel;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8583528350760984445L;
	MainMenu m = new MainMenu();
	OptionPanel panelOptions = new OptionPanel();
	// Get the size of the screen
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	 
	// Determine the new location of the window
	int w = getSize().width;
	int h = getSize().height;
	int x = (dim.width-w)/2;
	int y = (dim.height-h)/2;
	
	public MainFrame(){
		super();
		createAndShowGui();
		add(m);
		setUndecorated(true);
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
	}

	private void createAndShowGui() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
