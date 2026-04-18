

public class Test {
	
	
	public Test() {
		User user = new User("TestACcount", "password12345","Admin");
		ShopDAO shopdao = new ShopDAO();
		shopdao.persistSubscriber(user);	
		shopdao.remove(user);

	}
	
	public static void main(String[] args) {
		new Test();
	}

}
