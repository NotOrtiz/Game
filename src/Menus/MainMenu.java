package Menus;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainMenu extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8674266367360936532L;
	
	JPanel panelMain = new JPanel();
	BoxLayout layoutManager = new BoxLayout(panelMain, BoxLayout.X_AXIS);
	JTextField textName;
	
	public MainMenu(){
		super("Main Menu");
		initComponents();
		addComponents();
		createAndShowGui();
	}

	private void initComponents() {
		textName  = new JTextField();
		textName.setPreferredSize(new Dimension(100,55));
		textName.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		
	}

	private void addComponents() {
		panelMain.add(textName);
		add(panelMain);
	}

	private void createAndShowGui() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400,400);
		setVisible(true);
	}
}