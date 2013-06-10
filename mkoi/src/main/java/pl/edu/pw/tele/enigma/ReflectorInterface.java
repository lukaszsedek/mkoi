package pl.edu.pw.tele.enigma;

public interface ReflectorInterface {

	/**
	 * Parse string from input file into Reflector 
	 * @param s
	 */
	void parse(String s);

	/**
	 * Convert
	 * @param c
	 * @return
	 */
	public char conversion(char c);
}
