package com.example.projectjava.CrudRepo;

import com.example.projectjava.repo.CompletedQuiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CrudComplitedQuiz extends PagingAndSortingRepository<CompletedQuiz,Long>, CrudRepository<CompletedQuiz,Long> {
    Page<CompletedQuiz> findAllBythePeopleThatAnswearEquals(String ThePeopleThatAnswear, Pageable pageable);
}
