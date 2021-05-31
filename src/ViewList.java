import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewList extends JFrame{
	public ViewList(){
		this.setSize(600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("View Money List");
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("목록");
		model.addColumn("금액");
		model.addColumn("이자율");
		model.addColumn("기간");
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);	
		this.add(scroll);
		this.setVisible(true);
	}
}
