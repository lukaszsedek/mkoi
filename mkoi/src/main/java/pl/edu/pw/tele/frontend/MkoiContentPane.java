package pl.edu.pw.tele.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import pl.edu.pw.tele.Utils;

/**
 * Main swing containter.
 * <p>
 * Default BorderLayout class LayoutManager implemented
 * 
 * @author Lukasz Sedek
 * 
 */
public class MkoiContentPane extends JPanel {

	/**
	 * Bottom Pane
	 */
	ButtonsPane buttonsPane = new ButtonsPane();
	/**
	 * Input area
	 */
	InputTextPane inputTextPane = new InputTextPane();
	/**
	 * Outout area
	 */
	OutputTextPane outputTextPane = new OutputTextPane();
	/**
	 * Top Panel
	 */
	TopPane topPane = new TopPane();
	/**
	 * Center area for enigma visualization
	 * 
	 */
	MKOICenter center = new MKOICenter();

	/**
	 * Default construtor
	 */
	public MkoiContentPane() {
		setLayout(new BorderLayout());
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(BorderLayout.CENTER, center);
		add(BorderLayout.SOUTH, buttonsPane);
		add(BorderLayout.WEST, inputTextPane);
		add(BorderLayout.EAST, outputTextPane);
		add(BorderLayout.NORTH, topPane);
		add(BorderLayout.CENTER, centerPanel);

	}

	/**
	 * SOUTH getter
	 * 
	 * @return SOUTH
	 */
	public ButtonsPane getButtonsPane() {
		return buttonsPane;
	}

	/**
	 * SOUTH setter
	 * 
	 * @param buttonsPane
	 */
	public void setButtonsPane(ButtonsPane buttonsPane) {
		this.buttonsPane = buttonsPane;
	}

	/**
	 * EAST getter
	 * 
	 * @return InputTextPane
	 */
	public InputTextPane getInputTextPane() {
		return inputTextPane;
	}

	/**
	 * EAST setter
	 * @param inputTextPane
	 */
	public void setInputTextPane(InputTextPane inputTextPane) {
		this.inputTextPane = inputTextPane;
	}

	/**
	 * NORTH getter
	 * @return TopPane
	 */
	public TopPane getTopPane() {
		return topPane;
	}

	/**
	 * NORTH setter
	 * @param topPane
	 */
	public void setTopPane(TopPane topPane) {
		this.topPane = topPane;
	}

}
