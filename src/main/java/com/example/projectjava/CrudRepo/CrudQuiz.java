package com.example.projectjava.CrudRepo;

import com.example.projectjava.repo.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CrudQuiz extends CrudRepository<Quiz,Long>, PagingAndSortingRepository<Quiz,Long> {
}
