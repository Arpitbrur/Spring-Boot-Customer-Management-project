package com.jsp.SpringBootCustomerManagementprojectwithexception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.SpringBootCustomerManagementprojectwithexception.dao.CustomerDao;
import com.jsp.SpringBootCustomerManagementprojectwithexception.dto.Customer;
import com.jsp.SpringBootCustomerManagementprojectwithexception.dto.ResponseStructure;
import com.jsp.SpringBootCustomerManagementprojectwithexception.exception.IdNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ResponseStructure<Customer> responseStructure;
	
	// insert customer---------------------------------------------------------------------
	public ResponseStructure<Customer> saveCustomer(Customer customer) {
		Customer customer2 = customerDao.saveCustomer(customer);
		
		if(customer2 != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("data inserted successfully");
			responseStructure.setData(customer2);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("data not inserted" );
			responseStructure.setData(null);
			return responseStructure;
		}
	}
	
	//getCustomerById--------------------------------------------------------------------
	public ResponseStructure<Customer> getCustomerById(int customerId) {
		Customer customer = customerDao.getCustomerById(customerId);
		if(customer != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("data fetch successfully because data is available");
			responseStructure.setData(customer);
			return responseStructure;
		}else {
//			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
//			responseStructure.setMsg("data not fetch because data is not present in database");
//			responseStructure.setData(null);
//			return responseStructure;
				
			throw new IdNotFoundException("given id is not present in database please check your id ");
		}
	}
		
	// delete customer-----------------------------------------------------------------------
	public ResponseStructure<Customer> deleteCustomer(Customer customer,int customerId) {
		Customer customer2 = customerDao.deleteCustomer(customer, customerId);
			
		if(customer2 != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("data delete successfully");
			responseStructure.setData(customer2);
				
		}else {
//			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
//			responseStructure.setMsg("Given id is not present in database ");
//			responseStructure.setData(null);
//			return responseStructure;
				
			throw new IdNotFoundException("Given Id is not present in database");

		}
		return responseStructure;
	}
		
	// update customer-----------------------------------------------------------------------
	public ResponseStructure<Customer> updateCustomer(Customer customer, int customerId) {
		Customer customer2 = customerDao.updateCustomer(customer, customerId);
			
		if(customer2 != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("data is update successfully");
			responseStructure.setData(customer2);

		}else {
//			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
//			responseStructure.setMsg("data is not update ");
//			responseStructure.setData(null);
//			return responseStructure;
				
			throw new IdNotFoundException("Given Id is not present in database");

		}
		return responseStructure;
	}
		
	// display customer-------------------------------------------------------------------------------
	public List<Customer> displayCustomer(){
		return customerDao.displayCustomer();
	}
		
	
}
