package com.example.projectjava.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Getter
@Setter
public class QuizDto {
    private long id;
    @NotBlank(message = "Quiz title should not be empty")
    private String title;

    @NotBlank(message = "Quiz title should not be empty")
    private String text;
    @Size(min = 2, message = "Quiz must contain at least two options")
    private List<String> options = new ArrayList<>();
    private List<Integer> answer = new ArrayList<>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public List<Integer> getAnswer() {
        return answer;
    }



}
