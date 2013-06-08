package pl.edu.pw.tele.enigma;

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
	protected char[] reflector;
	protected char[] alfabet;
	
	
	
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
		alfabet = Enigma.getInstance().getAlphabet();
		log.info("Reflector.alfabet = " + alfabet.toString());
		
		int size = Enigma.getInstance().alphabet.length;
		log.info("Reflector.size = " + size);
		
		reflector = new char[size];
		reflector = s.toCharArray();
		
		
	}

	public char[] getReflector() {
		return reflector;
	}

	public void setReflector(char[] reflector) {
		this.reflector = reflector;
	}

	public char[] getAlfabet() {
		return alfabet;
	}

	public void setAlfabet(char[] alfabet) {
		this.alfabet = alfabet;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int returnReflector(int i) throws Exception {
		if (i >1 && i < size)
			return reflector[i];
		else{
			throw new Exception("Incorrect pointer at reflector table");
		}
		
	}

}