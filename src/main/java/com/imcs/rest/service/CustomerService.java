package com.imcs.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imcs.rest.dao.CustomerDao;
import com.imcs.rest.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public Customer getCustomer(Long id) {
		return customerDao.findCustomerById(id);
	}

	public boolean addCustomer(Customer customer) {
		return customerDao.save(customer) != null;
	}

	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerDao.findAll();
	}

	public void deleteCustomer(Long id) {
		customerDao.delete(id);
	}

}
