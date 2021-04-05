import java.util.Scanner;

public class MoneyManage {
	Money money, money1;
	Scanner input;
	MoneyManage(Scanner input){
		this.input = input;
	}
	
	public void income(int a, int b) {
		money = new Money();
		money.money = new int[b];
		money.name = new String[b];
		while(a < b){				
			System.out.print("Enter your income : ");
			money.money[a] = input.nextInt();
			System.out.print("Enter your income name : ");
			money.name[a] = input.next();
			a = a + 1;
		}
	}
	
	public void expend(int a, int b) {
		money1 = new Money();
		money1.money = new int[b];
		money1.name = new String[b];
		while(a < b){
			System.out.print("Enter your expenditure : ");
			money1.money[a] = input.nextInt();
			System.out.print("Enter your expenditure name : ");
			money1.name[a] = input.next();
			a = a + 1;			
		}
	}
	
	public void edit(int a, int b) {
		for(int i =0 ; i < a ; i++) {
			System.out.println(money.name[i] + " : " + money.money[i]);
		}
		System.out.println();
		for(int i =0 ; i < b ; i++) {
			System.out.println(money1.name[i] + " : " + money1.money[i]);
		}
		System.out.println("Which one do you want to edit?(Enter the income or expend and number)");
		String ans = input.next();
		int i = input.nextInt() - 1;
		if(ans.equals("income")) {
			System.out.print("Enter your income : ");
			money.money[i] = input.nextInt();
			System.out.print("Enter your income name : ");
			money.name[i] = input.next();
		}
		else if(ans.equals("expend")) {
			System.out.print("Enter your expenditure : ");
			money1.money[i] = input.nextInt();
			System.out.print("Enter your expenditure name : ");
			money1.name[i] = input.next();
			}		
	}
	
	void view(int c, int d) {
		System.out.print("What do you want to view?");
		String v = input.next();
		if(v.equals("income")) {
			for(int i = 0 ; i < c ; i++) {
			System.out.print(money.name[i] + " : " + money.money[i] + " "); 
			}
			System.out.println();
		}
		else if(v.equals("expend")) {
			for(int i = 0 ; i < d ; i++) {
				System.out.print(money1.name[i] + " : " + money1.money[i] + " "); 
			}
			System.out.println();
		}
		else if(v.equals("all")) {
			for(int i = 0 ; i < c ; i++) {
				System.out.print(money.name[i] + " : " + money.money[i] + " "); 
			}
			System.out.println();
			for(int i = 0 ; i < d ; i++) {
				System.out.print(money1.name[i] + " : " + money1.money[i] + " "); 
			}
			System.out.println();
		}
	}
		
	void Exit() {
		System.out.println("Exit program");
	}
}
