package com.example.blockcoin;

//James Sigler, Aaron Pingo
import java.util.ArrayList;
public class Account
{
	//Initializing variables
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	public Block ID;
	public ArrayList<Account> accList = new ArrayList<>();

	//Default constructor
	Account()
	{
		firstName = "";
		lastName = "";
		userName = "";
		password = "";
		ID = new Block(firstName, lastName, userName);
	}
	//Constructor with inputs
	Account(String f, String l, String u, String p)
	{
		if(verify(f, l, u, p))
		{
			firstName = f;
			lastName = l;
			userName = u;
			password = p;
		}
		else
		{
			firstName = "";
			lastName = "";
			userName = "";
			password = "";
			//Print an error message
		}
		ID = new Block(firstName, lastName, userName);
	}

	//gets
	String getFirstName()
	{
		return firstName;
	}
	String getLastName()
	{
		return lastName;
	}
	String getUserName()
	{
		return userName;
	}
	String getPassword()
	{
		return password;
	}
	
	//sets
	void setFirstName(String data)
	{
		firstName = data;
	}
	void setLastName(String data)
	{
		lastName = data;
	}
	void setUserName(String data)
	{
		userName = data;
	}
	void setPassword(String data)
	{
		password = data;
	}
	
	
	/*
	 * equals method
	 * will compare the hashes of the classes, will be used when pairing 
	 * the user will enter your info and it will generate a hash from that
	 * info and if they equal than the accounts will be allowed to pair
	 * 
	*/
	public boolean equals(Account a)
	{
		if(a.ID.toString().equals(ID.toString()))
		{
			return true;
		}
		return false;
	}
	
	//verify info
		/*
		 * firstName = 0-20 chars
		 * lastName = 0-20 chars
		 * userName = 6 - 12 chars
		 * password = 6 - 12 chars
		 * */
	private boolean verify(String fNam, String lNam, String uNam, String pWrd)
	{
		if(fNam.length() < 20)
		{
			if(lNam.length() < 20)
			{
				if(uNam.length() > 5 && uNam.length() < 21)
				{
					if(pWrd.length() > 5 && pWrd.length() < 21)
					{
						return true;
					}
					else
					{
						//PRINT AN ERROR MESSAGE ABOut Password Length
						return false;
					}
				}
				else
				{
					//PRINT AN ERROR MESSAGE About Username length
					return false;
				}
			}
			else
			{
				//PRINT AN ERROR MESSAGE About Last name length
				return false;
			}
		}
		else
		{
			//PRINT AN ERROR MESSAGE About first name length
			return false;
		}
	}
		
	//verify given an account object
	protected boolean verify(Account a)
	{
		return verify(a.getFirstName(), a.getLastName(), a.getUserName(), a.getPassword());
	}
		
		
	//ToString method, for displaying the account
	public String toString()
	{
		String out = "";
		out += "First Name :: " + firstName;
		out += "\nLast Name  ::" + lastName;
		out += "\nUserName   ::" + userName;
		return out;
	}

}
