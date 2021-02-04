package com.example.blockcoin;

//James Sigler, Aaron Pingo
public class Block
{
	//Hashing the ID to create a block
	String hash;
	Block(String fName, String lName, String userName)
	{
		hash = StringUtil.applySha256(fName+lName+userName);
	}
	public String toString()
	{
		return hash;
	}
}
