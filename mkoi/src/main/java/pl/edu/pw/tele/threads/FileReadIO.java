package pl.edu.pw.tele.threads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import pl.edu.pw.tele.Utils;
import pl.edu.pw.tele.enigma.Enigma;
import pl.edu.pw.tele.frontend.InputTextPane;
import pl.edu.pw.tele.frontend.MKOICenter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class FileReadIO {
	static Logger log  = Logger.getLogger(FileReadIO.class.getName());
	
	public FileReadIO()
	{
		log.info("constructing FileReadIO thread object");
	}

	
	public static void go() {
		log.info( "Loading file " + Utils.FILENAME_INTPUT + " in progress...");

		
		Properties prop = new Properties();
        FileInputStream fis;
		try {
			fis = new FileInputStream(Utils.FILENAME_INTPUT);
	        //loading properites from properties file
	        prop.load(fis);

	        Enigma enigma = Enigma.getInstance();
	        
	        log.info("ALFABET = " + prop.getProperty("alphabet"));
	        
	        // 1.  Wczytaj alfabet
	        enigma.setAlphabet(prop.getProperty("alphabet").toCharArray());
	        // 2. Wczytaj reflector
	        enigma.createReflector(prop.getProperty("reflector"));
	        // 3. Wczytaj rotory
	        	        
	       enigma.setRotor1(prop.getProperty("rotor0"), prop.getProperty("rotor0_start"));
	       enigma.setRotor2(prop.getProperty("rotor1"), prop.getProperty("rotor1_start"));
	       enigma.setRotor3(prop.getProperty("rotor2"), prop.getProperty("rotor2_start"));
	       
	        fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		MKOICenter.reload();
		
		log.info("End of IO thread");
	}
	
	

}