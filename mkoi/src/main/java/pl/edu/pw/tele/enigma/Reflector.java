package pl.edu.pw.tele.enigma;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Class which acts as enigma Reflector. Within application there is only one instance of thats
 * @author Lukasz Sedek
 * @see pl.edu.pw.tele.frontend.MkoiContentPane
 */
public class Reflector implements ReflectorInterface {

	/**
	 * Log4J instance
	 */
	Logger log = Logger.getLogger(Reflector.class.getName());

	/**
	 * Reflector as List<String> of beginnning settings
	 */
	protected ArrayList<String> reflector = new ArrayList<String>();

	/**
	 * Alhpabet as ArrayList<String>
	 */
	protected ArrayList<String> alphabet = Enigma.getInstance().getAlphabet();

	/**
	 */
	protected int size = 0;
        
        int in_position,out_pososition;

	/**
	 */
	public Reflector() {
	}

	/**
	 */
	public Reflector(String s) {
		parse(s);
	}

	/**
	 */
	@Override
	public void parse(String s) {
		log.info("Reflector.alfabet = " + alphabet.toString());
		log.info("Reflector.s = " + s);
		for (int i = 0; i < s.length(); i++) {
			reflector.add(String.valueOf(s.charAt(i)));
		}

		log.info("Reflector.reflector = " + reflector.toString());
	}

	public ArrayList<String> getReflector() {
		return reflector;
	}

	public void setReflector(ArrayList<String> reflector) {
		this.reflector = reflector;
	}

	public ArrayList<String> getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(ArrayList<String> alphabet) {
		this.alphabet = alphabet;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Conversion for Enigma
	 */
	@Override
	public int conversion(int i) {
            
            in_position = i;
            
          return  out_pososition =  alphabet.indexOf( reflector.get(i));
            
        }

        public int getInPosition()
        {
            return in_position;
        }
        public int getOutPosition()
        {
            return out_pososition;
        }
}
