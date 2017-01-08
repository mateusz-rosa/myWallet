package com.mywallet.domain.repository;

import com.mywallet.domain.MoneyTransaction;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mateusz on 2017-01-08.
 */
public interface CategoryRepository extends CrudRepository<MoneyTransaction, Long> {
}
