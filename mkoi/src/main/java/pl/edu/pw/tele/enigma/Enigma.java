package pl.edu.pw.tele.enigma;

import java.util.ArrayList;
import java.util.logging.Logger;

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
	 * @param Reflector
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
	 * @author Marcin Toczko
	 * @param Rotor rotor1 
	 * @param String start. Reference to start
	 * @param String turn. Reference to turn rotor
	 */
	@Override
	public void setRotor1(String rotor1, String start, String turn) {
		this.rotor1 = new Rotor(rotor1, start, turn);
	}

	/**
	 * @author Lukasz Sedek
	 * @return Rotor number 2 reference
	 */
	@Override
	public Rotor getRotor2() {
		return rotor2;
	}

	/**
	 * Another setter for rotor number 2
	 * @author Marcin Toczko
	 * @param Rotor rotor1 
	 * @param String start. Reference to start
	 * @param String turn. Reference to turn rotor
	 */
	@Override
	public void setRotor2(String rotor2, String start, String turn) {
		this.rotor2 = new Rotor(rotor2, start, turn);
	}


	/**
	 * @author Lukasz Sedek
	 * @return Rotor number 3 reference
	 */
	public Rotor getRotor3() {
		return rotor3;
	}

	/**
	 * Another setter for rotor number 3
	 * @author Marcin Toczko
	 * @param Rotor rotor1 
	 * @param String start. Reference to start
	 * @param String turn. Reference to turn rotor
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
	 * @return Enigma instance
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
	 * @author Lukasz Sedek
	 * @return Return Array<String> as alphabet
	 */
	@Override
	public ArrayList<String> getAlphabet() {
		return alphabet;
	}

	/**
	 * setter for alphabet 
	 * @author Lukasz Sedek, Marcin Toczko
	 * @param arraylist. Input must be Java List object.
	 */
	public void setAlphabet(ArrayList<String> arraylist) {
		this.alphabet = arraylist;

	}

	/**
	 * helping method for creating Reflector
	 * @author Lukasz Sedek, Marcin Toczko
	 */
	@Override
	public void createReflector(String s) {
		log.finest("Reflector.createReflector");
		reflector = new Reflector(s);

	}

	/**
	 * @author Lukasz Sedek, Marcin Toczko
	 * Main method for ciphering enigma's algorithm single letter. 
	 * @param s - single letter. Must be char primitive 
	 */
	@Override
	public char cipher(char s) {
		
            rotate();
            
            s = rotor3.conversion(s);
            s = rotor2.conversion(s);          
            s = rotor1.conversion(s);            
            s = reflector.conversion(s);            
            s = rotor1.conversionInvert(s);            
            s = rotor2.conversionInvert(s);           
            s = rotor3.conversionInvert(s);
           

            return s;
	}
        
	/**
	 * @author Lukasz Sedek, Marcin Toczko
	 * Moves rotor to up
	 */
        private void rotate()
        {
            rotor3.move();
            
            log.info("rotore3 A: " + rotor3.getCurrentAlphabet().toString() );
            log.info("rotore3 R: " + rotor3.getPositonNormal() + "  "+rotor3.getPosition()+"  "+rotor3.getCurrentRotor().toString() );
                        
            if( rotor3.getPosition() == rotor3.getTurnoverPositions() )
            {         
                rotor2.move();
                log.info("rotore 2 + 1: ");
            }
            
            if( rotor2.getPosition()== rotor2.getTurnoverPositions() && rotor2.getCount() > 25 )
            {
                log.info("rotore1 move");
                rotor1.move();
                rotor2.restart();
            }
            
            
        }


}
