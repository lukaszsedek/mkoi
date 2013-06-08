package pl.edu.pw.tele.frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Logger;

import javax.print.attribute.standard.MediaSize.Engineering;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.SliderUI;

import pl.edu.pw.tele.Utils;
import pl.edu.pw.tele.enigma.Enigma;
import pl.edu.pw.tele.enigma.Reflector;
import pl.edu.pw.tele.enigma.Rotor;

public class MKOICenter extends JPanel {

	Font font = new Font("Arial", Font.PLAIN, 14);
	static Logger log = Logger.getLogger(MKOICenter.class.getName());
	static JList reflectorAl;
	static JList reflector;
	protected static JList rotor1;
	protected static JList rotor1Al;
	protected static JList rotor2;
	protected static JList rotor2Al;
	protected static JList rotor3;
	protected static JList rotor3Al;
	
	//LUSTRA
	protected static JList rotor1_;
	protected static JList rotor1Al_;
	protected static JList rotor2_;
	protected static JList rotor2Al_;
	protected static JList rotor3_;
	protected static JList rotor3Al_;

	

	//Listy
	static public DefaultListModel lmRefAl;
	static public DefaultListModel lmRef;
	static public DefaultListModel lmRot1;
	static public DefaultListModel lmRot1Al;
	static public DefaultListModel lmRot2;
	static public DefaultListModel lmRot2Al;
	static public DefaultListModel lmRot3;
	static public DefaultListModel lmRot3Al;

	static String[] dupa = new String[] { "empty", "empty", "empty", "empty" };

	public MKOICenter() {

		
		
		// LISTY
		lmRefAl = new DefaultListModel();
		lmRef = new DefaultListModel();
		lmRot1 = new DefaultListModel();
		lmRot1Al = new DefaultListModel();
		lmRot2 = new DefaultListModel();
		lmRot2Al = new DefaultListModel();
		lmRot3 = new DefaultListModel();
		lmRot3Al = new DefaultListModel();

		reflector = new JList(lmRef);
		reflector.setBackground(Color.LIGHT_GRAY);
		reflectorAl = new JList(lmRefAl);
		reflectorAl.setBackground(Color.LIGHT_GRAY);
		rotor1 = new JList(lmRot1);
		rotor1.setBackground(Color.YELLOW);
		rotor1Al = new JList(lmRot1Al);
		rotor1Al.setBackground(Color.YELLOW);
		rotor2 = new JList(lmRot2);
		rotor2Al = new JList(lmRot2Al);
		rotor3 = new JList(lmRot3);
		rotor3.setBackground(Color.CYAN);
		rotor3Al = new JList(lmRot3Al);
		rotor3Al.setBackground(Color.CYAN);
		
		//lustrzane odbicia
		
		rotor1_ = new JList(lmRot1);
		rotor1_.setBackground(Color.YELLOW);
		rotor1Al_ = new JList(lmRot1Al);
		rotor1Al_.setBackground(Color.YELLOW);
		rotor2_ = new JList(lmRot2);
		rotor2Al_ = new JList(lmRot2Al);
		rotor3_ = new JList(lmRot3);
		rotor3_.setBackground(Color.CYAN);
		rotor3Al_ = new JList(lmRot3Al);
		rotor3Al_.setBackground(Color.CYAN);
		add(rotor3Al_);
		add(rotor3_);	
		add(new JLabel("    "));
		add(rotor2Al_);
		add(rotor2_);
		add(new JLabel("    "));
		add(rotor1Al_);
		add(rotor1_);
		add(new JLabel("    "));
		// REFLECTOR

		add(reflector);
		add(reflectorAl);
		add(new JLabel("    "));

		// ROTOR 1

		add(rotor1);
		add(rotor1Al);
		add(new JLabel("    "));

		// ROTOR 2

		add(rotor2);
		add(rotor2Al);
		add(new JLabel("    "));

		// ROTOR3
		add(rotor3);
		add(rotor3Al);

		MKOICenter.rotor3Al_.setEnabled(false);
		MKOICenter.rotor3_.setEnabled(false);
		MKOICenter.rotor3Al.setEnabled(false);
		MKOICenter.rotor3.setEnabled(false);
		MKOICenter.rotor1Al_.setEnabled(false);
		MKOICenter.rotor1_.setEnabled(false);
		MKOICenter.rotor1Al.setEnabled(false);
		MKOICenter.rotor1.setEnabled(false);
		MKOICenter.rotor2Al_.setEnabled(false);
		MKOICenter.rotor2_.setEnabled(false);
		MKOICenter.rotor2Al.setEnabled(false);
		MKOICenter.rotor2.setEnabled(false);
		MKOICenter.reflectorAl.setEnabled(false);
		MKOICenter.reflector.setEnabled(false);
		
		MKOICenter.rotor3Al_.setFont(font);
		MKOICenter.rotor3_.setFont(font);
		MKOICenter.rotor3Al.setFont(font);
		MKOICenter.rotor3.setFont(font);
		MKOICenter.rotor1Al_.setFont(font);
		MKOICenter.rotor1_.setFont(font);
		MKOICenter.rotor1Al.setFont(font);
		MKOICenter.rotor1.setFont(font);
		MKOICenter.rotor2Al_.setFont(font);
		MKOICenter.rotor2_.setFont(font);
		MKOICenter.rotor2Al.setFont(font);
		MKOICenter.rotor2.setFont(font);
		MKOICenter.reflectorAl.setFont(font);
		MKOICenter.reflector.setFont(font);


		

	}

	public static void reload() {
		
		log.info("dodawanie reflectora");
		/**
		 * 
		 */
		Enigma enigma = Enigma.getInstance();
		Reflector ref = enigma.getReflector();

		log.info("REF.SIZE=" + ref.getAlfabet().length);
		char[] alfabet = ref.getAlfabet();
		for (int i = 0; i < alfabet.length; i++) {

			lmRefAl.addElement(alfabet[i]);
		}
		/**
		 * Dowanianie reflektora
		 */
		char[] reflector = ref.getReflector();
		for (int i = 0; i < reflector.length; i++) {

			lmRef.addElement(reflector[i]);
		}


		/**
		 * Dodawanie rotora 1
		 */

		Rotor rotor1 = enigma.getRotor1();
		int rot1Size = rotor1.getSize();
		char[] _rotor1 = new char[rot1Size];
		_rotor1 = rotor1.getRotor();
		char[] _rotor1al = rotor1.getAlphabet();

		for (int i = 0; i < rot1Size; ++i) {
			lmRot1.addElement(_rotor1[i]);
			lmRot1Al.addElement(_rotor1al[i]);
		}
		
		MKOICenter.rotor1.setSelectedIndex(rotor1.getPosition());
		MKOICenter.rotor1Al.setSelectedIndex(rotor1.getPosition());
		MKOICenter.rotor1_.setSelectedIndex(rotor1.getPosition());
		MKOICenter.rotor1Al_.setSelectedIndex(rotor1.getPosition());
		
		// ROTOR 2
		Rotor rotor2 = enigma.getRotor2();
		int rot2Size = rotor2.getSize();
		char[] _rotor2 = new char[rot2Size];
		_rotor2 = rotor2.getRotor();
		char[] _rotor2al = rotor2.getAlphabet();

		for (int i = 0; i < rot2Size; ++i) {
			lmRot2.addElement(_rotor2[i]);
			lmRot2Al.addElement(_rotor2al[i]);
		}

		MKOICenter.rotor2.setSelectedIndex(rotor2.getPosition());
		MKOICenter.rotor2Al.setSelectedIndex(rotor2.getPosition());
		MKOICenter.rotor2_.setSelectedIndex(rotor2.getPosition());
		MKOICenter.rotor2Al_.setSelectedIndex(rotor2.getPosition());
		
		// ROTOR 3
		Rotor rotor3 = enigma.getRotor3();
		int rot3Size = rotor3.getSize();
		char[] _rotor3 = new char[rot3Size];
		_rotor3 = rotor3.getRotor();
		char[] _rotor3al = rotor3.getAlphabet();

		for (int i = 0; i < rot3Size; ++i) {
			lmRot3.addElement(_rotor3[i]);
			lmRot3Al.addElement(_rotor3al[i]);
			
		}
		
		MKOICenter.rotor3.setSelectedIndex(rotor3.getPosition());
		MKOICenter.rotor3Al.setSelectedIndex(rotor3.getPosition());
		MKOICenter.rotor3_.setSelectedIndex(rotor3.getPosition());
		MKOICenter.rotor3Al_.setSelectedIndex(rotor3.getPosition());
		

	}
}
