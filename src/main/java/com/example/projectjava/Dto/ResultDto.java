package com.example.projectjava.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultDto {
    private boolean success;
    private String feedback;

    public ResultDto(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public boolean isSuccess() {
        return success;
    }

    public static ResultDto success() {
        var feedback = "Congratulations, you're right!";
        return new ResultDto(true, feedback);
    }

    public static ResultDto failure() {
        var feedback = "Wrong answer! Please, try again.";
        return new ResultDto(false, feedback);
    }
}