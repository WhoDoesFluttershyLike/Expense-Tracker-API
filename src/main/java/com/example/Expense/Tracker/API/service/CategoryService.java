package com.example.Expense.Tracker.API.service;

import com.example.Expense.Tracker.API.entity.Category;
import com.example.Expense.Tracker.API.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    public Category add(Category category){
        categoryRepository.save(category);
        return category;
    }

    public void remove(String name){
        Category category = categoryRepository.findByName(name);
        categoryRepository.delete(category);
    }
}
