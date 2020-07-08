package com.comulynx.wallet.rest.api.repository;

import com.comulynx.wallet.rest.api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

	@Query("SELECT c FROM Customer c WHERE c.customerId =?1")
	Optional<Customer> findByCustomerId(String customerId);

	// TODO : Implement the query and function below to delete a customer using Customer Id
	// @Query("?")
	// int deleteCustomerByCustomerId(String customer_id);

	// TODO : Implement the query and function below to update customer firstName using Customer Id
	// @Query("?")
	// int updateCustomerByCustomerId(String firstName, String customer_id);
	
	// TODO : Implement the query and function below and to return all customers whose Email contains  'gmail'
	// @Query("?")
	//List<Customer> findAllCustomersWhoseEmailContainsGmail();
}
