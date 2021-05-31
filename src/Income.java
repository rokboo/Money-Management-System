
public class Income extends Money{
	public Income(int money, String name) {
		this.setMoney(money);
		this.setName(name);
		setStr("수입 " + this.getName() + " : " + this.getMoney());
	}
	
	public void Print() {
		System.out.println(getStr());
	}
	
	public int calinterest() {
		return 0;
	}
}
