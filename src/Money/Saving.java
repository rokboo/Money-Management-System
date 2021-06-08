package Money;
public class Saving extends Money{
	public Saving(int money, String name, double interest, int month) {
		this.setMoney(money);
		this.setName(name);
		this.setInterest(interest);
		this.setMonth(month);
		setStr(this.getName() + " : " + this.getMoney() + " 적금이자율 : " + this.getInterest() + " 적금기간 : " + this.getMonth());
	}
	
	public void Print() {
		System.out.println(getStr());
	}
	
	public int calinterest() {
		int income = 0;
		income = (int)(getMoney()*getMonth()/12*getInterest()/100);
		return income;
	}
}
