package sprint1.pbms.service;

public interface TransactionService {
	public boolean creditUsingSlip(String userName,String accountNumber,int balance);
	public boolean debitUsingSlip(String userName,String accountNumber,int balance);
	public double getBalanceByID(String accountNumber);
		  
		 public boolean addAmount(String accountNumber,int amount) ;
		 public boolean deductAmount(String accountNumber,int amount) ;
		 	//public void addSomeAccountDetails();

}
