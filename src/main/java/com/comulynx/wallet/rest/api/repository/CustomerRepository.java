package com.comulynx.wallet.rest.api.repository;

import com.comulynx.wallet.rest.api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

	@Query("SELECT c FROM Customer c WHERE c.customerId =?1")
	Optional<Customer> findByCustomerId(String customerId);

	@Query("SELECT c FROM Customer c WHERE c.customerId =?1 OR c.email = ?2")
	Optional<Customer> findByCustomerIdOrEmail(String customerId, String email);

	@Query("DELETE from Customer c WHERE c.customerId =?1")
	int deleteCustomerByCustomerId(String customer_id);

	@Query("UPDATE Customer c SET c.firstName = ?1 WHERE c.customerId = ?2")
	int updateCustomerByCustomerId(String firstName, String customer_id);

	@Query("SELECT c FROM Customer c WHERE c.email LIKE '%gmail%'")
	List<Customer> findAllCustomersWhoseEmailContainsGmail();
}
