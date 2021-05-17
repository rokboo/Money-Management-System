import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MoneyManage {
	ArrayList<Income> income = new ArrayList<Income>();
	ArrayList<Loan> Loan = new ArrayList<Loan>();
	ArrayList<Expend> expend = new ArrayList<Expend>();
	ArrayList<Saving> Saving = new ArrayList<Saving>();
	Scanner input = new Scanner(System.in);
	MoneyManage(Scanner input){
		this.input = input;
	}
	
	public void income(){
		input = new Scanner(System.in);
		try {
			System.out.print("수입금액을 입력하십시오 : ");
			int m = input.nextInt();
			System.out.print("수입내용을 입력하십시오 : ");
			String n = input.next();
			Income money = new Income(m,n);
			income.add(money);	
		}catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
			input = new Scanner(System.in);
		}
	}	
	
	public void expend(){	
		input = new Scanner(System.in);
		try {
			System.out.print("지출금액을 입력하십시오 : ");
			int m = input.nextInt();
			System.out.print("지출내용을 입력하십시오 : ");
			String n = input.next();
			Expend money = new Expend(m,n);
			expend.add(money);	
		}catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
			input = new Scanner(System.in);
		}
	}
	
	public void Loan(){
		input = new Scanner(System.in);
		try {
			System.out.print("대출금액을 입력하십시오 : ");
			int m = input.nextInt();
			String n = "대출";
			System.out.print("대출이자율을 입력하십시오 : ");
			double i = input.nextDouble();
			System.out.println("대출기간이 얼마입니까?");
			int month = input.nextInt();
			Loan loan = new Loan(m,n,i,month);
			Expend debt = new Expend(loan.calinterest(),"대출이자");
			Loan.add(loan);
			expend.add(debt);
		}catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
			input = new Scanner(System.in);
		}
	}
	
	public void Saving(){
		input = new Scanner(System.in);
		try {
			System.out.print("매월 적금금액을 입력하십시오 : ");
			int m = input.nextInt();
			String n = "적금";
			System.out.print("적금이자율을 입력하십시오 : ");
			double i = input.nextDouble();
			System.out.println("적금기간이 얼마입니까?");
			int month = input.nextInt();
			Saving saving = new Saving(m*month,n,i,month);
			Income interest =new Income(saving.calinterest(),"적금이자");
			Saving.add(saving);
			income.add(interest);
		}catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
			input = new Scanner(System.in);
		}
	}
	
	public void edit(){
		input = new Scanner(System.in);
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
		System.out.println("수정하고 싶은 목록을 입력하십시오(수입,대출,지출,적금 중 하나를 입력)");
		String ans = input.next();
		System.out.println("몇번째 항목을 수정할지 입력하십시오");
		int i = input.nextInt() - 1;
		try {
			if(ans.equals("수입")) {
				if((income.get(i).getName().equals("적금이자"))){
					System.out.println("적금이자를 수정하려면 적금을 수정하십시오");
				}
				else {
					System.out.print("수정할 수입금액을 입력하십시오 : ");
					int money = input.nextInt();
					income.get(i).setMoney(money);
					System.out.print("수정할 수입내용을 입력하십시오 : ");
					String name = input.next();
					income.get(i).setName(name);
				}
			}
			else if(ans.equals("대출")) {
				int k = 0;
				System.out.print("수정할 대출금액을 입력하십시오 : ");
				int money = input.nextInt();
				income.get(i).setMoney(money);
				System.out.print("수정할 대출이자율을 입력하십시오 : ");
				double interest = input.nextDouble();
				System.out.println("수정할 대출기간을 입력하십시오");
				int month = input.nextInt();
				Loan.get(i).setMoney(money);
				Loan.get(i).setInterest(interest);
				Loan.get(i).setMonth(month);
				for(int j = 0 ; j < expend.size() ; j++) {
					if(expend.get(j).getName().equals("대출이자")) k++;
					if(k==i) {
						expend.get(j).setMoney(Loan.get(i).calinterest());
						break;
					}
				}			
			}
			else if(ans.equals("지출")) {
				if((expend.get(i).getName().equals("대출이자"))) {
					System.out.println("대출이자를 수정하려면 대출을 수정하십시오");
				}
				else{
					System.out.print("수정할 지출금액을 입력하십시오 : ");
					int money = input.nextInt();
					expend.get(i).setMoney(money);
					System.out.print("수정할 지출내용을 입력하십시오 : ");
					String name = input.next();
					expend.get(i).setName(name);
				}
			}	
			else if(ans.equals("적금")) {
				int k = 0;
				System.out.print("수정할 매월 적금금액을 입력하십시오 : ");
				int money = input.nextInt();
				income.get(i).setMoney(money);
				System.out.print("수정할 적금이자율을 입력하십시오 : ");
				double interest = input.nextDouble();
				System.out.println("수정할 적금기간을 입력하십시오");
				int month = input.nextInt();
				Saving.get(i).setMoney(money*month);
				Saving.get(i).setInterest(interest);
				Saving.get(i).setMonth(month);
				for(int j = 0 ; j < income.size() ; j++) {
					if(income.get(j).getName().equals("적금이자")) k++;
					if(k==i) {
						income.get(j).setMoney(Saving.get(i).calinterest());	
						break;
					}
				}
			}
		}catch(IndexOutOfBoundsException e) {
			System.out.println("수정할 내용이 존재하지 않습니다.");
		}catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
			input = new Scanner(System.in);
		}
	}
	
	public void view() {
		int sum=0;
		for(int i = 0 ; i < income.size() ; i++) {
			income.get(i).Print();
			sum=sum+income.get(i).getMoney();
		}
		System.out.println();
		for(int i =0 ; i < Loan.size() ; i++) {
			Loan.get(i).Print();
			sum=sum+Loan.get(i).getMoney();
		}
		System.out.println();
		for(int i = 0 ; i < expend.size() ; i++) {
			expend.get(i).Print();
			sum=sum-expend.get(i).getMoney();
		}
		System.out.println();
		for(int i =0 ; i < Saving.size() ; i++) {
			Saving.get(i).Print();
			sum=sum+Saving.get(i).getMoney();
		}
		System.out.println();
		System.out.println("재산은 " + sum + "입니다.");
	}		
	public void Exit() {
		System.out.println("프로그램을 종료합니다.");
	}
}
