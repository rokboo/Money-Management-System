package GUI;
import java.awt.BorderLayout;

import javax.swing.*;

import Listener.In_ExListener;
import Listener.Lo_SaListener;

public class AddMoney extends JPanel {
	WindowFrame frame;
	
	public AddMoney(WindowFrame frame){
		this.frame = frame;
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		JButton button1 = new JButton("수입");
		JButton button2 = new JButton("지출");
		JButton button3 = new JButton("대출");
		JButton button4 = new JButton("적금");
		
		button1.addActionListener(new In_ExListener(frame));
		button2.addActionListener(new In_ExListener(frame));
		button3.addActionListener(new Lo_SaListener(frame));
		button4.addActionListener(new Lo_SaListener(frame));
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		this.add(panel,BorderLayout.CENTER);
	}
}
