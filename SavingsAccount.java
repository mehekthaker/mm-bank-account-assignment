/*MM bank deals with Savings Account, the expectation is, anyone can open savings account in MM bank by just giving their basic info like name, and initial balance. 
Every time the account object is created new account number is generated automatically and assigned to the accountNumber instance member, 
no two account object will have same account number.

customers can also open account without balance, which is a Zero balance account.

account has services like withdraw and deposit, anyone having an account object can use these services and on usage accordingly their accountBalance will change.

On printing the ref of an account through S.O.P it should display the account details on the console.

bank also provide a service, getNextAccountNumber() which is a kind of a public service that is open to all the people so, 
that even if a person does not have an account object he/she can still call this function to know what will be the next accountNumber, 
if he/she opens an account in MM bank. So, even if their is no account object created yet, we should be able to call getNextAccountNumber()*/

class SavingsAccount
{
	private double balance;
	private String name;
	private int accountNumber = 0;
	private static int lastAccountNumber = 0;
	
	public SavingsAccount(String name, double initialBalance)
	{
		this.name = name;
		this.balance = initialBalance;
		accountNumber = lastAccountNumber + 1;
		lastAccountNumber = accountNumber;
	}
	
	public SavingsAccount(String name)
	{
		this.name = name;
		accountNumber = lastAccountNumber + 1;
		lastAccountNumber = accountNumber;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void withdraw(double amount)
	{
		if(this.balance>amount && this.balance!=0)
			this.balance = this.balance - amount;
	}
	
	public void deposit(double amount)
	{
		if(this.balance>0)
			this.balance = this.balance + amount;
	}
	
	public static int getNextAccountNumber()
	{
		return lastAccountNumber + 1;
	}
	
	public String transaction(SavingsAccount receiver, double amount)
	{
		String msg = new String();
		if(PaymentGateway.transfer(this, receiver, amount))
		{
			msg = "Payment is Successful";
		}
		
		else
		{
			msg = "Payment is unsuccessful";
		}	
		return msg;
	}
	
	
	@Override
	public String toString()
	{
		return "Account [id = "+accountNumber+ " name=" + name + ", initialBalance= " + balance + "]";
	}
}