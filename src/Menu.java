import java.util.Scanner;

public class Menu {
	
	static int[] income(int a, int b) {
		Scanner input = new Scanner(System.in);
		int[] income = new int[b];
		while(a < b){				
			System.out.print("Enter your income : ");
			income[a] = input.nextInt();
			a = a + 1;
			
		}
		return income;
	}
	
	static int[] expend(int a, int b) {
		Scanner input = new Scanner(System.in);
		int[] expend = new int[b];
		while(a < b){
			System.out.print("Enter your expenditure : ");
			expend[a] = input.nextInt();
			a = a + 1;			
		}
		return expend;
	}
	
	static void view(int[] a, int[] b, int c, int d) {
		Scanner input = new Scanner(System.in);
		System.out.print("What do you want to view?");
		String v = input.next();
		if(v.equals("income")) {
			for(int i = 0 ; i < c ; i++) {
			System.out.print("Your income " + (i+1) + " : " + a[i] + " "); 
			}
			System.out.println();
		}
		else if(v.equals("expend")) {
			for(int i = 0 ; i < d ; i++) {
				System.out.print("Your expenditure " + (i+1) + " : " + b[i] + " "); 
			}
			System.out.println();
		}
		else if(v.equals("all")) {
			for(int i = 0 ; i < c ; i++) {
				System.out.print("Your income " + (i+1) + " : " + a[i] + " "); 
			}
			System.out.println();
			for(int i = 0 ; i < d ; i++) {
				System.out.print("Your expenditure " + (i+1) + " : " + b[i] + " "); 
			}
			System.out.println();
		}
	}
	
	static int[] edit(int[] a, int b) {
		Scanner input = new Scanner(System.in);
		for(int i = 0 ; i < b ; i++) {
			System.out.println(a[i]); 
		}
		System.out.println("Which number do you want to edit?");
		int ans = input.nextInt();
		System.out.print("Enter your value : ");
		a[(ans-1)] = input.nextInt();
		return a;
	}
	
	static void Exit() {
		System.out.println("Exit program");
	}
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = 0;
		System.out.println("Enter how many save your income? ");
		int savein = input.nextInt();
		System.out.println("Enter how many save your expenditure? ");
		int saveex = input.nextInt();
		int[] inc = new int[savein];
		int[] exp = new int[saveex];
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
				inc = income(in,savein);
				in = savein;
				continue;					
			case 2:
				if(saveex == ex) {
					System.out.println("You saved all expenditure");
					continue;
				}
				exp = expend(ex,saveex);
				ex = saveex;
				continue;
			case 3:
				System.out.println("Which one do you want to edit income or expenditure?");
				String ans = input.next();
				if(ans.equals("income")) {
					edit(inc,in);
				}
				else if(ans.equals("expenditure")) {
					edit(exp,ex);
				}
				continue;
			case 4:
				view(inc, exp, savein, saveex);
				continue;
			case 5:
				Exit();
				break;
			}
		}
	}

}
