package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.Income_Expend;
import GUI.WindowFrame;

public class In_ExListener implements ActionListener {
	WindowFrame frame;

	public In_ExListener(WindowFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		Income_Expend IE = frame.getIE();
		frame.setPanel(IE);			
	}
}
