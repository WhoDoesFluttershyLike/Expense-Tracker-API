package com.example.Expense.Tracker.API.repository;

import com.example.Expense.Tracker.API.entity.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends MongoRepository<Token, String> {
    @Query("{ 'userId': ?0, 'loggedOut': false }")
    List<Token> findByUserIdAndLoggedOutFalse(String userId);

    Optional<Token> findByAccessToken(String token);

    Optional<Token > findByRefreshToken(String token);
}
