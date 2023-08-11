package com.jsp.SpringBootCustomerManagementprojectwithexception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.jsp.SpringBootCustomerManagementprojectwithexception.dto.Customer;

@Component
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
