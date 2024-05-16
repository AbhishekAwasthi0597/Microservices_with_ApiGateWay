package com.question.Question.services.impl;

import com.question.Question.entities.Question;
import com.question.Question.repo.QuestionRepo;
import com.question.Question.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImp implements QuestionService {
    private QuestionRepo questionRepo;

    public QuestionServiceImp(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    public Question add(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepo.findAll();
    }

    @Override
    public Question getById(Long id) {
        return questionRepo.findById(id).orElseThrow(()->new RuntimeException("QUESTION NOT FOUND"));
    }

    @Override
    public List<Question> getQuestionOfQuiz(Long quizId) {
        return questionRepo.findByQuizId(quizId);
    }
}
