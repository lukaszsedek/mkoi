package pl.edu.pw.tele.enigma;

import java.util.ArrayList;
import java.util.logging.Logger;

import pl.edu.pw.tele.frontend.MKOICenter;

/**
 * 
 * @author Lukasz
 *
 */
public class Rotor implements RotorInterface{

	Logger log = Logger.getLogger(Rotor.class.getName());
	int position = 0;
	
	/**
	 * reprezentacja alfabetu
	 */
	ArrayList<String> alphabetList = Enigma.getInstance().alphabet;
	
	/**
	 * reprezentacja rotora
	 */
	ArrayList<String> rotor = new ArrayList<String>();
	
	public Rotor(){}
	
	public Rotor(String settings, String poz){
		log.info("Tworzenie rotora..." + settings + " pozycja " + poz);
		for(int i = 0 ; i < settings.length(); i++)
		
		{
			rotor.add(String.valueOf(settings.charAt(i)));
		}
		log.info("ROTOR = " + rotor.toString());
		
		for(int i = 0 ; i < alphabetList.size(); ++i)
		{
			if(poz.equals(alphabetList.get(i)))
			{
				position = i;
			}
		}
		
		log.info("ROTOR.position = " + this.position);
	}

	@Override
	public int getSize() {
		return rotor.size();
	}

	public int getPosition() {
		return position;
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

	
	public void  move()
	{
		position++;
		
	}
}
