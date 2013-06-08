package pl.edu.pw.tele.enigma;

public interface EnigmaInterface {

	/**
	 * 
	 * @param s ci¹g alfabetu
	 * @param i d³ugoœæ alfabetu
	 */
	void createReflector(String s);
	void createRotors(int i);
	void setNbrRotors(int i);
	int getNbrRotors();
	void setRotor(int i, String s);
}
