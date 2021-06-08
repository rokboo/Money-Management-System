package GUI;
import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Listener.In_ExListener;
import Listener.Lo_SaListener;

public class EditMoney extends JPanel {
	WindowFrame frame;
	
	public EditMoney(WindowFrame frame){
		this.frame = frame;
		this.setLayout(new BorderLayout());
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("목록");
		model.addColumn("금액");
		model.addColumn("이자율");
		model.addColumn("기간");
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);	
		JPanel panel1 = new JPanel();
		
		JButton button1 = new JButton("수입");
		JButton button2 = new JButton("지출");
		JButton button3 = new JButton("대출");
		JButton button4 = new JButton("적금");
		JLabel label = new JLabel("수정할 목록이 몇번째인지 입력하시오");
		JTextField text = new JTextField(10);
		
		button1.addActionListener(new In_ExListener(frame));
		button2.addActionListener(new In_ExListener(frame));
		button3.addActionListener(new Lo_SaListener(frame));
		button4.addActionListener(new Lo_SaListener(frame));
		
		panel1.add(label);
		panel1.add(text);
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);		
		this.add(scroll);
		this.add(panel1,BorderLayout.SOUTH);
	}
}
