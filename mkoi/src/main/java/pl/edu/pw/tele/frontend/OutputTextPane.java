package pl.edu.pw.tele.frontend;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import pl.edu.pw.tele.Utils;
/**
 * Class provides fully-formatted output.<p>
 * The main design concept was to separate enigma engine from visual output.
 * <br> Enigma appends output to JTextArea object
 * @author Lukasz Sedek
 *
 */
public class OutputTextPane extends JPanel{
	/**
	 * Log4J Logger
	 */
	Logger log = Logger.getLogger(InputTextPane.class.getName());
	/**
	 * Title label
	 */
	protected JLabel title = new JLabel("Output text");
	/**
	 * Outout containter
	 */
	protected static JTextArea outputArea = new JTextArea(20, 10);
	/**
	 * Default getter for JTextArea
	 * @return outoutArea
	 */
	public static JTextArea getOutputArea() {
		return outputArea;
	}

	/**
	 * Setter for OutputArea
	 * @param s
	 */
	public static void setOutputArea(String s) {
		
		Document text = outputArea.getDocument();
		try {
			text.insertString(text.getLength(), s , null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		OutputTextPane.outputArea = outputArea;
	}

	/**
	 * Default construtor
	 */
	public OutputTextPane()
	{
		title.setFont(new Font("Arial", Font.BOLD, 14));
		setLayout((LayoutManager) new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(Box.createRigidArea(new Dimension(0,5)));
		setBorder( new EmptyBorder( 3, 3, 3, 3 ) );
		add(title);
		outputArea.setWrapStyleWord(true);
		outputArea.setLineWrap(true);
		outputArea.setOpaque(true);
		outputArea.setFont(new Font("Helvetica", Font.BOLD, 16));
		JScrollPane listScroller = new JScrollPane(outputArea);
		listScroller.setPreferredSize(new Dimension(250, 15));
		listScroller.setAlignmentX(LEFT_ALIGNMENT);
		add(listScroller);
		
	}


	
}
