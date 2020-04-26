package com.capg.pbms.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.pbms.transaction.dao.ITransactionDao;
import com.capg.pbms.transaction.model.AccountManagement;
import com.capg.pbms.transaction.model.Transaction;

    @Service
	public class TransactionServiceImpl implements ITransactionService{
		@Autowired
		ITransactionDao dao;
		@Override
		public AccountManagement addAccount(AccountManagement bean) {
			return dao.addAccount(bean);
		}

		@Override
		public AccountManagement getBalance(String accountId) {
			return dao.getBalance( accountId);
		}

		@Override
		public AccountManagement deposit(String accountId, double amount) {
			
			return dao.deposit(accountId, amount);
		}

		@Override
		public AccountManagement withdraw(String accountId, double amount) {
			return dao.withdraw(accountId, amount);
		}

		@Override
		public List<Transaction> printTransactions(String accountId) {
			return dao.printTransactions(accountId);
		}
		public List<AccountManagement> getAll() {
			// TODO Auto-generated method stub
			return dao.getAll();
		}

		
}
