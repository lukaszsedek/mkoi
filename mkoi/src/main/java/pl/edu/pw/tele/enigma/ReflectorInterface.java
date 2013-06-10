package pl.edu.pw.tele.enigma;

/**
 * Simple Interface for Reflector class.
 * override all methods.
 * 
 * @author Lukasz Sedek
 *
 */
public interface ReflectorInterface {

	/**
	 * Parse string from input file into Reflector 
	 * @param s
	 */
	void parse(String s);

	/**
	 * Convert
	 */
	public char conversion(char c);
}
