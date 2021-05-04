public class Money {
		private int money;
		private String name;
		public int getMoney() {
			return money;
		}
		public void setMoney(int money) {
			this.money = money;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Money() {
			
		}
		public Money(int money, String name) {
			this.setMoney(money);
			this.setName(name);
		}
		public void Print() {
			System.out.print(this.getName() + " : " + this.getMoney());
		}
	}