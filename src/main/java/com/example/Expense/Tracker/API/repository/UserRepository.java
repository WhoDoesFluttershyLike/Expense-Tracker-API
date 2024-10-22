package com.example.Expense.Tracker.API.repository;

import com.example.Expense.Tracker.API.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

    @Query(value = "{ 'username': ?0 }", fields = "{ 'id': 1, '_id': 0 }")
    String findIdByName(String username);
}
