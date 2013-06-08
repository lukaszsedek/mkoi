package pl.edu.pw.tele.enigma;

import java.util.logging.Logger;

/**
 * 
 * @author Lukasz
 *
 */
public class Rotor implements RotorInterface{

	Logger log = Logger.getLogger(Rotor.class.getName());
	char[] rotor;
	char[] alphabet;
	int position = 0;
	
	public Rotor(){}
	
	public Rotor(String s){
		log.info("Tworzenie rotora..." + s);
		rotor = s.toCharArray();
		Enigma enigma = Enigma.getInstance();
		alphabet = enigma.getAlphabet();
	}

	@Override
	public int getSize() {
		return rotor.length;
	}

	public char[] getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(char[] alphabet) {
		this.alphabet = alphabet;
	}

	@Override
	public char[] getRotor() {
		return rotor;
	}
}
