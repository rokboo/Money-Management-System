import java.util.ArrayList;
import java.util.Scanner;

public class MoneyManage {
	ArrayList<Money> income = new ArrayList<Money>();
	ArrayList<Money> expend = new ArrayList<Money>();
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
			String n = "¥Î√‚";
			System.out.print("Enter interst : ");
			int i = input.nextInt();			
			Loan loan = new Loan(m,n,i);
			income.add(loan);
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
		System.out.print("Enter your expenditure : ");
		int m = input.nextInt();
		System.out.print("Enter your expenditure name : ");
		String n = input.next();
		Money money = new Money(m,n);
		expend.add(money);
	}
	
	public void edit() {
		for(int i =0 ; i < income.size() ; i++) {
			System.out.println(income.get(i).name + " : " + income.get(i).money);
		}
		System.out.println();
		for(int i =0 ; i < expend.size() ; i++) {
			System.out.println(expend.get(i).name + " : " + expend.get(i).money);
		}
		System.out.println("Which one do you want to edit?(Enter the income or expend and number)");
		String ans = input.next();
		System.out.println("Enter the number)");
		int i = input.nextInt() - 1;
		if(ans.equals("income")) {
			System.out.print("Enter your income : ");
			income.get(i).money = input.nextInt();
			System.out.print("Enter your income name : ");
			income.get(i).name = input.next();
		}
		else if(ans.equals("expend")) {
			System.out.print("Enter your expenditure : ");
			expend.get(i).money = input.nextInt();
			System.out.print("Enter your expenditure name : ");
			expend.get(i).name = input.next();
			}		
	}
	
	public void view() {
		System.out.print("What do you want to view?");
		String v = input.next();
		if(v.equals("income")) {
			for(int i = 0 ; i < income.size() ; i++) {
			System.out.print(income.get(i).name + " : " + income.get(i).money + " "); 
			}
			System.out.println();
		}
		else if(v.equals("expend")) {
			for(int i = 0 ; i < expend.size() ; i++) {
				System.out.print(expend.get(i).name + " : " + expend.get(i).money + " "); 
			}
			System.out.println();
		}
		else if(v.equals("all")) {
			for(int i = 0 ; i < income.size() ; i++) {
				System.out.print(income.get(i).name + " : " + income.get(i).money + " "); 
			}
			System.out.println();
			for(int i = 0 ; i < expend.size() ; i++) {
				System.out.print(expend.get(i).name + " : " + expend.get(i).money + " ");  
			}
			System.out.println();
		}
	}
		
	public void Exit() {
		System.out.println("Exit program");
	}
}
