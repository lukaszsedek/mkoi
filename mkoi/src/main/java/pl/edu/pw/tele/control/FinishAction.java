package pl.edu.pw.tele.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
/**
 * 
 * @author lukaszsedek
 * 
 * Listener for soft exit
 */
public class FinishAction implements ActionListener {

	Logger log = Logger.getLogger(FinishAction.class.getName());
	
	public FinishAction()
	{
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("Quit");
		System.exit(0);
	}

}
