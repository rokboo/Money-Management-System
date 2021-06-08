package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.AddMoney;
import GUI.WindowFrame;

public class AddListener implements ActionListener {
	WindowFrame frame;

	public AddListener(WindowFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		AddMoney add = frame.getAdd();
		frame.setPanel(add);			
	}
}
