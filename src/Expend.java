
public class Expend extends Money {
	public Expend(int money, String name) {
		this.setMoney(money);
		this.setName(name);
	}
	public void Print() {
		System.out.print("지출 " + this.getName() + " : " + this.getMoney());
	}
	public int calinterest() {
		return 0;
	}
}
