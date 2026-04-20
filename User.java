package com.example.dit.resteasy;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	private String accountType;
	
	public User()
	{
		
	}
	
	public User(String username,String password, String accountType)
	{
		
		this.username =username;
		this.password =password;
		this.accountType=accountType;
	}
	
}
