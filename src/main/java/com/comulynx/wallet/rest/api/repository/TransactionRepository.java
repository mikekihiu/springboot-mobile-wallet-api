package com.comulynx.wallet.rest.api.repository;

import com.comulynx.wallet.rest.api.model.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Optional<List<Transaction>> findTransactionsByCustomerId(String customerId);

	Optional<List<Transaction>> findTransactionsByTransactionId(String transactionId);

	Optional<List<Transaction>> findTransactionsByCustomerIdOrTransactionId(String transactionId, String customerId);

	@Query("SELECT t FROM Transaction t WHERE t.customerId = :customer_id AND  t.accountNo = :account_no")
	Optional<List<Transaction>> getMiniStatementUsingCustomerIdAndAccountNo(@Param("customer_id") String customer_id, @Param("account_no") String account_no, Pageable pageable);

	@Query("SELECT t FROM Transaction t WHERE t.customerId =?1 ORDER BY t.id DESC")
	Optional<List<Transaction>> findLast100TransactionsByCustomerId(String customerId, Pageable pageable);

}
