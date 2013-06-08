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
	
	public Rotor(String s, String poz){
		log.info("Tworzenie rotora..." + s + " pozycja " + poz);
		rotor = s.toCharArray();
		Enigma enigma = Enigma.getInstance();
		alphabet = enigma.getAlphabet();
		
		char c = poz.toCharArray()[0];
		for(int i = 0 ; i < alphabet.length ; ++i )
		{
			if( alphabet[i] == c)
			{
				log.info("znaleziono " + i + " = " + c);
				this.position = i;
			}
		}
	}

	@Override
	public int getSize() {
		return rotor.length;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
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