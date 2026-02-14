package com.ymsli.bank.inhouse.repository;

import com.ymsli.bank.inhouse.model.Account;
import com.ymsli.bank.inhouse.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	 Optional<User> findByUsername(String username);
}
