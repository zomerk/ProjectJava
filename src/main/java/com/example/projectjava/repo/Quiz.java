package com.example.projectjava.repo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "QuizTable")

public class Quiz {
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long QuizId;
    @Column(name = "TitleQuiz")
    private String title;
    @Column(name = "QuizQuestion")
    private String text;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ans_id")
    private List<CorrectAnswears> ansNumber = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "quiz_id")
    private List<Answears> options = new ArrayList<>();
    @JsonIgnore
    public String  UserName;


}
