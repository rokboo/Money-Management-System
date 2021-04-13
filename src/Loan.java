
public class Loan extends Money {
	static int interest;	
	public static int getInterest() {
		return interest;
	}
	public static void setInterest(int interest) {
		Loan.interest = interest;
	}
	public Loan(int money, String name, int interest) {
		this.money = money;
		this.name = name;
		this.setInterest(interest);
	}
}
