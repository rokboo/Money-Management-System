
public class Income extends Money{
	public Income(int money, String name) {
		this.setMoney(money);
		this.setName(name);
	}
	public void Print() {
		System.out.print("¼öÀÔ " + this.getName() + " : " + this.getMoney());
	}
	public int calinterest() {
		return 0;
	}

}
