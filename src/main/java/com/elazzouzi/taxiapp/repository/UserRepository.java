package com.elazzouzi.taxiapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.elazzouzi.taxiapp.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
