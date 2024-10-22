package com.example.Expense.Tracker.API.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;


@Getter
@Setter
@Document(collection = "users")
public class User implements UserDetails {
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String password;
    private LocalDate createdAt = LocalDate.now();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
