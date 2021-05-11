import java.util.ArrayList;
import java.util.Scanner;

public class MoneyManage {
	ArrayList<Income> income = new ArrayList<Income>();
	ArrayList<Loan> Loan = new ArrayList<Loan>();
	ArrayList<Expend> expend = new ArrayList<Expend>();
	ArrayList<Saving> Saving = new ArrayList<Saving>();
	Scanner input;
	MoneyManage(Scanner input){
		this.input = input;
	}
	
	public void income() {
		System.out.print("������ �޾ҽ��ϱ�?");
		String ans = input.next();
		if(ans.equals("��")) {
			System.out.print("����ݾ��� �Է��Ͻʽÿ� : ");
			int m = input.nextInt();
			String n = "����";
			System.out.print("������������ �Է��Ͻʽÿ� : ");
			double i = input.nextDouble();
			System.out.println("����Ⱓ�� �󸶳� �Ǿ����ϱ�?");
			int month = input.nextInt();
			Loan loan = new Loan(m,n,i,month);
			Expend debt = new Expend(loan.calinterest(),"��������");
			Loan.add(loan);
			expend.add(debt);
		}
		else if(ans.equals("�ƴϿ�")) {
			System.out.print("���Աݾ��� �Է��Ͻʽÿ� : ");
			int m = input.nextInt();
			System.out.print("���Կ��� �Է��Ͻʽÿ� : ");
			String n = input.next();
			Income money = new Income(m,n);
			income.add(money);			
		}
		else {
			System.err.print("�߸��� �Է��Դϴ�.");
		}
	}	
	public void expend() {		
		System.out.print("������ ������ϱ�?");
		String ans = input.next();
		if(ans.equals("��")) {
			System.out.print("���ݾ��� �Է��Ͻʽÿ� : ");
			int m = input.nextInt();
			String n = "����";
			System.out.print("������������ �Է��Ͻʽÿ� : ");
			double i = input.nextDouble();
			System.out.println("���ݱⰣ�� �󸶳� �Ǿ����ϱ�?");
			int month = input.nextInt();
			Saving saving = new Saving(m*month,n,i,month);
			Income interest =new Income(saving.calinterest(),"��������");
			Saving.add(saving);
			income.add(interest);
		}
		else if(ans.equals("�ƴϿ�")) {
			System.out.print("����ݾ��� �Է��Ͻʽÿ� : ");
			int m = input.nextInt();
			System.out.print("������� �Է��Ͻʽÿ� : ");
			String n = input.next();
			Expend money = new Expend(m,n);
			expend.add(money);
		}
		else {
			System.err.print("�߸��� �Է��Դϴ�");
		}
	}
	
	public void edit() {
		for(int i = 0 ; i < income.size() ; i++) {
			income.get(i).Print();
		}
		System.out.println();
		for(int i =0 ; i < Loan.size() ; i++) {
			Loan.get(i).Print();
		}
		System.out.println();
		for(int i = 0 ; i < expend.size() ; i++) {
			expend.get(i).Print();
		}
		System.out.println();
		for(int i =0 ; i < Saving.size() ; i++) {
			Saving.get(i).Print();
		}		
		System.out.println("�����ϰ���� ����� �Է��Ͻʽÿ�(����,����,����,���� �� �ϳ��� �Է�)");
		String ans = input.next();
		System.out.println("���° �׸��� �������� �Է��Ͻʽÿ�");
		int i = input.nextInt() - 1;
		if(ans.equals("����")) {
			if((income.get(i).getName().equals("��������"))){
				System.out.println("�������ڸ� �����Ϸ��� ���ݱݾ��� �������ֽʽÿ�");
			}
			else {
				System.out.print("������ ���Աݾ��� �Է��Ͻʽÿ� : ");
				int money = input.nextInt();
				income.get(i).setMoney(money);
				System.out.print("������ ���Կ��� �Է��Ͻʽÿ� : ");
				String name = input.next();
				income.get(i).setName(name);
			}
		}
		else if(ans.equals("����")) {
			System.out.print("������ ����ݾ��� �Է��Ͻʽÿ� : ");
			int money = input.nextInt();
			income.get(i).setMoney(money);
			System.out.print("������ ������������ �Է��Ͻʽÿ� : ");
			double interest = input.nextDouble();
			System.out.println("������ ����Ⱓ�� �Է��Ͻʽÿ�");
			int month = input.nextInt();
			Loan.get(i).setMoney(money);
			Loan.get(i).setInterest(interest);
			Loan.get(i).setMonth(month);
			for(int j = 0 ; j < expend.size() ; j++) {
				if(expend.get(j).getName().equals("��������")) {
					expend.get(j).setMoney(Loan.get(i).calinterest());
				}
			}
			
		}
		else if(ans.equals("����")) {
			if((expend.get(i).getName().equals("��������"))) {
				System.out.println("�������ڸ� �����Ϸ��� ����ݾ��� �������ֽʽÿ�");
			}
			else{
				System.out.print("������ ����ݾ��� �Է��Ͻʽÿ� : ");
				int money = input.nextInt();
				expend.get(i).setMoney(money);
				System.out.print("������ ������� �Է��Ͻʽÿ� : ");
				String name = input.next();
				expend.get(i).setName(name);
			}
		}	
		else if(ans.equals("����")) {
			System.out.print("������ ���ݱݾ��� �Է��Ͻʽÿ� : ");
			int money = input.nextInt();
			income.get(i).setMoney(money);
			System.out.print("������ ������������ �Է��Ͻʽÿ� : ");
			double interest = input.nextDouble();
			System.out.println("������ ���ݱⰣ�� �Է��Ͻʽÿ�");
			int month = input.nextInt();
			Saving.get(i).setMoney(money*month);
			Saving.get(i).setInterest(interest);
			Saving.get(i).setMonth(month);
			for(int j = 0 ; j < income.size() ; j++) {
				if(income.get(j).getName().equals("��������")) {
					income.get(j).setMoney(Saving.get(i).calinterest());
				}
			}
		}
	}
	
	public void view() {
		System.out.print("� ����� Ȯ���Ͻðڽ��ϱ�?(����,����,����,����,��� �� �ϳ��� �Է�)");
		String v = input.next();
		if(v.equals("����")) {
			for(int i =0 ; i < income.size() ; i++) {
				income.get(i).Print();
			}
			System.out.println();
		}
		else if(v.equals("����")) {
			for(int i =0 ; i < Loan.size() ; i++) {
				Loan.get(i).Print();
			}
		}
		else if(v.equals("����")) {
			for(int i =0 ; i < expend.size() ; i++) {
				expend.get(i).Print();
			}
			System.out.println();
		}
		else if(v.equals("����")){
			for(int i =0 ; i < Saving.size() ; i++) {
				Saving.get(i).Print();
			}	
		}
		else if(v.equals("���")) {
			for(int i = 0 ; i < income.size() ; i++) {
				income.get(i).Print();
			}
			System.out.println();
			for(int i =0 ; i < Loan.size() ; i++) {
				Loan.get(i).Print();
			}
			for(int i = 0 ; i < expend.size() ; i++) {
				expend.get(i).Print();
			}
			System.out.println();
			for(int i =0 ; i < Saving.size() ; i++) {
				Saving.get(i).Print();
			}	
		}
	}		
	public void Exit() {
		System.out.println("���α׷��� �����մϴ�");
	}
}
