package com.example.Expense.Tracker.API.controller;

import com.example.Expense.Tracker.API.entity.AuthenticationResponse;
import com.example.Expense.Tracker.API.entity.Category;
import com.example.Expense.Tracker.API.entity.Expense;
import com.example.Expense.Tracker.API.entity.User;
import com.example.Expense.Tracker.API.request.AuthRequest;
import com.example.Expense.Tracker.API.request.ExpenseRequest;
import com.example.Expense.Tracker.API.service.AuthenticationService;
import com.example.Expense.Tracker.API.service.CategoryService;
import com.example.Expense.Tracker.API.service.ExpenseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationService authService;
    private final CategoryService categoryService;
    private final ExpenseService expenseService;

    public AuthenticationController(AuthenticationService authService, CategoryService categoryService, ExpenseService expenseService) {
        this.authService = authService;
        this.categoryService = categoryService;
        this.expenseService = expenseService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User request) {
        return ResponseEntity.ok(authService.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
    @PostMapping("/refresh_token")
    public ResponseEntity refreshToken(HttpServletRequest request, HttpServletResponse response) {
        return authService.refreshToken(request, response);
    }


    @PostMapping("/add-category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
       return ResponseEntity.ok(categoryService.add(category));
    }
    @PostMapping("/delete-category")
    public ResponseEntity<String> delCategory(@RequestParam String name){
        categoryService.remove(name);
        return ResponseEntity.ok("The category was successfully deleted.");
    }

    @PostMapping("/add-expense")
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseRequest request){
        return ResponseEntity.ok(expenseService.add(request));
    }

    @PostMapping("/delete-expense")
    public ResponseEntity<String> delExpense(@RequestParam String id){
        expenseService.remove(id);
        return ResponseEntity.ok("The expense was successfully deleted.");
    }

    @PostMapping("/update-expense")
    public ResponseEntity<Expense> updateExpense(@RequestParam String id, @RequestBody ExpenseRequest request){
        return ResponseEntity.ok(expenseService.update(id, request));
    }

    @GetMapping("/get-expense")
    public ResponseEntity<List<Expense>> getAllExpenses(@RequestParam String stringDate){
        return ResponseEntity.ok(expenseService.findAllByDate(stringDate));
    }








}
