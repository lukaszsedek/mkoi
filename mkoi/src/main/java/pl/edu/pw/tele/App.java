package pl.edu.pw.tele;

import pl.edu.pw.tele.frontend.MainFrame;

/**
 * @author Lukasz Sedek, Marcin Toczko
 * Starting Main Class <br>
 * GUI thread scheduler
 */
public class App 
{
	/**
	 * Starting GUI class <br>
	 * Main JFrame inherited class.
	 */
	static MainFrame myFrame = null;
	
	/**
	 * Function starting app<br>
	 * Java common...
	 * @param args system args
	 */
    public static void main( String[] args )
    {
    	/**
    	 * Java GUI threads invoker
    	 */
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

            	myFrame = new MainFrame();
            	myFrame.setVisible(true);
            }
        });
    	
    }
}
