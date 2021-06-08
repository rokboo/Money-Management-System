package Money;
public class Expend extends Money {
	public Expend(int money, String name) {
		this.setMoney(money);
		this.setName(name);
		setStr("지출 " + this.getName() + " : " + this.getMoney());
	}
	
	public void Print() {		
		System.out.println(getStr());
	}
	
	public int calinterest() {
		return 0;
	}
}
