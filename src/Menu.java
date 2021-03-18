import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = 0;
		System.out.println("Enter how many save your income? ");
		int savein = input.nextInt();
		System.out.println("Enter how many save your expenditure? ");
		int saveex = input.nextInt();
		int[] income = new int[savein];
		int[] expend = new int[saveex];
		int in = 0;
		int ex = 0;
		String yes = "yes";
		String no = "no";
		
		while(num != 6) {
			System.out.println("1. My Income");
			System.out.println("2. My Expenditure");
			System.out.println("3. Edit Income or Expenditure");
			System.out.println("4. View Property");
			System.out.println("5. Show menu");
			System.out.println("6. Exit");
			num = input.nextInt();
			switch(num){
			case 1:
				while(in < savein){				
					System.out.print("Enter your income : ");
					income[in] = input.nextInt();
					in = in + 1;
					System.out.println("Continue? answer yes or no");
					String ansin = input.next();
					if(ansin.equals(no)) {
						break;
					}
					else if(ansin.equals(yes)) {
						continue;
					}
					
					else {
						System.out.println("You wrote wrong answer.");
						break;
					}
				}
				if(in == savein) {
					System.out.println("You saved all income");
					break;
				}
				continue;					
			case 2:
				while(ex < saveex){
					System.out.print("Enter your expenditure : ");
					expend[ex] = input.nextInt();
					ex = ex + 1;
					System.out.println("Continue? answer yes or no");
					String ansex = input.next();
					if(ansex.equals(no)) {
						break;
					}
					else if(ansex.equals(yes)) {
						continue;
					}
					else {
						System.out.println("You wrote wrong answer.");
						break;
					}					
				}
				if(ex == saveex) {
				System.out.println("You saved all expenditure");
				break;
				}
				continue;
			case 3:
				System.out.println("Which one do you want to edit income or expenditure?");
				
				continue;
			case 4:
				for(int i = 0 ; i < savein ; i++) {
					System.out.println("Your income " + (i+1) + " : " + income[i]);
				}
				for(int e = 0 ; e < saveex ; e++) {
					System.out.println("Your expenditure " + (e+1) + " : " + expend[e]);
				}				
				continue;
			case 5:
				continue;
			case 6:
				System.out.println("Exit program");
				break;
			}
		}
	}

}
