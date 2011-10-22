package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class CharCreation extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1475741428117092919L;
	TitledBorder title = BorderFactory.createTitledBorder("Character Creation");
	GridBagConstraints c = new GridBagConstraints();
	public JButton buttonStart;
	public JTextField fieldName;


	public CharCreation(){
		super();
		create();
		addOptions();
	}

	private void addOptions() {

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.5;
		c.gridx = 1;
		fieldName = new JTextField();
		fieldName.setHorizontalAlignment(JTextField.CENTER);
		fieldName.setPreferredSize(new Dimension(75,30));
		add(fieldName,c);
		
		buttonStart = new JButton("Start");
		buttonStart.setPreferredSize(new Dimension(75,30));
		add(buttonStart,c);
	}

	private void create() {
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(400,400)); 
		title.setTitleColor(Color.WHITE);
		setBorder(title);
	}
}
