package com.imcs.rest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imcs.rest.model.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Long> {

	Customer findCustomerById(Long id);
}
