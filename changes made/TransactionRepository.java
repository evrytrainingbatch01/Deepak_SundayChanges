package com.evry.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evry.bank.model.Account;

public interface TransactionRepository extends JpaRepository<Account, Integer> {

	
//	@Query("select t.id,a.id,a.accountBalance from Customer c inner join c.account a on c.id = a.id inner join a.transactions t on a.id = t.id where c.id = ?1")
//	public List<Transaction> findAllTransactionByCustomerId(int id);
	
//	@Query("select t.id,a.id,a.accountBalance from Customer c inner join c.account a on c.id = a.id inner join a.transactions t on a.id = t.id where c.id = :id")
//	public List<Transaction> findAllTransactionByCustomerId(@Param("id") int id);
	
	
	
	
	
}
