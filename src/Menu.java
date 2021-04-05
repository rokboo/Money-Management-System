import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MoneyManage manage = new MoneyManage(input);
		int num = 0;
		System.out.println("Enter how many save your income? ");
		int savein = input.nextInt();
		System.out.println("Enter how many save your expenditure? ");
		int saveex = input.nextInt();
		int in = 0;
		int ex = 0;	
		while(num != 5) {
			System.out.println("1. My Income");
			System.out.println("2. My Expenditure");
			System.out.println("3. Edit Income or Expenditure");
			System.out.println("4. View Property");
			System.out.println("5. Exit");
			num = input.nextInt();
			switch(num){
			case 1:
				if(savein == in) {
					System.out.println("You saved all income");
					continue;
				}
				manage.income(in,savein);
				in = savein;
				continue;					
			case 2:
				if(saveex == ex) {
					System.out.println("You saved all expenditure");
					continue;
				}
				manage.expend(ex,saveex);
				ex = saveex;
				continue;
			case 3:
				manage.edit(in, ex);			
				continue;
			case 4:
				manage.view(savein, saveex);
				continue;
			case 5:
				manage.Exit();
				break;
			}
		}
	}

}
