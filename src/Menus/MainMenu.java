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
import javax.swing.border.TitledBorder;

import ImageLoading.Loader;

public class MainMenu extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8674266367360936532L;
	// Get the size of the screen

	
	JPanel panelButtons;
	public JButton buttonStart;
	public JButton buttonOptions;
	JButton buttonExit;
	JLabel titleLabel;
	
	ImageIcon TitlePicture = new Loader().getTitlePicture();
	/*Crap with gui*/
	GridBagConstraints c = new GridBagConstraints();
	TitledBorder borderButtons = BorderFactory.createTitledBorder("CHOOSE");
	TitledBorder borderMain = BorderFactory.createTitledBorder("Main Menu");
	
	
	public MainMenu(){
		super();
		createPanel();
		initComponents();
		addComponents();
	}

	private void createPanel() {
		setPreferredSize(new Dimension(400,400)); 
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		borderMain.setTitleColor(Color.WHITE);
		setBorder(borderMain);
		
	}

	private void initComponents() {
		buttonStart = new JButton("Start");
		buttonStart.setPreferredSize(new Dimension(75,30));
		
		buttonOptions = new JButton("Options");
		buttonOptions.setPreferredSize(new Dimension(75,30));
		
		buttonExit = new JButton("Exit");
		buttonExit.setPreferredSize(new Dimension(75,30));
		buttonExit.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		
		titleLabel = new JLabel(TitlePicture);
		titleLabel.setPreferredSize(new Dimension(TitlePicture.getIconHeight(),TitlePicture.getIconWidth()));
		borderButtons.setTitleColor(Color.WHITE);
	}

	private void addComponents() {
		panelButtons = new JPanel();
		panelButtons.setBackground(Color.DARK_GRAY);
		panelButtons.setLayout(new GridBagLayout());
		panelButtons.setBorder(borderButtons);
		panelButtons.setPreferredSize(new Dimension(250,100)); 
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 0;
		c.weightx = 1.5;
		panelButtons.add(buttonStart,c);
		
		c.gridy = 1;
		c.weightx = 1.5;
		c.insets = new Insets(12,0,0,0);
		panelButtons.add(buttonOptions,c);
		
		c.gridy = 2;
		c.weightx = 1.5;
		c.insets = new Insets(12,0,0,0);
		panelButtons.add(buttonExit,c);
		
		c.ipady = 40;
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 1;
		c.weighty = 1.2;
		add(titleLabel,c);
		
		c.weighty = 0;
		c.gridy = 2;
		c.insets = new Insets(0,0,0,0);
		add(panelButtons,c);

		
	}
}