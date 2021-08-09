package com.capgemini.persistance;

/**
 * This is an user repository that ended not being used in the final version
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
