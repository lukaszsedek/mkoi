package pl.edu.pw.tele;

import pl.edu.pw.tele.frontend.MainFrame;

/**
 * Starting Main Class <br>
 * GUI thread scheduler
 */
public class App 
{
	/**
	 * Starting GUI class
	 */
	static MainFrame myFrame = null;
	
    public static void main( String[] args )
    {
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

            	myFrame = new MainFrame();
            	myFrame.setVisible(true);
            }
        });
    	
    }
}
