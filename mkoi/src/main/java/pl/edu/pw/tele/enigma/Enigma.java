package pl.edu.pw.tele.enigma;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Klasa reprezentuj�ca wszystkie elementy Enigmy.<br>
 * Reprezentuje maszyn� enigma<br>
 * Wzorzec singleton
 * 
 * @author Lukasz
 * 
 */
public  class Enigma implements EnigmaInterface {

	{
		alphabet = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
				'V', 'W', 'X', 'Y', 'Z' };
	}

	/**
	 * <b>LOG4J</b>
	 */
	Logger log = Logger.getLogger(Enigma.class.getName());

	/**
	 * Signleton instance
	 */
	private static volatile Enigma instance = null;
	protected char[] alphabet = null;
	protected Reflector reflector = null;
	Rotor rotor1;
	Rotor rotor2;
	Rotor rotor3;

	public Reflector getReflector() {
		return reflector;
	}

	public void setReflector(Reflector reflector) {
		this.reflector = reflector;
	}




	public Rotor getRotor1() {
		return rotor1;
	}

	public void setRotor1(String rotor1, String start) {
		this.rotor1 = new Rotor(rotor1, start);
	}

	public Rotor getRotor2() {
		return rotor2;
	}

	public void setRotor2(String rotor2, String start) {
		this.rotor2 = new Rotor(rotor2, start);
	}

	public Rotor getRotor3() {
		return rotor3;
	}

	public void setRotor3(String rotor3, String start) {
		this.rotor3 = new Rotor(rotor3, start);
	}

	/**
	 * <b>Metoda wzorca typu singleton. Chcemy mie� tylko i wy��cznie jeden
	 * obiekt Enigmy. <br>
	 * </b>
	 * 
	 * @return <br>
	 *         instancja Enigmy</b>
	 */
	public static Enigma getInstance() {
		if (instance == null) {
			synchronized (Enigma.class) {
				if (instance == null) {
					instance = new Enigma();
				}
			}
		}
		return instance;
	}

	/**
	 * Zabezpieczenie na tworzenie nowych instacji Enigmy
	 */
	private Enigma() {

	}

	public char[] getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(char[] alphabet) {
		this.alphabet = alphabet;

	}

	@Override
	public void createReflector(String s) {
		log.info("Reflector.createReflector");
		reflector = new Reflector(s);

	}


}