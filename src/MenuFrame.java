import java.awt.BorderLayout;

import javax.swing.*;

public class MenuFrame extends JFrame{
	public MenuFrame(){
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu");		
		JPanel panel1 = new JPanel();
		JLabel label = new JLabel("메뉴 선택");
		panel1.add(label);	
		JPanel panel2 = new JPanel();
		JButton button1 = new JButton("관리 할목 추가");
		JButton button2 = new JButton("목록 수정");
		JButton button3 = new JButton("목록 삭제");
		JButton button4 = new JButton("목록 확인");
		JButton button5 = new JButton("프로그램 종료");
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		this.add(panel1,BorderLayout.NORTH);
		this.add(panel2,BorderLayout.CENTER);
		this.setVisible(true);
	}
}
