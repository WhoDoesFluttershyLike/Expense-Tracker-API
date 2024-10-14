package com.example.Expense.Tracker.API.repository;

import com.example.Expense.Tracker.API.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
