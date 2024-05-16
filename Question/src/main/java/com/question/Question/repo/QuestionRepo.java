package com.question.Question.repo;

import com.question.Question.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Long> {
    List<Question> findByQuizId(Long quizId);
}
