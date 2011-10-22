package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PausePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8031413316243649949L;
	TitledBorder title = BorderFactory.createTitledBorder("PAUSED");
	GridBagConstraints c = new GridBagConstraints();
	public JButton buttonBack;
	public JButton buttonSaveAndExit;
	public PausePanel(){
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
		c.gridy = 0;
		add(buttonBack,c);
		buttonSaveAndExit = new JButton("Save and Exit");
		buttonSaveAndExit.setPreferredSize(new Dimension(75,30));
		c.gridy = 1;
		add(buttonSaveAndExit,c);
	}



	private void create() {
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(400,400)); 
		title.setTitleColor(Color.WHITE);
		setBorder(title);
	}
}
