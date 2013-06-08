package pl.edu.pw.tele.frontend;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;

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

	Logger log = Logger.getLogger(InputTextPane.class.getName());
	protected JLabel title = new JLabel("Input text");
	protected static JTextArea inputArea = new JTextArea(20, 10);
	
	public InputTextPane()
	{
		
		setLayout((LayoutManager) new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(Box.createRigidArea(new Dimension(0,5)));
		setBorder( new EmptyBorder( 3, 3, 3, 3 ) );
		add(title);
		inputArea.setWrapStyleWord(true);
		inputArea.setLineWrap(true);
		//inputArea.setFocusable(false);
		inputArea.setOpaque(true);
		JScrollPane listScroller = new JScrollPane(inputArea);
		inputArea.setText(Utils.Input.toString());
		inputArea.setFont(new Font("Helvetica", Font.BOLD, 16));
		listScroller.setPreferredSize(new Dimension(250, 15));
		listScroller.setAlignmentX(LEFT_ALIGNMENT);
		add(listScroller);
		
		inputArea.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				log.info("" + ((int)arg0.getKeyChar()));
				if (arg0.getKeyChar() >= 65 & arg0.getKeyChar() <= 90)
				{
					log.info("duze " + arg0.getKeyChar());
					Utils.Output.append(arg0.getKeyChar());
					
					OutputTextPane.setOutputArea("" +arg0.getKeyChar());
				}else if (arg0.getKeyChar() >= 97 && arg0.getKeyChar() <= 122)
				{
					log.info("male " + arg0.getKeyChar());
					OutputTextPane.setOutputArea(String.valueOf(arg0.getKeyChar()).toUpperCase());
				}else
					log.info("co� innego" + arg0.getKeyChar());
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				log.info("" + arg0.getKeyChar());				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {

			}
		});
		
	}
	
	public static void setText(String str)
	{
		inputArea.setText(str);
	}
}