public class Loan extends Money {
	public Loan(int money, String name, double interest, int month) {
		this.setMoney(money);
		this.setName(name);
		this.setInterest(interest);
		this.setMonth(month);
		setStr(this.getName() + " : " + this.getMoney() + " 대출이자율 : " + this.getInterest() + " 대출기간 : " + this.getMonth());
	}
	
	public void Print() {
		System.out.println(getStr());
	}
	
	public int calinterest() {
		int debt = 0;
		debt = (int)(getMoney()*getMonth()/12*getInterest()/100);
		return debt;
	}
}
