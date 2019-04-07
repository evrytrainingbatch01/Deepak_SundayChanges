/**
 *
 @author sadiq.ahamad
 * @author renuka.prasada
 */
package com.evry.bank.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evry.bank.model.Account;
import com.evry.bank.model.Customer;
import com.evry.bank.model.Transaction;
import com.evry.bank.service.AccountService;
import com.evry.bank.service.TransactionService;
import com.evry.bank.service.impl.CustomerServiceImpl;

@RestController 
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;
	
	public CustomerController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		//this is adding customer method.here app is taking the object and passing it to service.
		customerService.addCustomer(customer);
		
		return customer;
	}
	
	@GetMapping("/getCustomer/{id}")
	public  Optional<Customer> getCustomerById(@PathVariable int id) {
		Optional<Customer> customer = customerService.getCusomterById(id);
		
		return customer;
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		List<Customer> allCustomersList = customerService.getAllCustomers();
		return  allCustomersList;
	}
	
	@PutMapping("/updateCustomer/{id}")
	public Customer updateCustomer(@RequestBody Customer customer,@PathVariable int id) {
		Customer updateCustomer = customerService.updateCustomer(id, customer);
		return updateCustomer;
		
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable int id) {
	 customerService.deleteCustomer(id);
		
	}

	
	@GetMapping("/getCustomerAccountDetailByCustomerId/{id}")
	public  Account getCustomerAccountDetailByCustomerId(@PathVariable int id) {
		//get the customer by his id first
		Optional<Customer> customer = customerService.getCusomterById(id);
		int idOfCustomer = customer.get().getId();
		//get his account 
		Account accountOfCustomer = accountService.getAccountDetailsById(idOfCustomer);
		return accountOfCustomer;
	}
	
	
	
	@GetMapping("/getCustomerTransactionDetailByCustomerId/{id}")
	public  List<Transaction> getCustomerTransactionDetailByCustomerId(@PathVariable int id) {
		//get the customer by his id first
		Optional<Customer> customer = customerService.getCusomterById(id);
		int idOfCustomer = customer.get().getId();
		//get his transactions 
		List<Transaction> transactions = transactionService.getAllTransactionDetailsById(idOfCustomer);
		
		return transactions;
	}
}
