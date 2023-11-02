package com.example.projectjava.repo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UserRepository")
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String email;
    String password;
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
