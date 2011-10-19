package Menus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class OptionPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 19872344545L;
	TitledBorder title = BorderFactory.createTitledBorder("OPTIONS");
	GridBagConstraints c = new GridBagConstraints();
	public JButton buttonBack;
	
	public OptionPanel(){
		super();
		create();
		addOptionsThings();
	}



	private void addOptionsThings() {
		buttonBack = new JButton("Back");
		buttonBack.setPreferredSize(new Dimension(75,30));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.5;
		c.gridx = 1;
		add(buttonBack,c);
	}



	private void create() {
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(400,400)); 
		title.setTitleColor(Color.WHITE);
		setBorder(title);
	}
}
