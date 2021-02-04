package com.example.blockcoin;

//James Sigler, Aaron Pingo
import java.util.ArrayList;
public class UserAccount extends Account
{
	private double balance;
	private ArrayList<Account> accList;
	private ArrayList<PaymentMethod> wallet;
	private ArrayList<Double> history;
	private ArrayList<UserAccount> friendList;
	
	//bare constructor 
	public UserAccount()
	{
		super();

		balance = 0;
		wallet = new ArrayList<PaymentMethod>();
		history = new ArrayList<Double>();
		friendList = new ArrayList<UserAccount>();
	}
	//parm constructor
	public UserAccount(String fNam, String lNam, String uNam, String pWrd)
	{
		
		super(fNam, lNam, uNam, pWrd);
		balance = 0;
		wallet = new ArrayList<PaymentMethod>();
		history = new ArrayList<Double>();
		friendList = new ArrayList<UserAccount>();
	}
	//adds a payment method given a payment method 
	public void addPaymentMethod(PaymentMethod p)
	{
		//loops thru wallet to make sure name of payment method isnt taken
		for(int i = 0; i < wallet.size(); i++)
		{
			if (wallet.get(i).getName().equals(p.getName()))
			{
				//Display an error message that this name is already taken
				//will return so that 
				return;
			}
		}
		
		//if the loop finishes then the name is not taken then the payment method is added
		wallet.add(p);
	}
	//removes a payment method given its name
	public void removePaymentMethod(String nam)
	{
		for(int i = 0; i < wallet.size(); i++)
		{
			if (wallet.get(i).getName().equals(nam))
			{
				wallet.remove(i);
				return;
			}
		}
		//if the name is not found than nothing is removed
	}
	//returns a payment method given its name
	public PaymentMethod getPaymentMethod(String name)
	{
		for(int i = 0; i < wallet.size(); i++)
		{
			if (wallet.get(i).getName().equals(name))
			{
				return wallet.get(i);
			}
		}
		return null;
	}
	//changing balance, has to be private for security shit
	public void changeBalance(double balChange)
	{
		//different protocall if the balance is zero
		if(balance == 0.0 && balChange > 0)
		{
			balance = balChange;
			history.add(0.0);
			return;
		}
		if (balance + balChange < 0)
		{
			//print an error message because users cannot have a negative balance
			return;
		}
		// adding the previous balance to the history
		history.add(balance);
		balance += balChange;
	}
	//returns balance
	public double getBalance()
	{
		return balance;
	}
	//if a is a valid UserAccount it adds it to friendList
	public void addFreind(UserAccount a)
	{
		if (verify(a))
		{
			friendList.add(a);
		}
		else
		{
			//return an error message because the given account is not a valid account 
		}
	}
	//removes friend given a friend
	public void removeFriend(UserAccount a)
	{
		for(int i = 0; i < friendList.size(); i++)
		{
			if (friendList.get(i).equals(a))
			{
				friendList.remove(i);
				return;
			}
		}
		//if nothing is found then nothing is found 
	}
	//transfer protocalls 
	public void transfer()
	{
		/*PART 1
		//Find the other User
		 * 2 options
		 * 1) pick a user from friends list
		 * 
		 * 2) enter info manually*/
		
		/*
		 * Part 2
		 * initialize the pair
		 * send the hashes to each other and then verify
		 * */
		
		
		/*
		 * Part 3
		 * Once pair is connected 
		 * the users can send money to each other 
		 * I did the verification of the number in the
		 * setBalance method, but you could move it if you wanted to*/
	}
	//returns history as arraylist
	public ArrayList<Double> getHistory()
	{
		return history;
	}
	//returns friendlist as an arraylist
	public ArrayList<UserAccount> getFriendList()
	{
		return friendList;
	}
}
