package com.example.projectjava.Utils;
import com.example.projectjava.Dto.QuizDto;
import com.example.projectjava.repo.Answears;
import com.example.projectjava.repo.CorrectAnswears;
import com.example.projectjava.repo.Quiz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class DtoConveerter {
    public static QuizDto ConvertQuizToQuizDto(Quiz quiz){
        var quizDto = new QuizDto();
        quizDto.setTitle(quiz.getTitle());
        quizDto.setText(quiz.getText());
        quizDto.setOptions(quiz.getOptions().stream().map(Answears::getAns).toList());
        quizDto.setAnswer(quiz.getAnsNumber().stream().map(CorrectAnswears::getValue).toList());
        quizDto.setId(quiz.getQuizId());
        return quizDto;
    }
    public static Quiz CreateQuizFromDto(QuizDto quizDto){
        var quiz = new Quiz();
        quiz.setTitle(quizDto.getTitle());
        quiz.setText(quizDto.getText());
        var listAns = new ArrayList<CorrectAnswears>();
        for (var ok:quizDto.getAnswer()){
            listAns.add(new CorrectAnswears(ok));
        }
        quiz.setAnsNumber(listAns);

        var list = new LinkedList<Answears>();
        for(var text:quizDto.getOptions()){
            list.add(new Answears(text));
        }
        quiz.setOptions(list);
        return quiz;
    }

}
