package com.capg.pbms.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pbms.transaction.model.AccountManagement;
import com.capg.pbms.transaction.model.Transaction;
import com.capg.pbms.transaction.service.TransactionServiceImpl;

    @RestController
	public class TransactionController {
		@Autowired
		TransactionServiceImpl service;
		@PostMapping("/bank/create")    
		public String createAccount(@RequestBody AccountManagement bean) {
			AccountManagement b = service.addAccount(bean);
			
			return  "Hello xyz"+"\n Your Registration is Successfull\n" + "Your Account Id is "
					+ b.getAccountId();
		}
		@GetMapping("/bank/showBalance/{id}")
		public String showBalance(@PathVariable String accountId) throws Exception {

			AccountManagement b = service.getBalance(accountId);

			if (b == null) {
				throw new Exception("Invalid id");
			}
			return "Your Account Balance is " + b.getAccountBalance();
	}
		@GetMapping("/bank/transactions/{id}")  
		public List<Transaction> transactions(@PathVariable String accountId) throws Exception {

			if (service.printTransactions(accountId) == null) {
				throw new Exception("Invalid id");
			}

			return service.printTransactions(accountId);
		}
		@GetMapping("/bank/deposit/{id}/{amount}")  
		public String deposit(@PathVariable String accountId, @PathVariable double amount) throws Exception {
			AccountManagement b =service.deposit(accountId, amount);

			if (b == null) {
				throw new Exception("Invalid id");
			}
			return "Hello " + "xyz" + "\n Your Amount is Deposited Succesfully\n"
					+ "Your Current Account Balance is " + b.getAccountBalance();
		}
		@GetMapping("/bank/withdraw/{id}/{amount}") 
		public String withdraw(@PathVariable String accountId, @PathVariable double amount) throws Exception {
			AccountManagement b = service.withdraw(accountId, amount);

			if (b == null) {
				throw new Exception("Invalid id");
			}
			return "Hello " + "xyz" + "\n Your Amount is Withdrawn Succesfully\n"
			+ "Your Current Account Balance is " + b.getAccountBalance();
			}
		@GetMapping("/bank/findall")  
		public List<AccountManagement> getall() {

			List<AccountManagement> bean = service.getAll();
			return bean;
		}
		@ExceptionHandler(Exception.class)
		public String inValid(Exception e) {
			return e.getMessage();
		}
}
