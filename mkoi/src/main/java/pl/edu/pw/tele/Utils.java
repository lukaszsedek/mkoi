package pl.edu.pw.tele;

/**
 * Helping class for some additional variables like filename (total path to filename), Input text buffer (thread safe) and Output buffer ( thread safe too)
 * 
 * @author Lukasz Sedek
 * @version 0.1
 *
 */
public class Utils {
	
	/**
	 *  filename
	 */
	public static String FILENAME_INTPUT = "";
	/**
	 * Input String Buffer. used for thread safe.  
	 */
	public static StringBuffer Input = new StringBuffer();
	/**
	 * Output String Buffer. Used for thread safe mode.
	 */
	public static StringBuffer Output = new StringBuffer();
	/**
	 * Not usable now. Should be removes till next version
	 * @deprecated 
	 */
	public static boolean LOADED = false;
	

}
