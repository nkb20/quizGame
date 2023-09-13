package com.Quiz.quizGame.controller;

import com.Quiz.quizGame.entity.QuizAnswers;
import com.Quiz.quizGame.entity.WrapperQuestion;
import com.Quiz.quizGame.service.QuizService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("quiz/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);

    }

    @GetMapping("quiz/{i}")
    public List<WrapperQuestion> showCreatedQuiz(@PathVariable int i) {
        return quizService.showCreatedQuiz(i);
    }

    @PostMapping("quiz/submit/{i}")
    public ResponseEntity<String> getAnswer(@RequestBody List<QuizAnswers> quizAnswers, @PathVariable int i) {
        return quizService.getAnswer(i,quizAnswers);
    }


}
