public class Loan extends Money {
	public Loan(int money, String name, double interest, int month) {
		this.setMoney(money);
		this.setName(name);
		this.setInterest(interest);
		this.setMonth(month);
	}
	public int calinterest() {
		int debt = 0;
		debt = (int)(getMoney()*getMonth()/12*getInterest()/100);
		return debt;
	}
	public void Print() {
		System.out.print(this.getName() + " : " + this.getMoney());
		System.out.println(" ���������� : " + this.getInterest() + " ����Ⱓ : " + this.getMonth());
	}
}
