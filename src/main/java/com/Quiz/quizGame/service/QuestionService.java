package com.Quiz.quizGame.service;

import com.Quiz.quizGame.dao.QuesDao;
import com.Quiz.quizGame.entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuesDao quiDao;

    public List<Questions> getQuestions() {
        return quiDao.findAll();
    }

    public ResponseEntity<String> postQuestion(Questions questions) {
        quiDao.save(questions);
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }

    public List<Questions> getQuestionsByCategory(String qsnType) {
        return quiDao.findByQsnType(qsnType);
    }
}
