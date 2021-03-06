package pl.edu.pw.tele.threads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import pl.edu.pw.tele.Utils;
import pl.edu.pw.tele.enigma.Enigma;
import pl.edu.pw.tele.frontend.InputTextPane;
import pl.edu.pw.tele.frontend.MKOICenter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Helper class for obtaining input values from configuration file<br>
 * Previously class implemeted Runnable interface. Solution was changed
 * due to problem with variables synchronization.
 * Now it's simple POJO file with static methods 
 * @author Lukasz Sedek
 *
 */
public class FileReadIO {
	/**
	 * Log4J local instance
	 */
	static Logger log  = Logger.getLogger(FileReadIO.class.getName());
	
	/**
	 * Default constructor
	 */
	public FileReadIO()
	{
		log.finest("constructing FileReadIO thread object");
	}

	/**
	 * Previously it was run method. Now it's static method with implemented parsing Properties from file
	 */
	public static void go() {
		log.info( "Loading file " + Utils.FILENAME_INTPUT + " in progress...");

		
		Properties prop = new Properties();
        FileInputStream fis;
		try {
			fis = new FileInputStream(Utils.FILENAME_INTPUT);
	        //loading properites from properties file
	        prop.load(fis);
	        // Enigma instance
	        Enigma enigma = Enigma.getInstance();
	        
	        log.info("ALFABET = " + prop.getProperty("alphabet"));
	        
	        // 1.  read alhpaber
	        String tempString = prop.getProperty("alphabet");
	        ArrayList<String> tempArray = new ArrayList<String>();
	        for(int i = 0; i < tempString.length(); i++)
	        {
	        	tempString.charAt(i);
	        	tempArray.add(String.valueOf(tempString.charAt(i)));
	        }
	        enigma.setAlphabet(tempArray);
	        // 2. Read reflector
	        enigma.createReflector(prop.getProperty("reflector"));
	        // 3. Read rotors
	        	        
	       enigma.setRotor1(prop.getProperty("rotor0"), prop.getProperty("rotor0_start"), prop.getProperty("rotor0_turn"));
	       enigma.setRotor2(prop.getProperty("rotor1"), prop.getProperty("rotor1_start"), prop.getProperty("rotor1_turn"));
	       enigma.setRotor3(prop.getProperty("rotor2"), prop.getProperty("rotor2_start"), prop.getProperty("rotor2_turn"));
	       
	       fis.close();
	        InputTextPane.enableInput(true);	        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		MKOICenter.reload();
		log.info("End of IO thread");
	}
	
	

}
