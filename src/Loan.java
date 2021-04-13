
public class Loan extends Money {
	public int interest;	
	public Loan(int money, String name, int interest) {
		this.money = money;
		this.name = name;
		this.interest = interest;
	}
}
