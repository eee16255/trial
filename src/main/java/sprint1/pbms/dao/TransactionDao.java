package sprint1.pbms.dao;

import sprint1.pbms.model.TransactionUsingSlip;

public interface TransactionDao {
	 
	public boolean addAcountDetails(TransactionUsingSlip accountDetails);
	public boolean creditUsingSlip(String userName,String accountNumber ,int amount);
	public boolean debitUsingSlip(String userName,String accountNumber ,int amount);
	public int getBalanceById(String accountNumber);
	public boolean updateAccountBalance(TransactionUsingSlip accountDetails,int amount);
	public boolean addAmount(String accountNumber,int amount);
	public boolean deductAmount(String accountNumber,int amount);
	public void addSomeAccountDetails();

}
