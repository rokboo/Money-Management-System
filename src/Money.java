abstract public class Money implements getinformation{
	private int money;
	private String name;
	private double interest;	
	private int month;
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money=money;		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month=month;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public Money() {}
		public abstract void Print();
		public abstract int calinterest();
}