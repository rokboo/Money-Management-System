package Menu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Money.Expend;
import Money.Income;
import Money.Loan;
import Money.Saving;

public class MoneyManage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5644945054463684063L;
	ArrayList<Income> income = new ArrayList<Income>();
	ArrayList<Loan> Loan = new ArrayList<Loan>();
	ArrayList<Expend> expend = new ArrayList<Expend>();
	ArrayList<Saving> Saving = new ArrayList<Saving>();
	transient Scanner input = new Scanner(System.in);
	
	MoneyManage(Scanner input) {
		this.input = input;			
	}
	
	public int InSize() {
		return income.size();
	}
	
	public int ExSize() {
		return expend.size();
	}
	
	public int SaSize() {
		return Saving.size();
	}
	
	public int LoSize() {
		return Loan.size();
	}
	
	public Income getIn(int index) {
		return income.get(index);
	}
	
	public Expend getEx(int index) {
		return expend.get(index);
	}
	
	public Saving getSa(int index) {
		return Saving.get(index);
	}
	
	public Loan getLo(int index) {
		return Loan.get(index);
	}
	
	public void add(){
		input = new Scanner(System.in);
		System.out.println("추가하고 싶은 항목을 입력하십시오(수입,대출,지출,적금 중 하나를 입력)");
		String ans = input.next();
		try {
			if(ans.equals("수입")) {
				System.out.print("수입금액을 입력하십시오 : ");
				int m = input.nextInt();
				System.out.print("수입내용을 입력하십시오 : ");
				String n = input.next();
				Income money = new Income(m,n);
				income.add(money);	
			}
			
			else if(ans.equals("지출")) {
				System.out.print("지출금액을 입력하십시오 : ");
				int m = input.nextInt();
				System.out.print("지출내용을 입력하십시오 : ");
				String n = input.next();
				Expend money = new Expend(m,n);
				expend.add(money);	
			}
			
			else if(ans.equals("대출")) {
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
			}
			
			else if(ans.equals("적금")) {
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
			}
			else System.out.println("잘못된 항목을 입력하셨습니다.");
			
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
		for(int i = 0 ; i < Loan.size() ; i++) {
			Loan.get(i).Print();
		}
		System.out.println();
		for(int i = 0 ; i < expend.size() ; i++) {
			expend.get(i).Print();
		}
		System.out.println();
		for(int i = 0 ; i < Saving.size() ; i++) {
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
					System.out.print("수정할 수입내용을 입력하십시오 : ");
					String name = input.next();
					Income in = new Income(money,name);
					income.set(i,in);
				}
			}
			else if(ans.equals("대출")) {
				int k = -1;
				System.out.print("수정할 대출금액을 입력하십시오 : ");
				int money = input.nextInt();
				System.out.print("수정할 대출이자율을 입력하십시오 : ");
				double interest = input.nextDouble();
				System.out.println("수정할 대출기간을 입력하십시오");
				int month = input.nextInt();
				Loan loan = new Loan(money,"대출",interest,month);
				Expend debt = new Expend(loan.calinterest(),"대출이자");
				Loan.set(i, loan);
				for(int j = 0 ; j < expend.size() ; j++) {
					if(expend.get(j).getName().equals("대출이자")) k++;
					if(k==i) {
						expend.set(j,debt);
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
					System.out.print("수정할 지출내용을 입력하십시오 : ");
					String name = input.next();
					Expend ex = new Expend(money,name);
					expend.set(i, ex);
					
				}
			}	
			else if(ans.equals("적금")) {
				int k = -1;
				System.out.print("수정할 매월 적금금액을 입력하십시오 : ");
				int money = input.nextInt();
				System.out.print("수정할 적금이자율을 입력하십시오 : ");
				double interest = input.nextDouble();
				System.out.println("수정할 적금기간을 입력하십시오");
				int month = input.nextInt();
				Saving saving = new Saving(money*month,"적금",interest,month);
				Income in =new Income(saving.calinterest(),"적금이자");
				Saving.set(i, saving);
				for(int j = 0 ; j < income.size() ; j++) {
					if(income.get(j).getName().equals("적금이자")) k++;
					if(k==i) {
						income.set(j,in);
						break;
					}
				}
			}
			else System.out.println("잘못된 항목을 입력하셨습니다.");
			
		}catch(IndexOutOfBoundsException e) {
			System.out.println("수정할 내용이 존재하지 않습니다.");
		}catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
			input = new Scanner(System.in);
		}
	}
	
	public void delete() {
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
		System.out.println("삭제하고 싶은 목록을 입력하십시오(수입,대출,지출,적금 중 하나를 입력)");
		String ans = input.next();
		System.out.println("몇번째 항목을 삭제할지 입력하십시오");
		int i = input.nextInt() - 1;
		try {
			if(ans.equals("수입")) {
				if((income.get(i).getName().equals("적금이자"))){
					System.out.println("적금이자를 삭제하려면 적금을 삭제하십시오");
				}
				else {
					income.remove(i);
				}
			}
			else if(ans.equals("대출")) {
				int k = 0;
				Loan.remove(i);
				for(int j = 0 ; j < expend.size() ; j++) {
					if(expend.get(j).getName().equals("대출이자")) k++;
					if(k==i) {
						expend.remove(j);
						break;
					}
				}			
			}
			else if(ans.equals("지출")) {
				if((expend.get(i).getName().equals("대출이자"))) {
					System.out.println("대출이자를 삭제하려면 대출을 삭제하십시오");
				}
				else{
					expend.remove(i);
				}
			}	
			else if(ans.equals("적금")) {
				int k = 0;
				Saving.remove(i);
				for(int j = 0 ; j < income.size() ; j++) {
					if(income.get(j).getName().equals("적금이자")) k++;
					if(k==i) {
						income.remove(j);
						break;
					}
				}
			}
			else System.out.println("잘못된 항목을 입력하셨습니다.");
			
		}catch(IndexOutOfBoundsException e) {
			System.out.println("삭제할 내용이 존재하지 않습니다.");
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
