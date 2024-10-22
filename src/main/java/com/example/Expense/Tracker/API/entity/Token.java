package com.example.Expense.Tracker.API.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter

@Document(collection = "token")
public class Token {
    @Id
    private String id;

    private String accessToken;

    private String refreshToken;

    private boolean loggedOut;
    private User user;
}
