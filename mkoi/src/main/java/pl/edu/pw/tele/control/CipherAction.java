package pl.edu.pw.tele.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import sun.util.logging.resources.logging;

public class CipherAction{

	private CipherAction(){}
	
	public static ActionListener getActionListener()
	{
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		};
	}
	
}
