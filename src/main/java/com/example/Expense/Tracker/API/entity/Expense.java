package com.example.Expense.Tracker.API.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Document(collection = "expenses")
public class Expense {
    @Id
    private String id;
    private Double amount;
    private String description;
    private String categoryId;
    private String userId;
    private LocalDate date;
}
