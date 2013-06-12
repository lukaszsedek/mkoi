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
	
        
        int in_pos, out_pos, in_pos_invert, out_pos_invert;

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
        public int conversion(int i) {
            in_pos = i;
        
          return  out_pos = getCurrentAlphabet().indexOf(getCurrentRotor().get(i));
            
        }
        
        public int conversionInvert(int i ) {
            in_pos_invert = i;
            return  out_pos_invert =  getCurrentRotor().indexOf(getCurrentAlphabet().get(i));
        }
        
	

	public ArrayList<String> getCurrentAlphabet() {
		ArrayList<String> cAlphabet = new ArrayList<String>(alphabetList);
		
                for(int i =0; i < position ; ++i)
                {
                
                    cAlphabet.add(cAlphabet.get(0));
                    cAlphabet.remove(0);
                
                }

		return cAlphabet;
	}

	public ArrayList<String> getCurrentRotor() {
		ArrayList<String> cRotor = new ArrayList<String>(rotor);
		
                
                for(int i =0; i < position; ++i)
                {
                
                    cRotor.add(cRotor.get(0));
                    cRotor.remove(0);
                
                }
       
		return cRotor;
	}

	public int getInPosition() {
		return in_pos;
	}

	public int getOutPosition() {
		return out_pos;
	}
        
        public int getInPositionInvert() {
		return in_pos_invert;
	}

	public int getOutPositionInvert() {
		return out_pos_invert;
	}

}
