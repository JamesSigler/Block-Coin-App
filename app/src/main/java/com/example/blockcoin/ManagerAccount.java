package com.example.blockcoin;

//James Sigler, Aaron Pingo
public class ManagerAccount extends Account
{
	//when attempting to pair with a manager, the user will enter 'MANAGER'
	//in the user name field and the first and last name will be left blank
	Block ID = new Block("", "", "Manager");
	ManagerAccount()
	{
	}
	public UserAccount changeBalance(UserAccount a, double newBalance)
	{
		if(newBalance < 0)
		{
			//print an error
			return a;
		}
		else
		{
			//changing the balance
			a.changeBalance(0-a.getBalance());
			a.changeBalance(newBalance);
			return a;
		}
	}
	
	
	
	
	
}
