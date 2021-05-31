import java.awt.BorderLayout;

import javax.swing.*;

public class AddMoney extends JFrame {
	public AddMoney(){
		this.setSize(300,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Add Money");
		JPanel panel = new JPanel();
		JButton button1 = new JButton("수입");
		JButton button2 = new JButton("지출");
		JButton button3 = new JButton("대출");
		JButton button4 = new JButton("적금");
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		this.add(panel,BorderLayout.CENTER);
		this.setVisible(true);
	}
}
