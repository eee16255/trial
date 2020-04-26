package sprint1.pbms.ui;

import java.util.Scanner;

import exception.AccountException;
import exception.AmountLessException;
import sprint1.pbms.dao.TransactionDao;
import sprint1.pbms.dao.TransactionDaoImpl;
import sprint1.pbms.service.TransactionService;
import sprint1.pbms.service.TransactionServiceImpl;
 
import sprint1.pbms.model.TransactionUsingSlip;

public class TransactionUI {
	static TransactionDao transactionDao=new TransactionDaoImpl();
	  static TransactionUsingSlip c=new TransactionUsingSlip();
	static TransactionService transactionService=new TransactionServiceImpl();
	static Scanner in=new Scanner(System.in);
	public static void main(String[]args) {
		try {
		for(;;) {
			int choice;
			System.out.println("Please Enter your choice");
			System.out.println("1.credit using slip");
			System.out.println("2.debit using slip");
			System.out.println("3.Exit");
			choice=in.nextInt();
			
			String f=String.valueOf(choice);
			if(!f.matches("[1-3]{1}"))  {
				throw new Exception("Invalid choice");
			}
			
			switch(choice) {
			case 1:
				try {
				creditUsingSlipInfo();}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:try {
				debitUsingSlipInfo();}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:System.out.println("Exit");
					System.exit(0);
					break;
			 default:
				System.out.println("Invalid Choice ");
				break;
			}
		}
		}
		 catch(Exception e) {
			 System.out.println("Invalid Choice Please Enter from the choice given above");
			 in.next();
			 main(args);
		 }
	}
	private static void creditUsingSlipInfo() throws AccountException, AmountLessException {
		System.out.println("Enter user name");
		String userName=in.next()+in.nextLine();
		System.out.println("enter account number");
		String accountNumber=in.next();
		 boolean isValidAccountNumber=((TransactionServiceImpl) transactionService).isValidAccountNumber( accountNumber);
		 if(isValidAccountNumber==false) {
			 throw new AccountException("Please enter valid input details");
		 }
		System.out.println("enter amount to be credited");
		int amount=in.nextInt();
		 //boolean isValidAccountNumber=((TransactionServiceImpl) transactionService).isValidAccountNumber( accountNumber);
		 boolean isValidAmount=((TransactionServiceImpl) transactionService).isValidAmount( amount);
		 if((isValidAccountNumber==true) && (isValidAmount==true)){
		 
		if(transactionDao.creditUsingSlip( userName, accountNumber,amount)) {
			System.out.println("amount deposited successfully");
		}
		else{
			 
			throw new AmountLessException("please enter the amount in the valid range");
	 }
	 }
	
//	 else{
//		  
//			throw new AccountException("Please enter valid input details");
//	 }
	}
	
	private static void debitUsingSlipInfo() throws AmountLessException, AccountException {
		System.out.println("Enter user name");
		String userName=in.next()+in.nextLine();
		System.out.println("enter account number");
		String accountNumber=in.next();
		boolean isValidAccountNumber=((TransactionServiceImpl)  transactionService).isValidAccountNumber(accountNumber);
		if(isValidAccountNumber==false) {
			 throw new AccountException("Please enter valid input details");
		 }
		System.out.println("enter amount to be  debited");
		int amount=in.nextInt();
		//boolean isValidAccountNumber=((TransactionServiceImpl)  transactionService).isValidAccountNumber(accountNumber);
		 
		boolean isValidAmount=((TransactionServiceImpl)  transactionService).isValidAmount( amount);
		 if((isValidAccountNumber==true) && (isValidAmount==true)){
		 
		 
		if(transactionDao.debitUsingSlip( userName, accountNumber,amount)) {
			System.out.println("amount withdrawn successfully");
		
	}
		
		else{
			
			throw new AmountLessException("Insufficient balance");
		} 
	  
	}
//	  else{
//		  
//			throw new AccountException("Please enter valid input details");
//	 }
	 	
	
	}
}

