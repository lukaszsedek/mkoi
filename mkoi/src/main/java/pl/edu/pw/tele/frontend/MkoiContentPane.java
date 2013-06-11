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

public class MkoiContentPane extends JPanel {

	ButtonsPane buttonsPane = new ButtonsPane();
	InputTextPane inputTextPane = new InputTextPane();
	OutputTextPane outputTextPane = new OutputTextPane();
	TopPane topPane = new TopPane();
	MKOICenter center = new MKOICenter();
	
	public MkoiContentPane()
	{
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

	public ButtonsPane getButtonsPane() {
		return buttonsPane;
	}

	public void setButtonsPane(ButtonsPane buttonsPane) {
		this.buttonsPane = buttonsPane;
	}

	public InputTextPane getInputTextPane() {
		return inputTextPane;
	}

	public void setInputTextPane(InputTextPane inputTextPane) {
		this.inputTextPane = inputTextPane;
	}

	public TopPane getTopPane() {
		return topPane;
	}

	public void setTopPane(TopPane topPane) {
		this.topPane = topPane;
	}
	
	
}
