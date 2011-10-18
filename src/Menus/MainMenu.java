package Menus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import Game.ConsoleGame;
import ImageLoading.Loader;

public class MainMenu extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8674266367360936532L;
	
	JPanel panelMain = new JPanel();
	JPanel panelButtons;
	JButton buttonStart;
	JButton buttonOptions;
	JButton buttonExit;
	JLabel titleLabel;
	
	ImageIcon imageTitle = new Loader().getTitlePicture();
	/*Crap with gui*/
	GridBagConstraints c = new GridBagConstraints();
	TitledBorder borderButtons = BorderFactory.createTitledBorder("CHOOSE");
	TitledBorder borderMain = BorderFactory.createTitledBorder("Main Menu");
	OptionPanel panelOptions = new OptionPanel();
	
	
	public MainMenu(){
		super("Main Menu");
		initComponents();
		addComponents();
		createAndShowGui();
	}

	private void initComponents() {
		buttonStart = new JButton("Start");
		buttonStart.setPreferredSize(new Dimension(75,30));
		buttonStart.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				remove(panelMain);
				repaint();
				new ConsoleGame();
			}
			
		});
		
		buttonOptions = new JButton("Options");
		buttonOptions.setPreferredSize(new Dimension(75,30));
		buttonOptions.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				panelMain.setVisible(false);
				add(panelOptions);
			}
			
		});
		
		buttonExit = new JButton("Exit");
		buttonExit.setPreferredSize(new Dimension(75,30));
		buttonExit.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		titleLabel = new JLabel(imageTitle);
		titleLabel.setPreferredSize(new Dimension(imageTitle.getIconHeight(),imageTitle.getIconWidth()));
		borderButtons.setTitleColor(Color.WHITE);
		addToOptions();
	}

	private void addComponents() {
		panelButtons = new JPanel();
		panelButtons.setBackground(Color.DARK_GRAY);
		panelButtons.setLayout(new GridBagLayout());
		panelButtons.setBorder(borderButtons);
		panelButtons.setPreferredSize(new Dimension(120,200)); 
		
		c.gridy = 0;
		c.weightx = 1.5;
		panelButtons.add(buttonStart,c);
		
		c.gridy = 1;
		c.weightx = 1.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,0,0,0);
		panelButtons.add(buttonOptions,c);
		
		c.gridy = 2;
		c.weightx = 1.5;
		c.insets = new Insets(10,0,0,0);
		panelButtons.add(buttonExit,c);
		
		panelMain.setLayout(new GridBagLayout());
		
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.ipady = 40;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panelMain.add(titleLabel,c);
		
		c.gridy = 2;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(20,0,0,0);
		c.fill = GridBagConstraints.VERTICAL;
		panelMain.add(panelButtons,c);
		
		panelMain.setBackground(Color.DARK_GRAY);
		borderMain.setTitleColor(Color.WHITE);
		panelMain.setBorder(borderMain);
		add(panelMain);
		
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
		setUndecorated(true);
		setVisible(true);
	}
	
	private void addToOptions(){
		panelOptions.buttonBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				remove(panelOptions);
				panelMain.setVisible(true);
			}
		});
	}
}