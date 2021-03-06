class PaymentGateway
{ 
	//method to transfer the given amount from the src to target account.
	public static boolean transfer(SavingsAccount sender, SavingsAccount reciever, double amount) 
	{
		//If the sender account balance = the given amount then the amount is
		//transferred from the sender to the reciever account and true is returned
		//otherwise false is returned.
		boolean transfer;
		
		if(sender.getBalance() == amount)
		{
			sender.withdraw(amount);
			reciever.deposit(amount);
			transfer = true;
		}
		else 
			transfer = false;
			
		return transfer;
	}
}