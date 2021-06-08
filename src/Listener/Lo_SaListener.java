package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.AddMoney;
import GUI.Loan_Saving;
import GUI.WindowFrame;

public class Lo_SaListener implements ActionListener {
	WindowFrame frame;

	public Lo_SaListener(WindowFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		Loan_Saving LS = frame.getLS();
		frame.setPanel(LS);			
	}
}
