package com.quiz.Quiz.service;

import com.quiz.Quiz.entities.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuizService {
    Quiz add(Quiz quiz);
    List<Quiz> get();
    Quiz get(Long id);
}
