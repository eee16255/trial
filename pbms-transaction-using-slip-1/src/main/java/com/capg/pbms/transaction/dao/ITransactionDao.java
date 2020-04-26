package com.capg.pbms.transaction.dao;

import java.util.List;

import com.capg.pbms.transaction.model.AccountManagement;
import com.capg.pbms.transaction.model.Transaction;



public interface ITransactionDao {
	 public AccountManagement addAccount(AccountManagement bean);
		
		public AccountManagement getBalance(String accountId);
		
		public AccountManagement deposit(String accountId, double amount);
		
		public AccountManagement withdraw(String accountId, double amount);
		
		public List<Transaction> printTransactions(String accountId);

		public List<AccountManagement> getAll();
}
