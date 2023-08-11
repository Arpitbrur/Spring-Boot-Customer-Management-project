package com.jsp.SpringBootCustomerManagementprojectwithexception.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.SpringBootCustomerManagementprojectwithexception.dto.Customer;
import com.jsp.SpringBootCustomerManagementprojectwithexception.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;
	
	// insert customer---------------------------------------------------------------------
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
		
	//getCustomerById-----------------------------------------------------------------------
	public Customer getCustomerById(int customerId) {
		Optional<Customer> optional = customerRepository.findById(customerId);
			
		if(optional.isPresent()) {
			Customer customer = optional.get();
			return customer;
		}else {
			return null;
		}
	}
		
	// delete customer-----------------------------------------------------------------------
	public Customer deleteCustomer(Customer customer,int customerId) {
		Optional<Customer> optional = customerRepository.findById(customerId);
			
		if(optional.isPresent()) {
			customerRepository.delete(optional.get());
			return customer;
		}else {
			return null;
		}
	}
		
	// update customer-----------------------------------------------------------------------
	public Customer updateCustomer(Customer customer, int customerId) {
		Optional<Customer> optional = customerRepository.findById(customerId);
			
		Customer customer2 = optional.get();
		if((customer.getFirst_name()!= null)&&(customer.getLast_name()!=null)&&(customer.getAddress()!=null)
				&&(customer.getCity()!=null)&& (customer.getEmail()!=null)&&(customer.getState()!=null)&&
				(customer.getStreet()!=null)&&(customer.getPhone()!=0)) {
			customer2.setFirst_name(customer.getFirst_name());
			customer2.setLast_name(customer.getLast_name());
			customer2.setAddress(customer.getAddress());
			customer2.setCity(customer.getCity());
			customer2.setEmail(customer.getEmail());
			customer2.setStreet(customer.getStreet());
			customer2.setState(customer.getState());
			customer2.setPhone(customer.getPhone());
				
			customerRepository.save(customer2);
				
			return customer;
		}else {
			return null;
		}
	}
		
	// display customer-------------------------------------------------------------------------------
	public List<Customer> displayCustomer(){
		return customerRepository.findAll();
	}


}
