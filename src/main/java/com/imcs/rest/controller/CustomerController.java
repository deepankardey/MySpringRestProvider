package com.imcs.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imcs.rest.model.Customer;
import com.imcs.rest.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value="/add",method = RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		System.out.println("add called");
		boolean flag = customerService.addCustomer(customer);
		if (flag)
			return new ResponseEntity(HttpStatus.CREATED);
		else
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, consumes = { "application/json" }, produces = {
			"application/json" })
	public Customer getCustomerById(@PathVariable("id") Long id) {
		return customerService.getCustomer(id);
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<?> getAllCustomer() {
		return new ResponseEntity(customerService.getAllCustomers(), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

}
