package com.comulynx.wallet.rest.api.repository;

import com.comulynx.wallet.rest.api.model.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Optional<List<Transaction>> findTransactionsByCustomerId(String customerId);

	Optional<List<Transaction>> findTransactionsByTransactionId(String transactionId);

	Optional<List<Transaction>> findTransactionsByCustomerIdOrTransactionId(String transactionId, String customerId);

	// TODO : Change below Query to return the last 5 transactions
	// TODO : Change below Query to use Named Parameters instead of indexed
	// parameters
	// TODO : Change below function to return Optional<List<Transaction>>
	@Query("SELECT t FROM Transaction t WHERE t.customerId =?1 AND  t.accountNo =?2")
	List<Transaction> getMiniStatementUsingCustomerIdAndAccountNo(String customer_id, String account_no);

	@Query("SELECT t FROM Transaction t WHERE t.customerId =?1 ORDER BY t.id DESC")
	Optional<List<Transaction>> findLast100TransactionsByCustomerId(String customerId, Pageable pageable);

}
