package com.codecastle.repositories;

import com.codecastle.models.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for handling the User data.
 */
@Repository
public interface UserRepository extends CrudRepository<AppUser, Long> {


    AppUser findByUsername(String username);

}
