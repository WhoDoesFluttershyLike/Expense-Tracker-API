package com.example.Expense.Tracker.API.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document(collection = "categories")
public class Category {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String description;
}

