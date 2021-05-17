import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MoneyManage manage = new MoneyManage(input);
		int num = 0;
		while(num != 7) {
			System.out.println("1.수입 추가");
			System.out.println("2.지출 추가");
			System.out.println("3.대출 추가");
			System.out.println("4.적금 추가");
			System.out.println("5.목록 수정");
			System.out.println("6.목록 확인");
			System.out.println("7.종료");
			try {
				num = input.nextInt();
				switch(num){
				case 1:
					manage.income();
					continue;					
				case 2:
					manage.expend();
					continue;
				case 3:
					manage.Loan();
					continue;					
				case 4:
					manage.Saving();
					continue;
				case 5:
					manage.edit();			
					continue;
				case 6:
					manage.view();
					continue;
				case 7:
					manage.Exit();
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				input = new Scanner(System.in);
				num = 0;
			}
			
		}
	}

}
