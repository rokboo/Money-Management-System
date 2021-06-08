package GUI;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class Loan_Saving extends JPanel{
	WindowFrame frame;
	
	public Loan_Saving(WindowFrame frame){
		this.frame  = frame;
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel label1 = new JLabel("금액 ",JLabel.TRAILING);
		gbc.gridx=0;
		gbc.gridy=0;
		panel.add(label1,gbc);
		JTextField text1 = new JTextField(10);
		label1.setLabelFor(text1);
		gbc.gridx=4;
		gbc.gridy=0;
		panel.add(text1,gbc);
		JLabel label2 = new JLabel("이자율 ",JLabel.TRAILING);
		gbc.gridx=0;
		gbc.gridy=1;
		panel.add(label2,gbc);
		JTextField text2 = new JTextField(10);
		label2.setLabelFor(text2);
		gbc.gridx=4;
		gbc.gridy=1;
		panel.add(text2,gbc);
		JLabel label3 = new JLabel("기간 ",JLabel.TRAILING);
		gbc.gridx=0;
		gbc.gridy=2;
		panel.add(label3,gbc);
		JTextField text3 = new JTextField(10);
		label3.setLabelFor(text2);
		gbc.gridx=4;
		gbc.gridy=2;
		panel.add(text3,gbc);
		JButton button1 = new JButton("수정");
		gbc.gridx=1;
		gbc.gridy=3;
		gbc.gridwidth=2;
		panel.add(button1,gbc);			
		JButton button2 = new JButton("취소");
		gbc.gridx=3;
		gbc.gridy=3;
		gbc.gridwidth=2;
		panel.add(button2,gbc);	
		this.add(panel);
	}
}