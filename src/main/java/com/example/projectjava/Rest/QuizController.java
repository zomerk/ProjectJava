package com.example.projectjava.Rest;


import com.example.projectjava.Dto.AnswerDTO;
import com.example.projectjava.Dto.QuizDto;
import com.example.projectjava.Service.QuizService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {


    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @PostMapping("/api/quizzes")
    public ResponseEntity<?> CreateQuiz(@Valid @RequestBody QuizDto quizDto){
        return quizService.CreateQuiz(quizDto);
    }
    @GetMapping("/api/quizzes")
    public Page<QuizDto> GetListOfAllQuizes(@RequestParam int page){
        return quizService.GetAllQuizes(page);
    }
    @GetMapping("/api/quizzes/completed")
    public ResponseEntity<?> GetResults(@RequestParam int page){
        return quizService.GetAllAnswears(page);
    }
    @PostMapping("/api/quizzes/{id}/solve")
    public ResponseEntity<?> SolveQuiz(@PathVariable Long id, @RequestBody AnswerDTO answer){
        return quizService.CheckIfCorrectAnswer(answer.getAnswer(),id);

    }
    @GetMapping("/api/quizzes/{id}")
    public ResponseEntity<?> GetListQuizes(@PathVariable Long id){
        return quizService.findById(id);
    }


    @DeleteMapping("/api/quizzes/{id}")
    public ResponseEntity<?> DeleteQuiz(@PathVariable Long id){
        return quizService.DeleteQuiz(id);
    }


}
