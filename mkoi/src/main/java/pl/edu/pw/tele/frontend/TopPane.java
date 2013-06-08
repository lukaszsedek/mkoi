package pl.edu.pw.tele.frontend;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPane extends JPanel{

	private JLabel lab = new JLabel("ENIGMA");
	public TopPane()
	{
		add(lab);
		lab.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
	}
}
