package pl.edu.pw.tele.enigma;

import java.util.ArrayList;
import java.util.logging.Logger;

import pl.edu.pw.tele.Utils;
import pl.edu.pw.tele.frontend.TopPane;

/**
 * Java class that acts as ENIGMA machine.<br>
 * Used JAVA singleton pattern. Please do not change any methods without consulting with design team<br>
 * Implements interface Enigma Interface.
 * @author Lukasz Sedek, Marcin Toczko
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
	/**
	 * variable which stores alphabet for whole application.<br>
	 * This is used for reference for others alphabets within this application. <br>
	 * Do not change that
	 */
	protected ArrayList<String> alphabet = null;
	/**
	 * Variable for reflector. This is enigma's style term.<br>
	 * If you dont know what is that, please read wikipedia
	 */
	protected Reflector reflector = null;
	/**
	 * Rotor number 1. This is constant variable. Unfortunately we dont support multiple rotors.<br>
	 * Rotor is enigma's term.<br>
	 */
	Rotor rotor1;
	/**
	 * Rotor number 2. This is constant variable. Unfortunately we dont support multiple rotors.<br>
	 * Rotor is enigma's term.<br>
	 */
	Rotor rotor2;
	/**
	 * Rotor number 3. This is constant variable. Unfortunately we dont support multiple rotors.<br>
	 * Rotor is enigma's term.<br>
	 */
	Rotor rotor3;

	/**
	 * Getter for reflector object reference
	 * @return Reflector object. One for whole enigma instance.
	 */
	@Override
	public Reflector getReflector() {
		return reflector;
	}

	/**
	 * Setter for reflector. Similiar to others setters and getters.
	 */
	@Override
	public void setReflector(Reflector reflector) {
		this.reflector = reflector;
	}

	/**
	 * getter for rotor number 1 
	 * @return Rotor number 1 reference object
	 */
	@Override
	public Rotor getRotor1() {
		return rotor1;
	}

	/**
	 * Another setter for rotor number 1
	 */
	public void setRotor1(String rotor1, String start, String turn) {
		this.rotor1 = new Rotor(rotor1, start, turn);
	}

	/**
	 */
	@Override
	public Rotor getRotor2() {
		return rotor2;
	}

	/**
	 * Another setter for rotor number 2
	 */
	@Override
	public void setRotor2(String rotor2, String start, String turn) {
		this.rotor2 = new Rotor(rotor2, start, turn);
	}


	/**
	 */
	public Rotor getRotor3() {
		return rotor3;
	}

	/**
	 * Another setter for rotor number 3
	 */
	@Override
	public void setRotor3(String rotor3, String start, String turn) {
		this.rotor3 = new Rotor(rotor3, start, turn);
	}

	/**
	 * <b>Enigma's method for getting access to single object. <br>
	 * We used singleton pattern to obtain only one enigma instance within application scope. 
	 * </b>
	 * 
	 * @return Enigma 
	 *         
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
	 * Singleton-like design. We secured access to default constructor
	 */
	private Enigma() {

	}

	/**
	 */
	@Override
	public ArrayList<String> getAlphabet() {
		return alphabet;
	}

	/**
	 */
	public void setAlphabet(ArrayList<String> arraylist) {
		this.alphabet = arraylist;

	}

	/**
	 * helping method for creating Reflector
	 */
	@Override
	public void createReflector(String s) {
		log.finest("Reflector.createReflector");
		reflector = new Reflector(s);

	}

	/**
	 * Main method for ciphering enigma's algorithm single letter. 
	 */
	@Override
	public char cipher(char s) {
            
            int i = alphabet.indexOf(Character.toString(s));
            rotate();
            
            i = rotor3.conversion(i);
            i = rotor2.conversion(i);          
            i = rotor1.conversion(i);            
            i = reflector.conversion(i);            
            i = rotor1.conversionInvert(i);            
            i = rotor2.conversionInvert(i);           
            i = rotor3.conversionInvert(i);
            
            s = alphabet.get(i).charAt(0);

            return s;
	}
        
	/**
	 * Moves rotor to up
	 */
        private void rotate()
        {
            rotor3.move();
           TopPane.R3button.setText("" + alphabet.get(rotor3.getPosition()));
           TopPane.R2button.setText("" + alphabet.get(rotor2.getPosition()));
           TopPane.R1button.setText("" + alphabet.get(rotor1.getPosition()));
           
           
                        
            if( rotor3.getPosition() == rotor3.getTurnoverPositions() )
            {         
                rotor2.move();
             
                log.info("rotore 2 move");
            }
            
            if( rotor2.getPosition()== rotor2.getTurnoverPositions() && rotor2.getCount() > 25 )
            {
                log.info("rotore 1 move");
                rotor1.move();             
                rotor2.restart();
            }
            
            
        }


}
