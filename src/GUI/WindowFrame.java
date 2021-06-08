package GUI;
import javax.swing.*;

import Menu.MoneyManage;

public class WindowFrame extends JFrame{
	MoneyManage manage;
	MenuFrame menu;
	AddMoney add;
	Income_Expend IE;
	Loan_Saving LS;
	ViewList view;
	EditMoney edit;
	DeleteMoney del;

	public WindowFrame(MoneyManage manage) {
		this.setSize(800,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.manage = manage;

		this.menu = new MenuFrame(this);
		this.add = new AddMoney(this);
		this.IE = new Income_Expend(this);
		this.LS = new Loan_Saving(this);
		this.view = new ViewList(this,this.manage);		
		this.edit = new EditMoney(this);
		this.del = new DeleteMoney(this);
		
		this.setPanel(menu);
		
		this.setVisible(true);
	}
	
	public void setPanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.revalidate();
		this.repaint();
	}
	
	public MenuFrame getMenu() {
		return menu;
	}

	public void setMenu(MenuFrame menu) {
		this.menu = menu;
	}

	public AddMoney getAdd() {
		return add;
	}

	public void setAdd(AddMoney add) {
		this.add = add;
	}

	public Income_Expend getIE() {
		return IE;
	}

	public void setIE(Income_Expend iE) {
		IE = iE;
	}

	public Loan_Saving getLS() {
		return LS;
	}

	public void setLS(Loan_Saving lS) {
		LS = lS;
	}

	public ViewList getView() {
		return view;
	}

	public void setView(ViewList view) {
		this.view = view;
	}

	public EditMoney getEdit() {
		return edit;
	}

	public void setEdit(EditMoney edit) {
		this.edit = edit;
	}

	public DeleteMoney getDel() {
		return del;
	}

	public void setDel(DeleteMoney del) {
		this.del = del;
	}
}
