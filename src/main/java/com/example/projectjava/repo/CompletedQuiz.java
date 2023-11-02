package com.example.projectjava.repo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CompletedQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long Id_real;
    long id;
    LocalDateTime completedAt;
    @JsonIgnore
    String thePeopleThatAnswear;

    public CompletedQuiz(long id, LocalDateTime completedAt,String user) {
        this.id = id;
        this.completedAt = completedAt;
        this.thePeopleThatAnswear = user;
    }

    public CompletedQuiz() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getthePeopleThatAnswear() {
        return thePeopleThatAnswear;
    }

    public void setthePeopleThatAnswear(String thePeopleThatAnswear) {
        thePeopleThatAnswear = thePeopleThatAnswear;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
