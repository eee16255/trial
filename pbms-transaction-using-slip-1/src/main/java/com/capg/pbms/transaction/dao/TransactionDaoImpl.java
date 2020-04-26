package com.capg.pbms.transaction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capg.pbms.transaction.model.AccountManagement;
import com.capg.pbms.transaction.model.Transaction;




	@Repository
	@Transactional
	public class TransactionDaoImpl implements ITransactionDao{
		@PersistenceContext
		EntityManager em;
		@Override
		public AccountManagement addAccount(AccountManagement bean) {
		 em.persist(bean);
			 
			 return bean;
		}

		@Override
		public AccountManagement getBalance(String accountId) {
			return em.find(AccountManagement.class, accountId);
		}

		@Override
		public AccountManagement deposit(String accountId, double amount) {
			amount=12000;
			AccountManagement bean = em.find(AccountManagement.class, accountId);
			try {
			bean.setAccountBalance(amount+bean.getAccountBalance());
			}
			catch(Exception e) {
				return null;
			}
			Transaction history = new Transaction("Deposited", accountId, amount);
			
			em.persist(history);
			
			return em.merge(bean);
		}

		@Override
		public AccountManagement withdraw(String accountId, double amount) {
			AccountManagement bean = em.find(AccountManagement.class, accountId);
			bean.setAccountBalance(bean.getAccountBalance()-amount);
			
		Transaction history = new Transaction("Withdrawn", accountId, amount);
			
			em.persist(history);
			
			return em.merge(bean);
			
			
		}
       @Override
		public List<Transaction> printTransactions(String accountId) {
			TypedQuery<Transaction> query = em.createQuery("select h from Transaction h where h.acc_id="+accountId, Transaction.class);
			return query.getResultList();
		}

		@Override
		public List<AccountManagement> getAll() {
			TypedQuery<AccountManagement> query = em.createQuery("from AccountManagement", AccountManagement.class);
			return query.getResultList();
		}

		
		
		 
}
