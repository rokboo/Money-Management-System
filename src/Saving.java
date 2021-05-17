public class Saving extends Money{
	public Saving(int money, String name, double interest, int month) {
		this.setMoney(money);
		this.setName(name);
		this.setInterest(interest);
		this.setMonth(month);
	}
	public void Print() {
		System.out.print(this.getName() + " : " + this.getMoney());
		System.out.print("적금이자율 : " + this.getInterest() + " 적금기간 : " + this.getMonth());;
		}
	public int calinterest() {
		int income = 0;
		income = (int)(getMoney()*getMonth()/12*getInterest()/100);
		return income;
	}
}
