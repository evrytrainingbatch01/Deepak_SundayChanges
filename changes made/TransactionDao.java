package com.evry.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evry.bank.model.Customer;
import com.evry.bank.model.Transaction;


@Repository
public class TransactionDao {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@PersistenceContext
	private EntityManager em;

	public List<Transaction> findAllTransactionByCustomerId(int id) {
//	    Query query = (Query) em.createQuery("select t from Customer c inner join Account a on c.id = a.id inner join a.transactions t on a.id = t.id where c.id = :id");
	    Query query = (Query) em.createNativeQuery("select t.EB_TRANSACTION_ID, a.EB_ACCOUNT_ID,a.EB_ACCOUNT_BALANCE from eb_customer c " + 
	    		"inner join eb_account a on c.eb_customer_id  = a.eb_acc_customer_id " + 
	    		"inner join eb_transaction t on a.eb_account_id= t.eb_trans_account_id " + 
	    		"where c.eb_customer_id = :id");
	    query.setParameter("id", id);
	    List<Transaction> list =  query.getResultList();
		return list;
		
	}
	
	
	
	
	
}
