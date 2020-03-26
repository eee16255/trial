package sprint1.pbms.dao;

//import java.util.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


 
import sprint1.pbms.model.TransactionUsingSlip;

public class TransactionDaoImpl implements TransactionDao{
	Map<String,TransactionUsingSlip> transaction=new HashMap<String,TransactionUsingSlip>();
	public TransactionDaoImpl() {
		addSomeAccountDetails();
	}
	public void addSomeAccountDetails() {
		TransactionUsingSlip ta1=new TransactionUsingSlip( "123456789012","Rebeca",3000);
		TransactionUsingSlip ta2=new TransactionUsingSlip("123456789013","Prameela",4000);
		transaction.put(ta1.getAccountNumber(),ta1);
		transaction.put(ta2.getAccountNumber(),ta2);
		
		 
		
	}

	public boolean addAcountDetails(TransactionUsingSlip accountDetails) {
		if(transaction.containsKey(accountDetails)) {
			return false;
		}
		transaction.put(accountDetails.getAccountNumber(), accountDetails);
		return true;
		
	}
    
	public boolean creditUsingSlip(String userName, String accountNumber,int amount) {
		 if(amount<100||amount>100000) {
			 return false;
		 }
	
			addAmount( accountNumber, amount) ;
	System.out.println("Deposited "+amount+".rs Successfully "+"\n"+"Total amount "+getBalanceById( accountNumber)+".Rs");
	 
	return true;
	}

	public boolean debitUsingSlip(String userName, String accountNumber,int amount) {
		 if(getBalanceById(accountNumber)<amount) {
			 return false;
		 }
	
			deductAmount(accountNumber, amount);
	System.out.println("withdrawn "+amount+".rs Successfully "+"\n"+"Total amount "+  getBalanceById( accountNumber)+".Rs");
	
	 return true;
		
	}

	public int getBalanceById(String accountNumber) {
		if(!transaction.containsKey(accountNumber)) {
			System.out.println("No Account Found");
			return 0;
		}
		TransactionUsingSlip b=transaction.get(accountNumber);
		return  (int) b.getBalance();
	}

	public boolean updateAccountBalance(TransactionUsingSlip accountDetails, int amount) {
		if(!transaction.containsKey(accountDetails.getAccountNumber())) {
		return false;
	}
			
		return true;
	}
	
	public boolean deductAmount(String accountNumber,int amount) {
		if(!transaction.containsKey(accountNumber)) {
			return false;
		}
		TransactionUsingSlip acc=transaction.get(accountNumber);
		acc.setBalance(acc.getBalance()-amount);
		return true;
	}

public boolean addAmount(String accountNumber,int amount) {
	if(!transaction.containsKey(accountNumber)) {
		return false;
	}
	TransactionUsingSlip acc=transaction.get(accountNumber);
	acc.setBalance(acc.getBalance()+amount);
	return true;
}
}
 