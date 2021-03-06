package pl.edu.pw.tele.frontend;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import pl.edu.pw.tele.Utils;
import pl.edu.pw.tele.enigma.Enigma;

/**
 * 
 * @author lukaszsedek GUI component for showing input text
 */
public class InputTextPane extends JPanel implements IInputTextPane {

	/**
	 * Log4J logger
	 */
	Logger log = Logger.getLogger(InputTextPane.class.getName());
	protected JLabel title = new JLabel("Input text");
	protected static JTextArea inputArea = new JTextArea(20, 10);

	/**
	 * Default constructor
	 */
	public InputTextPane() {
		title.setFont(new Font("Arial", Font.BOLD, 14));
		setLayout((LayoutManager) new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(Box.createRigidArea(new Dimension(0, 5)));
		setBorder(new EmptyBorder(3, 3, 3, 3));
		add(title);
		inputArea.setWrapStyleWord(true);
		inputArea.setLineWrap(true);
		inputArea.setEnabled(false);
		inputArea.setFocusable(false);
		inputArea.setOpaque(true);
		JScrollPane listScroller = new JScrollPane(inputArea);
		inputArea.setText(Utils.Input.toString());
		inputArea.setFont(new Font("Helvetica", Font.BOLD, 16));
		listScroller.setPreferredSize(new Dimension(250, 15));
		listScroller.setAlignmentX(LEFT_ALIGNMENT);
		add(listScroller);

		inputArea.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!inputArea.isEnabled()) {
					JFrame frame = new JFrame("JOptionPane showMessageDialog example");
					JOptionPane.showMessageDialog(frame,
							"Load configuration file first",
							"Warrning!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		inputArea.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
                                
				// log.info("" + ((int)arg0.getKeyChar()));
				if (arg0.getKeyChar() >= 65 & arg0.getKeyChar() <= 90) {
					// log.info("duze " + arg0.getKeyChar());
					Character chara = Character.valueOf(arg0.getKeyChar());
					chara = chara.toUpperCase(chara.charValue());
					cipher(chara.charValue());

				} else if (arg0.getKeyChar() >= 97 && arg0.getKeyChar() <= 122) {
					log.info("male " + arg0.getKeyChar());
					cipher(Character.toUpperCase(arg0.getKeyChar()));
				} else{
					log.finest("other character: " + arg0.getKeyChar());
				}
				MKOICenter.refresh();
				
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

	/**
	 * Main method for one-step ciphering
	 * @param c
	 */
	public static void cipher(char c) {
		Enigma enigma = Enigma.getInstance();

		OutputTextPane.setOutputArea("" + enigma.cipher(c));
	}

	public static void setText(String str) {
		inputArea.setText(str);
	}

	/**
	 * irrelevant GUI feature
	 * @param b
	 */
	public static void enableInput(boolean b) {
		inputArea.setFocusable(b);
		inputArea.setEnabled(b);
	}

}
