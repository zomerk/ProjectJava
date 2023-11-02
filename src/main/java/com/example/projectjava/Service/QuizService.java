package com.example.projectjava.Service;


import com.example.projectjava.CrudRepo.CrudComplitedQuiz;
import com.example.projectjava.CrudRepo.CrudQuiz;
import com.example.projectjava.Dto.QuizDto;
import com.example.projectjava.Dto.ResultDto;
import com.example.projectjava.Utils.DtoConveerter;
import com.example.projectjava.repo.CompletedQuiz;
import com.example.projectjava.repo.CorrectAnswears;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizService {
    public final CrudQuiz crudQuiz;
    public final CrudComplitedQuiz crudComplitedQuiz;

    public QuizService(CrudQuiz crudQuiz,CrudComplitedQuiz crudComplitedQuiz) {

        this.crudQuiz = crudQuiz;
        this.crudComplitedQuiz = crudComplitedQuiz;
    }
    public Page<QuizDto> GetAllQuizes(int element){
        var page = PageRequest.of(element,10);
        var quiz = crudQuiz.findAll(page);
        var lista = quiz.stream().map(DtoConveerter::ConvertQuizToQuizDto).toList();
        Page<QuizDto> a = new PageImpl<>(lista,page,lista.size());
        return a;
    }
    public ResponseEntity<?> CreateQuiz(QuizDto quizDto){
        var createdQuiz = DtoConveerter.CreateQuizFromDto(quizDto);
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        createdQuiz.setUserName(authentication.getName());
        crudQuiz.save(createdQuiz);
        return ResponseEntity.ok(DtoConveerter.ConvertQuizToQuizDto(createdQuiz));
    }
    public ResponseEntity<?> findById(long id) {
        var optionalQuiz = crudQuiz.findById(id);
        if (optionalQuiz.isEmpty()) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.ok(DtoConveerter.ConvertQuizToQuizDto(optionalQuiz.get()));
        }
    }
    public ResponseEntity<?> CheckIfCorrectAnswer(List<Integer> Answer, Long id){
        if(crudQuiz.findById(id).isEmpty()){
            return ResponseEntity.status(404).build();
        }
        else {
            var quiz = crudQuiz.findById(id);
            if(quiz.get().getAnsNumber().stream().map(CorrectAnswears::getValue).toList().equals(Answer)){
                org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                crudComplitedQuiz.save(new CompletedQuiz(id, LocalDateTime.now(),authentication.getName()));
                return ResponseEntity.ok(ResultDto.success());
            }
            else{
                return ResponseEntity.ok(ResultDto.failure());
            }
        }
    }
    public ResponseEntity<?> DeleteQuiz(long id){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var optionalQuiz = crudQuiz.findById(id);
        if (optionalQuiz.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        if(authentication.getName().equals(optionalQuiz.get().getUserName())) {
                crudQuiz.deleteById(id);
                return ResponseEntity.status(204).build();
            }
        else {
            return ResponseEntity.status(403).build();
        }

    }
    public ResponseEntity<?> GetAllAnswears(int element){
        var page = PageRequest.of(element,10, Sort.by("completedAt").descending());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(crudComplitedQuiz.findAllBythePeopleThatAnswearEquals(authentication.getName(),page));
    }

}
