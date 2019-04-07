package com.evry.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evry.bank.dao.TransactionDao;
import com.evry.bank.model.Transaction;
import com.evry.bank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	public TransactionServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private TransactionDao transactionDao;


	@Override
	public List<Transaction> getAllTransactionDetailsById(int id) {
		return transactionDao.findAllTransactionByCustomerId(id);
	}
	
	
	
}
