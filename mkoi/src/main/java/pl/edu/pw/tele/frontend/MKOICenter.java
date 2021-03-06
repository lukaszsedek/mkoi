package pl.edu.pw.tele.frontend;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import pl.edu.pw.tele.enigma.Enigma;
import pl.edu.pw.tele.enigma.Reflector;
import pl.edu.pw.tele.enigma.Rotor;

/**
 * Central containter for Enigma graphic elements
 *
 * @author Lukasz Sedek
 *
 */
public class MKOICenter extends JPanel {

    /**
     * Font for titles
     */
    protected Font font = new Font("Arial", Font.BOLD, 14);
    /**
     * Log4j logger instance
     */
    private static Logger log = Logger.getLogger(MKOICenter.class.getName());
    /**
     * Relfector Alhpabet List
     */
    protected static JList<String> reflectorAl;
    /**
     * Reflector settings List
     */
    protected static JList<String> reflector;
    /**
     * rotor number 1 settings
     */
    protected static JList<String> rotor1;
    /**
     * rotor number 1 alphabet
     */
    protected static JList<String> rotor1Al;
    /**
     * rotor number 2 settings List
     */
    protected static JList<String> rotor2;
    /**
     * rotor number 2 alhpabet List
     */
    protected static JList<String> rotor2Al;
    /**
     * rotor number 3 settings List
     */
    protected static JList<String> rotor3;
    /**
     * Rotor number 3 alhpabet List
     */
    protected static JList<String> rotor3Al;
    
    protected static JList<String> out_Al;
    protected static JList<String> in_Al;
    
    
    // LUSTRA
    protected static JList<String> rotor1_;
    protected static JList<String> rotor1Al_;
    protected static JList<String> rotor2_;
    protected static JList<String> rotor2Al_;
    protected static JList<String> rotor3_;
    protected static JList<String> rotor3Al_;
    // Listy
    static public DefaultListModel<String> lmRefAl;
    static public DefaultListModel<String> lmRef;
    static public DefaultListModel<String> lmRot1;
    static public DefaultListModel<String> lmRot1Al;
    static public DefaultListModel<String> lmRot2;
    static public DefaultListModel<String> lmRot2Al;
    static public DefaultListModel<String> lmRot3;
    static public DefaultListModel<String> lmRot3Al;
    

    public MKOICenter() {

        // LISTY
        // Reflector
        
       
        lmRefAl = new DefaultListModel<String>();
        lmRef = new DefaultListModel<String>();

        lmRot1 = new DefaultListModel<String>();
        lmRot1Al = new DefaultListModel<String>();
        lmRot2 = new DefaultListModel<String>();
        lmRot2Al = new DefaultListModel<String>();
        lmRot3 = new DefaultListModel<String>();
        lmRot3Al = new DefaultListModel<String>();

        reflector = new JList<String>(lmRef);
        reflector.setBackground(Color.LIGHT_GRAY);
        reflectorAl = new JList<String>(lmRefAl);
        reflectorAl.setBackground(Color.LIGHT_GRAY);
        rotor1 = new JList<String>(lmRot1);
        rotor1.setBackground(Color.YELLOW);
        rotor1Al = new JList<String>(lmRot1Al);
        rotor1Al.setBackground(Color.YELLOW);
        rotor2 = new JList<String>(lmRot2);
        rotor2Al = new JList<String>(lmRot2Al);
        rotor3 = new JList<String>(lmRot3);
        rotor3.setBackground(Color.CYAN);
        rotor3Al = new JList<String>(lmRot3Al);
        rotor3Al.setBackground(Color.CYAN);

        // lustrzane odbicia
        in_Al = new JList<String>(lmRefAl);
        out_Al = new JList<String>(lmRefAl);
        
        
        rotor1_ = new JList<String>(lmRot1);
        rotor1_.setBackground(Color.YELLOW);
        rotor1Al_ = new JList<String>(lmRot1Al);
        rotor1Al_.setBackground(Color.YELLOW);
        rotor2_ = new JList<String>(lmRot2);
        rotor2Al_ = new JList<String>(lmRot2Al);
        rotor3_ = new JList<String>(lmRot3);
        rotor3_.setBackground(Color.CYAN);
        rotor3Al_ = new JList<String>(lmRot3Al);
        rotor3Al_.setBackground(Color.CYAN);
        
        add(out_Al);
        
        add(new JLabel("    "));
        
        add(rotor3_);
        add(rotor3Al_);
        

        add(new JLabel("    "));
        
        add(rotor2_);
        add(rotor2Al_);
        

        add(new JLabel("    "));
        
        add(rotor1_);
        add(rotor1Al_);
        
        add(new JLabel("    "));
        // REFLECTOR
        add(reflectorAl);
        add(reflector);
        
        add(new JLabel("    "));

        // ROTOR 1
        add(rotor1Al);
        add(rotor1);
        
        add(new JLabel("    "));

        // ROTOR 2
        add(rotor2Al);
        add(rotor2);
        
        add(new JLabel("    "));

        // ROTOR3
        add(rotor3Al);
        add(rotor3);
        
        add(new JLabel("    "));
        
        add(in_Al);

        // WYGLAD

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
        MKOICenter.in_Al.setEnabled(false);
        MKOICenter.out_Al.setEnabled(false);


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
        MKOICenter.in_Al.setFont(font);
        MKOICenter.out_Al.setFont(font);

    }

    public static void reload() {

        log.info("dodawanie reflectora");

        Enigma enigma = Enigma.getInstance();

        // ROTOR 3 lustro
        Rotor rotor3 = enigma.getRotor3();
        ArrayList<String> rotor3List = rotor3.getRotor();
        
        lmRot3.clear();
        for (String string : rotor3List) {
            lmRot3.addElement(string);
        }
        ArrayList<String> rotor3AlphabetsList = rotor3.getAlphabetList();
        lmRot3Al.clear();
        for (String string : rotor3AlphabetsList) {
            lmRot3Al.addElement(string);
        }

        // ROTOR 2
        Rotor rotor2 = enigma.getRotor2();
        ArrayList<String> rotor2List = rotor2.getRotor();
        lmRot2.clear();
        for (String string : rotor2List) {
            lmRot2.addElement(string);
        }
        ArrayList<String> rotor2AlphabetsList = rotor2.getAlphabetList();
        lmRot2Al.clear();
        for (String string : rotor2AlphabetsList) {
            lmRot2Al.addElement(string);
        }

        // ROTOR 1
        Rotor rotor1 = enigma.getRotor1();
        ArrayList<String> rotor1List = rotor1.getRotor();
        lmRot1.clear();
        for (String string : rotor1List) {
            lmRot1.addElement(string);
        }
        ArrayList<String> rotor1AlphabetsList = rotor1.getAlphabetList();
        lmRot1Al.clear();
        for (String string : rotor1AlphabetsList) {
            lmRot1Al.addElement(string);
        }

        // REFLECTOR
        Reflector reflector = enigma.getReflector();
        ArrayList<String> reflectorList = reflector.getReflector();
        lmRef.clear();
        for (String string : reflectorList) {
            lmRef.addElement(string);
        }

        ArrayList<String> reflectorAlhpabetList = reflector.getAlphabet();
        lmRefAl.clear();
        for (String string : reflectorAlhpabetList) {
            lmRefAl.addElement(string);
        }


        MKOICenter.rotor3Al_.setSelectedIndex(rotor3.getPosition());
        MKOICenter.rotor3_.setSelectedIndex(rotor3.getPosition());
        MKOICenter.rotor3Al.setSelectedIndex(rotor3.getPosition());
        MKOICenter.rotor3.setSelectedIndex(rotor3.getPosition());
        MKOICenter.rotor1Al_.setSelectedIndex(rotor1.getPosition());
        MKOICenter.rotor1_.setSelectedIndex(rotor1.getPosition());
        MKOICenter.rotor1Al.setSelectedIndex(rotor1.getPosition());
        MKOICenter.rotor1.setSelectedIndex(rotor1.getPosition());
        MKOICenter.rotor2Al_.setSelectedIndex(rotor2.getPosition());
        MKOICenter.rotor2_.setSelectedIndex(rotor2.getPosition());
        MKOICenter.rotor2Al.setSelectedIndex(rotor2.getPosition());
        MKOICenter.rotor2.setSelectedIndex(rotor2.getPosition());
        
        refresh();
    }

    public static void refresh() {

        Enigma enigma = Enigma.getInstance();
        Rotor rotor3 = enigma.getRotor3();
        Rotor rotor2 = enigma.getRotor2();
        Rotor rotor1 = enigma.getRotor1();
        Reflector reflector = enigma.getReflector();

        ArrayList<String> rotor1List = rotor1.getCurrentRotor();
        ArrayList<String> rotor1AlList = rotor1.getCurrentAlphabet();
        ArrayList<String> rotor2List = rotor2.getCurrentRotor();
        ArrayList<String> rotor2AlList = rotor2.getCurrentAlphabet();
        ArrayList<String> rotor3List = rotor3.getCurrentRotor();
        ArrayList<String> rotor3AlList = rotor3.getCurrentAlphabet();

        lmRot3.clear();
        for (String string : rotor3List) {
            lmRot3.addElement(string);
        }
        lmRot3Al.clear();
        for (String string : rotor3AlList) {
            lmRot3Al.addElement(string);
        }

        lmRot2.clear();
        for (String string : rotor2List) {
            lmRot2.addElement(string);
        }
        lmRot2Al.clear();
        for (String string : rotor2AlList) {
            lmRot2Al.addElement(string);
        }

        lmRot1.clear();
        for (String string : rotor1List) {
            lmRot1.addElement(string);
        }
        lmRot1Al.clear();
        for (String string : rotor1AlList) {
            lmRot1Al.addElement(string);
        }
        
        MKOICenter.out_Al.setSelectedIndex(rotor3.getInPosition());
        
        MKOICenter.rotor3Al_.setSelectedIndex(rotor3.getOutPosition());
        MKOICenter.rotor3_.setSelectedIndex(rotor3.getInPosition());
        MKOICenter.rotor3Al.setSelectedIndex(rotor3.getInPositionInvert());
        MKOICenter.rotor3.setSelectedIndex(rotor3.getOutPositionInvert());
        
        MKOICenter.rotor1Al_.setSelectedIndex(rotor1.getOutPosition());
        MKOICenter.rotor1_.setSelectedIndex(rotor1.getInPosition());
        MKOICenter.rotor1Al.setSelectedIndex(rotor1.getInPositionInvert());
        MKOICenter.rotor1.setSelectedIndex(rotor1.getOutPositionInvert());
        
        MKOICenter.rotor2Al_.setSelectedIndex(rotor2.getOutPosition());
        MKOICenter.rotor2_.setSelectedIndex(rotor2.getInPosition());
        MKOICenter.rotor2Al.setSelectedIndex(rotor2.getInPositionInvert());
        MKOICenter.rotor2.setSelectedIndex(rotor2.getOutPositionInvert());
        
        MKOICenter.in_Al.setSelectedIndex(rotor3.getOutPositionInvert());
        MKOICenter.out_Al.setSelectedIndex(rotor3.getInPosition());
        
        MKOICenter.reflectorAl.setSelectedIndex(reflector.getInPosition());
        MKOICenter.reflector.setSelectedIndex(reflector.getOutPosition());
        
    }
}
