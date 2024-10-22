package com.example.Expense.Tracker.API.repository;

import com.example.Expense.Tracker.API.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    @Query(value = "{ 'name': ?0 }", fields = "{ 'id': 1, '_id': 0 }")
    String findIdByName(String name);

    @Query("{ 'name': ?0 }")
    Category findByName(String name);
}



