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


	/**
	 * <b>LOG4J</b>
	 */
	Logger log = Logger.getLogger(Enigma.class.getName());

	/**
	 * Signleton instance
	 */
	private static volatile Enigma instance = null;
	protected ArrayList<String> alphabet = null;
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

	public ArrayList<String> getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(ArrayList<String> arraylist) {
		this.alphabet = arraylist;

	}

	@Override
	public void createReflector(String s) {
		log.info("Reflector.createReflector");
		reflector = new Reflector(s);

	}

	@Override
	public void cipher(char s) {
		log.info("cipher " + s);
		rotor1.move();
	}


}
