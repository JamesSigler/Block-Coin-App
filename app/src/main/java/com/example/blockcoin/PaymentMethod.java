package com.example.blockcoin;

//James Sigler, Aaron Pingo
public class PaymentMethod
{
	private String name;
	PaymentMethod()
	{
		name = "";
	}
	PaymentMethod(String n)
	{
		name = n;
	}
	void setName(String n)
	{
		name = n;
	}
	String getName()
	{
		return name;
	}
	public boolean verify()
	{
		//will just return in the skeleton class but both
		//CreditCardPaymentMethod & BankAccountPaymentMethod
		//the verify method will verify w/ bank
		return true;
	}
}
