package pl.edu.pw.tele.frontend;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @deprecated
 * @author Lukasz
 *
 */
public class MkoiMenu extends JMenuBar {

	// Plik
	JMenu plik = new JMenu("plik");
	JMenuItem zakoncz = new JMenuItem("Zakoncz");
	//Pomoc
	JMenu pomoc = new JMenu("Pomoc");
	
	
	public MkoiMenu(){
	
		add(plik);
		plik.add(zakoncz);
		add(pomoc);
	}
	
	
	
}
