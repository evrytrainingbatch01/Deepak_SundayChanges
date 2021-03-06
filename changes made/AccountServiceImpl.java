package com.evry.bank.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evry.bank.dao.AccountDao;
import com.evry.bank.model.Account;
import com.evry.bank.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDao accountDao;

	@Override
	public boolean checkAccountDetails(int id) {
		return accountDao.checkAccountDetails(id);
	}

	@Override
	public BigDecimal checkBalance(int id) {
		return accountDao.checkBalance(id);
	}

	@Override
	public void transferMoney(int fromid, int toid, double amount) {
		accountDao.transferMoney(fromid, toid, amount);
	}
	
	@Override
	public Account getAccountDetailsById(int id) {
		return accountDao.getAccountDetailsById(id);
	}

}
