package com.jsp.SpringBootCustomerManagementprojectwithexception.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.SpringBootCustomerManagementprojectwithexception.dto.Customer;
import com.jsp.SpringBootCustomerManagementprojectwithexception.dto.ResponseStructure;
import com.jsp.SpringBootCustomerManagementprojectwithexception.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// insert customer--------------------------------------------------------------------
	@PostMapping("createCustomer")
	public ResponseStructure<Customer> insertCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}	
	
	//getCustomerById--------------------------------------------------------------------
	@GetMapping("/getCustomerById/{customerId}")
	public ResponseStructure<Customer> getCustomerById(@PathVariable int customerId) {
		return customerService.getCustomerById(customerId);
	}
		
	// delete customer-----------------------------------------------------------------------
	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseStructure<Customer> deleteCustomer(Customer customer,@PathVariable int customerId) {
		return customerService.deleteCustomer(customer, customerId);
	}
		
	// update customer-----------------------------------------------------------------------
	@PutMapping("/updateCustomer/{customerId}")
	public ResponseStructure<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable int customerId) {
		return customerService.updateCustomer(customer, customerId);
	}
		
	// display customer-------------------------------------------------------------------------------
	@GetMapping("/getAllCustomer")
	public List<Customer> displayCustomer(){
		return customerService.displayCustomer();
	}
}
