package com.maotion.microuser.repositories;

import com.maotion.microuser.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserAccount, Long> {
}
