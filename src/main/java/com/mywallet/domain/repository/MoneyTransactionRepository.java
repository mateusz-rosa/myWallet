package com.mywallet.domain.repository;

import com.mywallet.domain.MoneyTransaction;
import org.springframework.data.repository.CrudRepository;

public interface MoneyTransactionRepository extends CrudRepository<MoneyTransaction, Long> {
}
