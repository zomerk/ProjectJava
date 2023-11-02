package com.example.projectjava.repo;
import jakarta.persistence.*;

@Entity
@Table(name = "Poprawne_Odpowiedzi")
public class CorrectAnswears {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "PoprawneOdp")
    private Integer value;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public CorrectAnswears(int value) {
        this.value = value;
    }
    public CorrectAnswears() {
    }
}
