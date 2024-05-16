package com.quiz.Quiz.repo;

import com.quiz.Quiz.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz,Long> {

}
