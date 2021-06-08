package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.DeleteMoney;
import GUI.WindowFrame;

public class DeleteListener implements ActionListener {
	WindowFrame frame;

	public DeleteListener(WindowFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		DeleteMoney del = frame.getDel();
		frame.setPanel(del);			
	}
}