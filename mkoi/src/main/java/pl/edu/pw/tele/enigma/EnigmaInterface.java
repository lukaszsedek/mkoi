package pl.edu.pw.tele.enigma;

import java.util.ArrayList;
/**
 * Enigma Java Interface
 * @author Lukasz Sedek
 *
 */
public interface EnigmaInterface {

	/**
	 * 
	 * @param s string as alphabet
	 * @param i length of alphabet
	 */
	void createReflector(String s);
	/**
	 * Ciphering algoritm
	 * @param s single char
	 * @return cipered char
	 */
	char cipher(char s);
	/**
	 * Reflector getter 
	 * @return
	 */
	public Reflector getReflector();
	/**
	 * Reflector setter
	 * @param reflector
	 */
	void setReflector(Reflector reflector);
	/**
	 * Rotor 1 getter
	 * @return rotor number 1
	 */
	Rotor getRotor1();
	/**
	 * Rotor 1 setter
	 * @param rotor1 as string (rotor settings)
	 * @param start values as String 
	 * @param turn String as turns
	 */
	void setRotor1(String rotor1, String start, String turn);
	/**
	 * Rotor 2 getter
	 * @return Rotor 2
	 */
	Rotor getRotor2();
	/**
	 * Rotor 2 setter 
	 * @param rotor1 as String (rotor settings)
	 * @param start (start values)
	 * @param turn
	 */
	void setRotor2(String rotor1, String start, String turn);
	/**
	 * getter Rotor 3
	 * @return Rotor reference object
	 */
	Rotor getRotor3();
	/**
	 * Rotor 3 setter 
	 * @param rotor1 as String 
	 * @param start 
	 * @param turn
	 */
	void setRotor3(String rotor1, String start, String turn);
	/**
	 * Alphabet getter
	 * @return ArrayList<String> of alphabet letters
	 */
	public ArrayList<String> getAlphabet();
}
