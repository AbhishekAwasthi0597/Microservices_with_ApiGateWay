package com.question.Question.controller;

import com.question.Question.entities.Question;
import com.question.Question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping()
    public Question add(@RequestBody Question question){
        return questionService.add(question);
    }
    @GetMapping()
    public List<Question> getAll(){
        return questionService.get();
    }
    @GetMapping("/{id}")
    public  Question getById(@PathVariable Long id){
        return questionService.getById(id);
    }
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionOfQuiz(@PathVariable Long quizId){
        return questionService.getQuestionOfQuiz(quizId);
    }
}
