package frontend;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Klasa g��wnego okna. <br>
 * Najwy�ej w hierarchii
 */
public class MainFrame extends JFrame {

	/**
	 * Szeroko� okna. <br>
	 * Zmieniana przez setFrameWidth()
	 */
	protected int _width = 400;
	/**
	 * Wysoko� okna <br>
	 * Zmieniana przez setFrameHigh()
	 */
	protected int _high = 200;
	
	/**
	 * Tytu� okna
	 */
	protected final String title = "MKOI projekt";
	
	
	public MainFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(_width, _high);
		
		//Ustawia okno centralnie na monitorze
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dim.width-_width)/2, (dim.height-_high)/2);
		
		setTitle(title);
	}
	
	/*
	 * Ustawia szeroko� okna
	 */
	public void setFrameWidth(int w)
	{
		setSize(w, getHeight());
	}
	
	public void setFrameHigh(int h)
	{
		setSize(getWidth(), h);
	}
	
	
	
}
