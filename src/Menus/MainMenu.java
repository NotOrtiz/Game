package Menus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import ImageLoading.Loader;

public class MainMenu extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8674266367360936532L;
	
	JPanel panelMain = new JPanel();
	JPanel panelInternal;
	JButton RandomButton;
	Image TitleImage = new Loader().getTitlePicture();
	
	public MainMenu(){
		super("Main Menu");
		initComponents();
		addComponents();
		createAndShowGui();
	}

	private void initComponents() {
		RandomButton = new JButton("hi");
		RandomButton.setPreferredSize(new Dimension(100,35));
		RandomButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(RandomButton.getText());
			}
			
		});
		
	}

	private void addComponents() {
		panelInternal = new JPanel(null)
		{
			protected void paintComponent(Graphics g){
				g.drawImage(TitleImage,0,0,this);
			}
		};
		panelInternal.setSize(100,100);
		panelMain.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		panelMain.setBackground(Color.DARK_GRAY);
		Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		panelInternal.setBorder(border);
		c.insets = new Insets(0,0,100,0);
		
		panelMain.add(panelInternal,c);
		panelMain.add(RandomButton);
		
		add(panelMain);
		
	}

	private void createAndShowGui() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400,400);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
}