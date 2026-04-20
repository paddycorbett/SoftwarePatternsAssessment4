package com.example.dit.resteasy;

public class Test {
	
	
	public Test() 
	{
		//TestUser();
		TestProduct();
	}
	
	
	public void TestUser() 
	{
		User user = new User("TestACcount", "password12345","Admin");
		ShopDAO shopdao = new ShopDAO();
		shopdao.persistSubscriber(user);	
	}
	public void TestProduct() 
	{
		Product product = new Product("Grey Hoodie", "Nike",39.99,"Tops","URL");
		ShopDAO shopdao = new ShopDAO();
		shopdao.persistSubscriber(product);	
		
	}
	
	public static void main(String[] args) {
		new Test();
	}

}
