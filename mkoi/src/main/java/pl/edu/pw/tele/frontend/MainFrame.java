package pl.edu.pw.tele.frontend;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Class inherited by JFrame. <br>
 * Highest class in GUI hierarchy
 * 
 */
public class MainFrame extends JFrame {

	/**
	 * Window width <br>
	 */
	protected final int _width = 1024;
	/**
	 * Window high<br>
	 */
	protected final int _high = 768;
	
	/**
	 * Window title
	 */
	protected final String title = "EGNIMA project";
	
	/**
	 * Menu "has-reference"
	 */
	
	MkoiMenu menu = null;
	
	/**
	 * Main Panel (containter for other components)
	 */
	
	MkoiContentPane pane = null;
	
	/**
	 * Default constructor for JFrame: <br>
	 * <ul>
	 * <li>Title</li>
	 * <li>Dimensions</li>
	 * <li>Menu</li>
	 * <li>Other references panels</li>
	 * </ul>
	 */
	public MainFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(_width, _high);
		
		//Adjust window centrally on screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dim.width-_width)/2, (dim.height-_high)/2);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		
		setTitle(title);
		/**
		 * Add default pane to Frame.<br>
		 * Explanation: avoiding JFrame overloading
		 */
		pane = new MkoiContentPane();
		getContentPane().add(pane);
	}
	
	/**
	 * Set window dimension width
	 * @param w width in pixels
	 */
	public void setFrameWidth(int w)
	{
		setSize(w, getHeight());
	}
	
	/**
	 * Set window high dimension
	 * @param h high in pixels
	 */
	public void setFrameHigh(int h)
	{
		setSize(getWidth(), h);
	}
	
	
	
}
