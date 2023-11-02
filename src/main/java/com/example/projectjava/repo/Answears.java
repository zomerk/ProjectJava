package com.example.projectjava.repo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AnwearsTable")
@Getter
@Setter
@NoArgsConstructor
public class Answears {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ans_id;

    @Column(name = "AnwerToQuiz")
    private String ans;

    public Answears(String ans) {
        this.ans = ans;
    }
}
