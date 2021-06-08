package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.ViewList;
import GUI.WindowFrame;

public class ViewListener implements ActionListener {
	WindowFrame frame;

	public ViewListener(WindowFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		ViewList view = frame.getView();
		frame.setPanel(view);			
	}
}
