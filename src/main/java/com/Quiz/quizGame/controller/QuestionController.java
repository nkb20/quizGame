package com.Quiz.quizGame.controller;

import com.Quiz.quizGame.entity.Questions;
import com.Quiz.quizGame.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("questions")
    public List<Questions> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("questions/{category}")
    public List<Questions> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("question/post")
    public ResponseEntity<String> postQuestion(@RequestBody Questions questions) {
        return questionService.postQuestion(questions);
    }
}
