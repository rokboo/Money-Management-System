import java.util.ArrayList;
import java.util.Scanner;

public class MoneyManage {
	ArrayList<Money> income = new ArrayList<Money>();
	ArrayList<Loan> Loan = new ArrayList<Loan>();
	ArrayList<Money> expend = new ArrayList<Money>();
	ArrayList<Saving> Saving = new ArrayList<Saving>();
	Scanner input;
	MoneyManage(Scanner input){
		this.input = input;
	}
	
	public void income() {
		System.out.print("Did you get a loan?");
		String ans = input.next();
		if(ans.equals("yes")) {
			System.out.print("Enter your loan money : ");
			int m = input.nextInt();
			String n = "대출";
			System.out.print("Enter loan interst : ");
			int i = input.nextInt();
			System.out.println("How many months have passed?");
			int month = input.nextInt();
			Loan loan = new Loan(m,n,i,month);
			Money debt = new Money(loan.debt(m,i,month),"대출이자");
			Loan.add(loan);
			expend.add(debt);
		}
		else if(ans.equals("no")) {
			System.out.print("Enter your income : ");
			int m = input.nextInt();
			System.out.print("Enter your income name : ");
			String n = input.next();
			Money money = new Money(m,n);
			income.add(money);			
		}
		else {
			System.err.print("You wrote wrong answer");
		}
	}	
	public void expend() {		
		System.out.print("Did you save a money?");
		String ans = input.next();
		if(ans.equals("yes")) {
			System.out.print("Enter your saving money : ");
			int m = input.nextInt();
			String n = "적금";
			System.out.print("Enter saving interst : ");
			int i = input.nextInt();
			System.out.println("How many months have passed?");
			int month = input.nextInt();
			Saving saving = new Saving(m*month,n,i,month);
			Money interest =new Money(saving.saving_income(m,i,month),"적금이자");
			Saving.add(saving);
			income.add(interest);
		}
		else if(ans.equals("no")) {
			System.out.print("Enter your expenditure : ");
			int m = input.nextInt();
			System.out.print("Enter your expenditure name : ");
			String n = input.next();
			Money money = new Money(m,n);
			expend.add(money);
		}
		else {
			System.err.print("You wrote wrong answer");
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
		System.out.println("Which one do you want to edit?(Enter income, expend, loan, saving and number)");
		String ans = input.next();
		System.out.println("Enter the number)");
		int i = input.nextInt() - 1;
		if(ans.equals("income")) {
			if((income.get(i).getName().equals("적금이자"))){
				System.out.println("If you want to edit saving income, you need to edit Saving");
			}
			else {
				System.out.print("Enter your income : ");
				int money = input.nextInt();
				income.get(i).setMoney(money);
				System.out.print("Enter your income name : ");
				String name = input.next();
				income.get(i).setName(name);
			}
		}
		else if(ans.equals("loan")) {
			System.out.print("Enter your loan money : ");
			int money = input.nextInt();
			income.get(i).setMoney(money);
			System.out.print("Enter your loan interest : ");
			int interest = input.nextInt();
			System.out.println("How many months have passed?");
			int month = input.nextInt();
			Loan.get(i).setMoney(money);
			Loan.get(i).setInterest(interest);
			Loan.get(i).setLoan_month(month);
			int debt = money*interest*month/100;
			for(int j = 0 ; j < expend.size() ; j++) {
				if(expend.get(j).getName().equals("대출이자")) {
					expend.get(j).setMoney(debt);
				}
			}
			
		}
		else if(ans.equals("expend")) {
			if((expend.get(i).getName().equals("대출이자"))) {
				System.out.println("If you want to edit saving income, you need to edit Loan");
			}
			else{
				System.out.print("Enter your expenditure : ");
				int money = input.nextInt();
				expend.get(i).setMoney(money);
				System.out.print("Enter your expenditure name : ");
				String name = input.next();
				expend.get(i).setName(name);
			}
		}	
		else if(ans.equals("saving")) {
			System.out.print("Enter your saving money : ");
			int money = input.nextInt();
			income.get(i).setMoney(money);
			System.out.print("Enter your saving interest : ");
			int interest = input.nextInt();
			System.out.println("How many months have passed?");
			int month = input.nextInt();
			Saving.get(i).setMoney(money);
			Saving.get(i).setSaving_interest(interest);
			Saving.get(i).setSaving_month(month);
			int debt = money*interest*month/100;
			for(int j = 0 ; j < income.size() ; j++) {
				if(income.get(j).getName().equals("적금이자")) {
					income.get(j).setMoney(debt);
				}
			}
		}
	}
	
	public void view() {
		System.out.print("What do you want to view?");
		String v = input.next();
		if(v.equals("income")) {
			for(int i =0 ; i < income.size() ; i++) {
				income.get(i).Print();
			}
			System.out.println();
		}
		else if(v.equals("loan")) {
			for(int i =0 ; i < Loan.size() ; i++) {
				Loan.get(i).Print();
			}
		}
		else if(v.equals("expend")) {
			for(int i =0 ; i < expend.size() ; i++) {
				expend.get(i).Print();
			}
			System.out.println();
		}
		else if(v.equals("saving")){
			for(int i =0 ; i < Saving.size() ; i++) {
				Saving.get(i).Print();
			}	
		}
		else if(v.equals("all")) {
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
		System.out.println("Exit program");
	}
}
