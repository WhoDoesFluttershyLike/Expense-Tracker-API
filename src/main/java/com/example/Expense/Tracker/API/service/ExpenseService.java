package com.example.Expense.Tracker.API.service;

import com.example.Expense.Tracker.API.entity.Expense;
import com.example.Expense.Tracker.API.repository.CategoryRepository;
import com.example.Expense.Tracker.API.repository.ExpenseRepository;
import com.example.Expense.Tracker.API.repository.UserRepository;
import com.example.Expense.Tracker.API.request.ExpenseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public Expense add(ExpenseRequest request){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
       Expense expense = new Expense();
       expense.setAmount(request.getAmount());
       expense.setDescription(request.getDescription());
       expense.setCategoryId(categoryRepository.findIdByName(request.getCategoryName()));
       expense.setUserId(userRepository.findIdByName(request.getUserName()));
       expense.setDate(LocalDate.parse(request.getDateString(), formatter));
       expenseRepository.save(expense);
       return expense;
    }

    public void remove(String id){
        expenseRepository.deleteById(id);
    }

    public Expense update(String id, ExpenseRequest request){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        Optional<Expense> expense = expenseRepository.findById(id);
        expense.get().setAmount(request.getAmount());
        expense.get().setDescription(request.getDescription());
        expense.get().setCategoryId(categoryRepository.findIdByName(request.getCategoryName()));
        expense.get().setUserId(userRepository.findIdByName(request.getUserName()));
        expense.get().setDate(LocalDate.parse(request.getDateString(), formatter));
        expense.ifPresent(expenseRepository::save);
        return expense.get();
    }

    public List<Expense> findAllByDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate localDate = LocalDate.parse(stringDate, formatter);
        List<Expense> list1 = expenseRepository.findAll();
        List<Expense> list2 = new ArrayList<>();
        for (int i=0; i<list1.size(); i++){
            if (list1.get(i).getDate().isAfter(localDate)){
                list2.add(list1.get(i));
            }
        }
        return list2;
    }

}
