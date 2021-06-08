package GUI;
import java.awt.BorderLayout;

import javax.swing.*;

import Listener.AddListener;
import Listener.DeleteListener;
import Listener.EditListener;
import Listener.ViewListener;

public class MenuFrame extends JPanel{
	WindowFrame frame;
	
	public MenuFrame(WindowFrame frame){	
		this.frame = frame;
		this.setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		JLabel label = new JLabel("메뉴 선택");
		panel1.add(label);	
		JPanel panel2 = new JPanel();
		
		JButton button1 = new JButton("관리 할목 추가");
		JButton button2 = new JButton("목록 수정");
		JButton button3 = new JButton("목록 삭제");
		JButton button4 = new JButton("목록 확인");
		JButton button5 = new JButton("프로그램 종료");
		
		button1.addActionListener(new AddListener(frame));
		button2.addActionListener(new EditListener(frame));
		button3.addActionListener(new DeleteListener(frame));
		button4.addActionListener(new ViewListener(frame));
		
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		
		this.add(panel1,BorderLayout.NORTH);
		this.add(panel2,BorderLayout.CENTER);
	}
}
