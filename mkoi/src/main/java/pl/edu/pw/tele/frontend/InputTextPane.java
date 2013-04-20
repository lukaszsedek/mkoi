package pl.edu.pw.tele.frontend;

import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import pl.edu.pw.tele.Utils;


/**
 * 
 * @author lukaszsedek
 * GUI component for showing input text
 */
public class InputTextPane extends JPanel implements IInputTextPane{

	protected JLabel title = new JLabel("Input text");
	protected static JTextArea inputArea = new JTextArea(30, 10);
	
	public InputTextPane()
	{
		
		setLayout((LayoutManager) new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(Box.createRigidArea(new Dimension(0,5)));
		setBorder( new EmptyBorder( 3, 3, 3, 3 ) );
		add(title);
		inputArea.setWrapStyleWord(true);
		inputArea.setLineWrap(true);
		inputArea.setEditable(false);
		inputArea.setFocusable(false);
		inputArea.setOpaque(false);
		JScrollPane listScroller = new JScrollPane(inputArea);
		inputArea.setText(Utils.Input);
		listScroller.setPreferredSize(new Dimension(250, 15));
		listScroller.setAlignmentX(LEFT_ALIGNMENT);
		add(listScroller);
	}
	
	public static void setText(String str)
	{
		inputArea.setText(str);
	}
}
