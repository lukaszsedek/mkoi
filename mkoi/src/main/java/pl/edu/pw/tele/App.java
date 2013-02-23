package pl.edu.pw.tele;

import frontend.MainFrame;

/**
 * Main Class
 *
 */
public class App 
{
	/**
	 * W�asny obiekt.<br>
	 * Referencja do superklasy JFrame
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
