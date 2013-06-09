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
        int turnover_positions = 0; 
         
	
	/**
	 * reprezentacja alfabetu
	 */
	ArrayList<String> alphabetList = Enigma.getInstance().alphabet;
        
        
	int count = alphabetList.size(); 
	/**
	 * reprezentacja rotora
	 */
	ArrayList<String> rotor = new ArrayList<String>();
	
	public Rotor(){}
	
	public Rotor(String settings, String poz, String turn){
		log.info("Tworzenie rotora..." + settings + " pozycja " + poz + " pozycja obrotu " + turn);
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
                
                for(int i = 0 ; i < alphabetList.size(); ++i)
		{
			if(turn.equals(alphabetList.get(i)))
			{
				turnover_positions = i + 1;
			}
		}
                log.info("ROTOR.turnover_positions = " + this.turnover_positions);
	}

	@Override
	public int getSize() {
		return rotor.size();
	}

	public int getPosition() {
		return position;
	}
        
        public int getTurnoverPositions() {
		return turnover_positions;
	}
        
        public void setTurnoverPositions(int turnover_positions ) {
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

	
	public void  move()
	{
		
                position = (position + 1)% alphabetList.size();
                count = (count + 1) % 255;
		
	}
        
        public void  restart()
	{
		
                count = 0;
		
	}
        
        public int getCount()
        {
            return count;
        }
        
      
        @Override
        public char conversion(char c)
        {
            int index = -1;
            int tmp;
            int valueCharA = (int)('A'); 

            
            tmp = (int)c - valueCharA;
            tmp = ( tmp + position ) % alphabetList.size();
            tmp = tmp + valueCharA;          
            c = (char)tmp;

            
            for(int i = 0 ; i < alphabetList.size(); ++i)
		{
			if(Character.toString(c).equals(alphabetList.get(i)))
			{
				index = i;
			}
		}
            
            
            tmp = (int)rotor.get(index).charAt(0) - valueCharA;

            if ((tmp - position) < 0)
            {
                tmp = ( alphabetList.size() + tmp - position ) % alphabetList.size();
            }
            else
            {
                tmp = ( tmp - position ) % alphabetList.size();
            }
            
            
            return (char)(tmp + valueCharA);
        }
        
        public char conversionInvert(char c)
        {
            int index = -1;
            int tmp;
            int valueCharA = (int)('A'); 

            
            tmp = (int)c - valueCharA;
            tmp = ( tmp + position ) % alphabetList.size();
            tmp = tmp + valueCharA;          
            c = (char)tmp;

            
            for(int i = 0 ; i < alphabetList.size(); ++i)
		{
			if(Character.toString(c).equals(rotor.get(i)))
			{
				index = i;
			}
		}
            
            
            tmp = (int)alphabetList.get(index).charAt(0) - valueCharA;

            if ((tmp - position) < 0)
            {
                tmp = ( alphabetList.size() + tmp - position ) % alphabetList.size();
            }
            else
            {
                tmp = ( tmp - position ) % alphabetList.size();
            }
            
            
            return (char)(tmp + valueCharA);
        }
        
        
        
}
