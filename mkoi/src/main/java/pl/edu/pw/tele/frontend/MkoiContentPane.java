package pl.edu.pw.tele.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MkoiContentPane extends JPanel {

	ButtonsPane buttonsPane = new ButtonsPane();
	InputTextPane inputTextPane = new InputTextPane();
	TopPane topPane = new TopPane();
	
	public MkoiContentPane()
	{
		setLayout(new BorderLayout());
		
		//setBackground(Color.CYAN);
		//Border border = BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLUE);
		//setBorder(border);
		add(BorderLayout.SOUTH, buttonsPane);
		add(BorderLayout.WEST, inputTextPane);
		add(BorderLayout.NORTH, topPane);
		
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
