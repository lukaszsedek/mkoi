package pl.edu.pw.tele.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import pl.edu.pw.tele.Utils;
import pl.edu.pw.tele.control.CipherAction;
import pl.edu.pw.tele.control.FinishAction;
import pl.edu.pw.tele.control.OpenFileAction;
import pl.edu.pw.tele.threads.FileReadIO;

/**
 * 
 * @author lukaszsedek
 *
 *	Class that implements my own BOTTOM part of GUI. <br>
 *	It doesn't need any other implementations
 */
public class ButtonsPane extends JPanel{

	private JButton finishProgram = null;
	private static final String finishProgramLabel = "Quit";
	private JButton cipherButton = null;
	private static final String cipherButtonLabel = "Cipher";
	private JButton openFileButton = null;
	private static final String openFileButtonLabel = "Open file";	
	
	Logger log = Logger.getLogger(ButtonsPane.class.getName());
	/**
	 * Default constructor for ButtonPane. <br>
	 * That's the only one ctor
	 */
	
	public ButtonsPane()
	{
		
		// initialize variables
		finishProgram = new JButton(finishProgramLabel);
		cipherButton = new JButton(cipherButtonLabel);
		openFileButton = new JButton(openFileButtonLabel);
		
		// Add trigger to click event
		finishProgram.addActionListener(new FinishAction());
		cipherButton.addActionListener(CipherAction.getActionListener());
		openFileButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text files", "txt"));
		        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("MS Office Documents", "docx", "xlsx", "pptx"));
		        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
		        fileChooser.setAcceptAllFileFilterUsed(false);
				int result = fileChooser.showOpenDialog(fileChooser);
				switch (result) {
				case JFileChooser.APPROVE_OPTION:
					File selectedFile = fileChooser.getSelectedFile();
					Utils.FILENAME_INTPUT = selectedFile.getAbsolutePath();
					log.info("before...");
					FileReadIO run = new FileReadIO();
					Thread loadFile = new Thread(run);
					loadFile.start();
					
					log.info("Selected file: " + selectedFile.getAbsolutePath());
					break;

				default:
					break;
				}
				
			}
		});
		
		// add references to GUI layout
		add(openFileButton);
		add(cipherButton);
		add(finishProgram);
		
	}
}
