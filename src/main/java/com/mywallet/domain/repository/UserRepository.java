package com.mywallet.domain.repository;

import com.mywallet.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mateusz on 2017-01-08.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
