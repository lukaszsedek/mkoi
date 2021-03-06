package pl.edu.pw.tele.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
/**
 * 
 * @author Lukasz Sedek, Marin Toczko
 * 
 * Listener for soft exit. Written as dumb class which implements ActionListener. 
 */
public class FinishAction implements ActionListener {

	Logger log = Logger.getLogger(FinishAction.class.getName());
	
	/**
	 * Used for sake that nobody will use default construtor
	 */
	public FinishAction()
	{
	}
	
	/**
	 * Just simple Action.
	 */
	public void actionPerformed(ActionEvent e) {
		// Don't use info. Info is for very important logs
		log.finest("Graceful quit");
		System.exit(0);
	}

}
