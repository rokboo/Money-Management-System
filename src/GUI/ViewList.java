package GUI;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Menu.MoneyManage;
import Money.Expend;
import Money.Income;
import Money.Loan;
import Money.Saving;

public class ViewList extends JPanel{
	WindowFrame frame;
	MoneyManage manage;
	
	public ViewList(WindowFrame frame,MoneyManage manage){
		this.frame = frame;
		this.manage = manage;
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("목록");
		model.addColumn("금액");
		model.addColumn("이자율");
		model.addColumn("기간");
		
		for(int i = 0; i < manage.InSize();i++) {
			Vector row = new Vector();
			Income in = manage.getIn(i);
			row.add(in.getName());
			row.add(in.getMoney());
			model.addRow(row);
		}
		
		for(int i = 0; i < manage.ExSize();i++) {
			Vector row = new Vector();
			Expend ex = manage.getEx(i);
			row.add(ex.getName());
			row.add(ex.getMoney());
			model.addRow(row);
		}
		
		for(int i = 0; i < manage.LoSize();i++) {
			Vector row = new Vector();
			Loan lo = manage.getLo(i);
			row.add(lo.getName());
			row.add(lo.getMoney());
			row.add(lo.getInterest());
			row.add(lo.getMonth());
			model.addRow(row);
		}
		
		for(int i = 0; i < manage.SaSize();i++) {
			Vector row = new Vector();
			Saving sa = manage.getSa(i);
			row.add(sa.getName());
			row.add(sa.getMoney());
			row.add(sa.getInterest());
			row.add(sa.getMonth());
			model.addRow(row);
		}
		
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);	
		this.add(scroll);
	}
}
