package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class LoadPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -889413924721344100L;
	TitledBorder title = BorderFactory.createTitledBorder("Game Menu");
	GridBagConstraints c = new GridBagConstraints();
	public JButton buttonContinue;
	public JButton buttonLoad;
	public JButton buttonBack;
	
	public LoadPanel(){
		super();
		create();
		addButtons();
	}
	
	private void addButtons() {
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.5;
		buttonContinue = new JButton("Continue");
		buttonContinue.setPreferredSize(new Dimension(75,30));
		add(buttonContinue,c);
		
		buttonLoad = new JButton("Load");
		buttonLoad.setPreferredSize(new Dimension(75,30));
		c.gridy = 1;
		add(buttonLoad,c);
		
		c.insets = new Insets(10,0,0,0);
		
		buttonBack = new JButton("Back");
		buttonBack.setPreferredSize(new Dimension(75,30));
		c.gridy = 2;
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
