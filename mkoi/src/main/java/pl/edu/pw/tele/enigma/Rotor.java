package pl.edu.pw.tele.enigma;

import java.util.ArrayList;
import java.util.logging.Logger;

import pl.edu.pw.tele.frontend.MKOICenter;

/**
 * Basic element of Enigma - rotor.<br>
 * According to project purpose only 3 rotors are implemented
 * 
 * @author Lukasz Sedek, Marcin Toczko
 * 
 */
public class Rotor implements RotorInterface {

	/**
	 * Log4J instance
	 */
	Logger log = Logger.getLogger(Rotor.class.getName());

	int position = 0;
	int turnover_positions = 0;
	int positon_normal = 0;
	int positon_inver = 0;

	/**
	 * Alphabet reference
	 */
	ArrayList<String> alphabetList = Enigma.getInstance().alphabet;

	/**
	 * Alhpabet size
	 */
	int count = alphabetList.size();
	/**
	 * rotor settings
	 */
	ArrayList<String> rotor = new ArrayList<String>();

	/**
	 * Default construtor
	 */
	public Rotor() {
	}

	/**
	 * Construcotr
	 * @param settings String from intput file. 
	 * @param poz beginning position of rotor. Read from file
	 * @param turn
	 */
	public Rotor(String settings, String poz, String turn) {
		log.info("Tworzenie rotora..." + settings + " pozycja " + poz
				+ " pozycja obrotu " + turn);
		for (int i = 0; i < settings.length(); i++)

		{
			rotor.add(String.valueOf(settings.charAt(i)));
		}
		log.info("ROTOR = " + rotor.toString());

		for (int i = 0; i < alphabetList.size(); ++i) {
			if (poz.equals(alphabetList.get(i))) {
				position = i;
			}
		}

		log.info("ROTOR.position = " + this.position);

		for (int i = 0; i < alphabetList.size(); ++i) {
			if (turn.equals(alphabetList.get(i))) {
				turnover_positions = i + 1;
			}
		}
		log.info("ROTOR.turnover_positions = " + this.turnover_positions);
	}

	/**
	 * Size getter
	 * @return int size
	 */
	@Override
	public int getSize() {
		return rotor.size();
	}

	/**
	 * Position getter
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * TurnOver getter
	 * @return int
	 */
	public int getTurnoverPositions() {
		return turnover_positions;
	}

	public void setTurnoverPositions(int turnover_positions) {
		this.turnover_positions = turnover_positions;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public ArrayList<String> getAlphabetList() {
		return alphabetList;
	}

	public ArrayList<String> getRotor() {
		return rotor;
	}

	public void setRotor(ArrayList<String> rotor) {
		this.rotor = rotor;
	}

	public void setAlphabetList(ArrayList<String> alphabetList) {
		this.alphabetList = alphabetList;
	}

	public void move() {

		position = (position + 1) % alphabetList.size();
		count = (count + 1) % 255;
	}

	public void restart() {

		count = 0;

	}

	public int getCount() {
		return count;
	}

	@Override
	public char conversion(char c) {
		int index = -1;

		c = rotation_plus(c);

		for (int i = 0; i < alphabetList.size(); ++i) {
			if (Character.toString(c).equals(alphabetList.get(i))) {
				index = i;
				positon_normal = i;
			}
		}

		return rotation_minus(rotor.get(index).charAt(0));
	}

	public char conversionInvert(char c) {
		int index = -1;

		c = rotation_plus(c);

		for (int i = 0; i < alphabetList.size(); ++i) {
			if (Character.toString(c).equals(rotor.get(i))) {
				index = i;
				positon_inver = i;
			}
		}

		return rotation_minus(alphabetList.get(index).charAt(0));
	}

	private char rotation_plus(char c) {
		int tmp;
		int valueCharA = (int) ('A');

		tmp = (int) c - valueCharA;
		tmp = (tmp + position) % alphabetList.size();
		tmp = tmp + valueCharA;
		return (char) tmp;

	}

	private char rotation_minus(char c) {
		int tmp;
		int valueCharA = (int) ('A');

		tmp = (int) c - valueCharA;

		if ((tmp - position) < 0) {
			tmp = (alphabetList.size() + tmp - position) % alphabetList.size();
		} else {
			tmp = (tmp - position) % alphabetList.size();
		}

		tmp = tmp + valueCharA;
		return (char) tmp;

	}

	public ArrayList<String> getCurrentAlphabet() {
		ArrayList<String> cAlphabet = new ArrayList<String>();
		char tmp_char;

		for (int i = 0; i < alphabetList.size(); ++i) {
			tmp_char = alphabetList.get(i).charAt(0);
			cAlphabet.add(Character.toString(rotation_plus(tmp_char)));

		}

		return cAlphabet;
	}

	public ArrayList<String> getCurrentRotor() {
		ArrayList<String> cRotor = new ArrayList<String>();
		char tmp_char;

		for (int i = 0; i < rotor.size(); ++i) {
			tmp_char = rotor.get(i).charAt(0);
			cRotor.add(Character.toString(rotation_minus(tmp_char)));

		}

		return cRotor;
	}

	public int getPositonNormal() {
		return positon_normal;
	}

	public int getPositonInver() {
		return positon_inver;
	}

}
