package pl.edu.pw.tele.threads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import pl.edu.pw.tele.Utils;
import pl.edu.pw.tele.frontend.InputTextPane;

public class FileReadIO implements Runnable{
	Logger log  = Logger.getLogger(FileReadIO.class.getName());
	
	public FileReadIO()
	{
		log.info("constructing FileReadIO thread object");
	}

	@Override
	public void run() {
		log.info( "Loading file " + Utils.FILENAME_INTPUT + " in progress...");
		File file = new File(Utils.FILENAME_INTPUT);
		
		// pipe stream to file
		try {
			StringBuilder sb = new StringBuilder();
		    String NL = System.getProperty("line.separator");
		    Scanner scanner = new Scanner(new FileInputStream(Utils.FILENAME_INTPUT), "UTF-8");
		    try {
		      while (scanner.hasNextLine()){
		        sb.append(scanner.nextLine() + NL);
		      }
		    }
		    finally{
		      scanner.close();
		    }
		    Utils.Input = sb.toString();
		    InputTextPane.setText(Utils.Input);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("End of IO thread");
	}
	
	

}
