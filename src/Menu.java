import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MoneyManage manage = new MoneyManage(input);
		int num = 0;
		while(num != 5) {
			System.out.println("1. My Income");
			System.out.println("2. My Expenditure");
			System.out.println("3. Edit Income or Expenditure");
			System.out.println("4. View Property");
			System.out.println("5. Exit");
			num = input.nextInt();
			switch(num){
			case 1:
				manage.income();
				continue;					
			case 2:
				manage.expend();
				continue;
			case 3:
				manage.edit();			
				continue;
			case 4:
				manage.view();
				continue;
			case 5:
				manage.Exit();
				break;
			}
		}
	}

}
