package com.example.Expense.Tracker.API.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExpenseRequest {
    private Double amount;
    private String description;
    private String categoryName;
    private String userName;
    private String dateString;
}
