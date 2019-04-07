package com.evry.bank.service;

import java.util.List;

import com.evry.bank.model.Transaction;

public interface TransactionService {
	
	public  List<Transaction> getAllTransactionDetailsById(int id);
}
