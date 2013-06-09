package pl.edu.pw.tele.enigma;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * 
 * @author Lukasz
 * Klasa, kt�ra odpowiada za przedstawienie reflektora
 */
public class Reflector implements ReflectorInterface {

	Logger log = Logger.getLogger(Reflector.class.getName());

	/**
	 * Reflector jako tablica int�w.
	 */
	protected ArrayList<String> reflector = new ArrayList<String>();
	protected ArrayList<String> alphabet = Enigma.getInstance().getAlphabet();
	
	
	
	/**
	 * Przechowywana warto�� d�ugo�ci s�ownia.<br>
	 * Jest to nic innego jak d�ugo�� tablicy reflektora
	 */
	protected int size = 0;
	
	/**
	 * Tw�r by konstruktor Reflektor(String,int) si� nie wywali�
	 */
	public Reflector()
	{
		//Musi by� pusty. Nic nie implementujemy.
	}
	
	/**
	 * Konstruktor do wczytywania parametr�w z pliku tekstowego
	 */
	public Reflector(String s)
	{
		parse(s);
	}
	
	/**
	 * Parser. S�u�y do wczytywania warto��i przez parametry aktualne
	 */
	@Override
	public void parse(String s) {
		log.info("Reflector.alfabet = " + alphabet.toString());
		log.info("Reflector.s = " + s);
		for(int i = 0 ; i < s.length(); i++)
		{
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



}
