package com.quiz.Quiz.service.impl;

import com.quiz.Quiz.entities.Quiz;
import com.quiz.Quiz.repo.QuizRepo;
import com.quiz.Quiz.service.QuestionClient;
import com.quiz.Quiz.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService{
    private QuizRepo quizRepo;
    private QuestionClient questionClient;
    public QuizServiceImpl(QuizRepo quizRepo,QuestionClient questionClient) {
        this.quizRepo = quizRepo;
        this.questionClient=questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> get() {
       List<Quiz> quizzes= quizRepo.findAll();
      List<Quiz> newQuizList= quizzes.stream().map(quiz -> {
           quiz.setQuestion(questionClient.getQuestionOfQuiz(quiz.getId()));
           return quiz;
       }).collect(Collectors.toList());
       return newQuizList;
    }

    @Override
    public Quiz get(Long id) {

       Quiz quiz=quizRepo.findById(id).orElseThrow(() -> new RuntimeException("QUIZ NOT FOUND"));
        quiz.setQuestion(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
