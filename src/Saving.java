
public class Saving extends Money{
	private int saving_interest;
	private int saving_month;
	public int getSaving_interest() {
		return saving_interest;
	}
	public void setSaving_interest(int saving_interest) {
		this.saving_interest = saving_interest;
	}
	public int getSaving_month() {
		return saving_month;
	}
	public void setSaving_month(int saving_month) {
		this.saving_month = saving_month;
	}
	public Saving() {
		
	}
	public Saving(int money, String name, int saving_interest, int saving_month) {
		this.setMoney(money);
		this.setName(name);
		this.setSaving_interest(saving_interest);
		this.setSaving_month(saving_month);
	}
	public int saving_income(int money, int saving_interest, int saving_month) {
		int income = 0;
		income = money*saving_month*saving_interest/100;
		return income;
	}
	public void Print() {
		System.out.print(this.getName() + " : " + this.getMoney());
		System.out.println(" saving interest : " + this.getSaving_interest() + " passed months : " + this.getSaving_month());;
	
	}
}
