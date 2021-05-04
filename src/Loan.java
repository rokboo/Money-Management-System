public class Loan extends Money {
	private int interest;	
	private int Loan_month;
	public int getLoan_month() {
		return Loan_month;
	}
	public void setLoan_month(int Loan_month) {
		this.Loan_month=Loan_month;
	}
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
	public Loan(int money, String name, int interest, int Loan_month) {
		this.setMoney(money);
		this.setName(name);
		this.setInterest(interest);
		this.setLoan_month(Loan_month);
	}
	public int debt(int money, int interest, int Loan_month) {
		int debt = 0;
		debt = money*interest*Loan_month/100;
		return debt;
	}
	public void Print() {
		System.out.print(this.getName() + " : " + this.getMoney());
		System.out.println(" loan interest : " + this.getInterest() + " passed months : " + this.getLoan_month());
	}
}
