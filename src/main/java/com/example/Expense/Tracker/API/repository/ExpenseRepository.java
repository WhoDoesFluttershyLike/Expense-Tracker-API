package com.example.Expense.Tracker.API.repository;

import com.example.Expense.Tracker.API.entity.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense,String> {

}
