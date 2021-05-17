
public class Income extends Money{
	public Income(int money, String name) {
		this.setMoney(money);
		this.setName(name);
	}
	public void Print() {
		System.out.print("수입 " + this.getName() + " : " + this.getMoney());
	}
	public int calinterest() {
		return 0;
	}
}
