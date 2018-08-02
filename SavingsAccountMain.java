/*Tests whether the given constraints of savings account are getting satisfied or not*/
class SavingsAccountMain
{
		public static void main(String args[])
		{
			SavingsAccount anna = new SavingsAccount("Anna", 2000);
			System.out.println(anna);
			
			int nextAcc = SavingsAccount.getNextAccountNumber();
			System.out.println("Next Account Number is "+nextAcc);
			
			SavingsAccount irene = new SavingsAccount("Irene");
			System.out.println(irene);
			
			nextAcc = SavingsAccount.getNextAccountNumber();
			System.out.println("Next Account Number is "+nextAcc);
			
			String msg = anna.transaction(irene , 500);
			System.out.println(msg);
			
			msg = anna.transaction(irene, anna.getBalance());
			System.out.println(msg);
		}
	
}