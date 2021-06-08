package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.EditMoney;
import GUI.WindowFrame;

public class EditListener implements ActionListener {
	WindowFrame frame;

	public EditListener(WindowFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		EditMoney edit = frame.getEdit();
		frame.setPanel(edit);			
	}
}
