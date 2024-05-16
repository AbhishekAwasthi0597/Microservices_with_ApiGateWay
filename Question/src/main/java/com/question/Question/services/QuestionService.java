package com.question.Question.services;

import com.question.Question.entities.Question;

import java.util.List;

public interface QuestionService {
    Question add(Question question);
    List<Question> get();
    Question getById(Long id);
    List<Question> getQuestionOfQuiz(Long quizId);
}
