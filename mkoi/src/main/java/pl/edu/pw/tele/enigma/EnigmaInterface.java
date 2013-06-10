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
	 */
	void createReflector(String s);
	/**
	 * Ciphering algoritm
	 */
	char cipher(char s);
	/**
	 * Reflector getter 
	 */
	public Reflector getReflector();
	/**
	 * Reflector setter
	 */
	void setReflector(Reflector reflector);
	/**
	 * Rotor 1 getter
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
	 */
	Rotor getRotor2();
	/**
	 * Rotor 2 setter 
	 */
	void setRotor2(String rotor1, String start, String turn);
	/**
	 * getter Rotor 3
	 */
	Rotor getRotor3();
	/**
	 * Rotor 3 setter 
	 */
	void setRotor3(String rotor1, String start, String turn);
	/**
	 * Alphabet getter
	 */
	public ArrayList<String> getAlphabet();
}
