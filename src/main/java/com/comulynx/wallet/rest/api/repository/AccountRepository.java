package com.comulynx.wallet.rest.api.repository;

import com.comulynx.wallet.rest.api.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("SELECT accountNo FROM Account WHERE customerId =?1")
	String findAccountNoByCustomerId(String customerId);

	@Query("SELECT a FROM Account a WHERE customerId = ?1")
	Optional<Account> findAccountByCustomerId(String customerId);

	Optional<Account> findAccountByAccountNo(String customerId);

	Optional<Account> findAccountByCustomerIdOrAccountNo(String customerId, String accountNo);
	
	Optional<Account> findAccountByCustomerIdAndAccountNo(String customerId, String accountNo);

}
