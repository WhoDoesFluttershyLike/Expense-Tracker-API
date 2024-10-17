package com.example.Expense.Tracker.API.repository;

import com.example.Expense.Tracker.API.entity.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense,String> {
    @Query(value = "{ 'id': ?0 }", delete = true)
    void deleteById(String id);

//    @Query("{ 'expenseDate' : { $gte: ?0 } }")
//    List<Expense> findExpensesByDate(LocalDate date);
}
