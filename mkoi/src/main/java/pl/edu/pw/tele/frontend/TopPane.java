package pl.edu.pw.tele.frontend;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import pl.edu.pw.tele.Utils;

/**
 * This class provices container for top side of GUI.
 * Layout based on traditional BorderLayout.
 * <p>
 * This pane contains rotors current states
 * 
 * @author Lukasz Sedek
 *
 */
public class TopPane extends JPanel{

	Font font = new Font("Times New Roman", Font.BOLD, 24);
	static public JLabel R1button = new JLabel("");
	static public JLabel R2button = new JLabel("");
	static public JLabel R3button = new JLabel("");
	JLabel R1label = new JLabel("R1=");
	JLabel R2label = new JLabel("R2=");
	JLabel R3label = new JLabel("R3=");
	/**
	 * Default constructor.
	 */
	public TopPane()
	{
		add(R1label);
		add(R1button);
		add(R2label);
		add(R2button);
		add(R3label);
		add(R3button);
		R1label.setFont(font);
		R2label.setFont(font);
		R3label.setFont(font);
		R1button.setFont(font);
		R2button.setFont(font);
		R3button.setFont(font);
		
	}
}
