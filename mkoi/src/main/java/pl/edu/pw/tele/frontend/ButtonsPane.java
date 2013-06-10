package pl.edu.pw.tele.frontend;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import pl.edu.pw.tele.Utils;
import pl.edu.pw.tele.control.FinishAction;
import pl.edu.pw.tele.threads.FileReadIO;

/**
 * 
 * @author Lukasz Sedek
 * 
 *         Class that implements my own BOTTOM part of GUI. <br>
 *         It doesn't need any other implementations
 */
public class ButtonsPane extends JPanel {

	private JButton finishProgram = null;
	private static final String finishProgramLabel = "Quit";
	private JButton openFileButton = null;
	private static final String openFileButtonLabel = "Open configuration file";
	private JButton resetData = null;

	/**
	 * Log4J logger instance
	 */
	Logger log = Logger.getLogger(ButtonsPane.class.getName());

	/**
	 * Default constructor for ButtonPane. <br>
	 * That's the only one ctor
	 */

	public ButtonsPane() {

		// initialize variables
		finishProgram = createSimpleButton(finishProgramLabel);
		openFileButton = createSimpleButton(openFileButtonLabel);

		// Add trigger to click event
		finishProgram.addActionListener(new FinishAction());
		openFileButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
						"Configuration files", "ini"));
				fileChooser.setAcceptAllFileFilterUsed(true);
				int result = fileChooser.showOpenDialog(fileChooser);
				switch (result) {
				case JFileChooser.APPROVE_OPTION:
					File selectedFile = fileChooser.getSelectedFile();
					Utils.FILENAME_INTPUT = selectedFile.getAbsolutePath();
					log.info("before...");
					FileReadIO io = new FileReadIO();
					io.go();

					log.info("Selected file: " + selectedFile.getAbsolutePath());
					break;

				default:
					break;
				}

			}
		});

		resetData = createSimpleButton("Reset");

		resetData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InputTextPane.inputArea.setText("");
				OutputTextPane.outputArea.setText("");
				// TODO create re-loading
			}
		});

		// add references to GUI layout
		add(openFileButton);
		add(resetData);
		add(finishProgram);

	}

	private static JButton createSimpleButton(String text) {
		JButton button = new JButton(text);
		button.setHorizontalAlignment(JButton.LEADING); // optional
		// button.setBorderPainted(false);
		button.setBackground(Color.ORANGE);
		// button.setContentAreaFilled(false);
		return button;
	}
}
