package pl.edu.pw.tele.enigma;

public interface EnigmaInterface {

	/**
	 * 
	 * @param s ci�g alfabetu
	 * @param i d�ugo�� alfabetu
	 */
	void createReflector(String s);
	void createRotors(int i);
	void setNbrRotors(int i);
	int getNbrRotors();
	void setRotor(int i, String s);
}
