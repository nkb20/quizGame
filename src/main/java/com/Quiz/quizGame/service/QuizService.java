package com.Quiz.quizGame.service;

import com.Quiz.quizGame.dao.QuesDao;
import com.Quiz.quizGame.dao.QuizDao;
import com.Quiz.quizGame.entity.QuizAnswers;
import com.Quiz.quizGame.entity.WrapperQuestion;
import com.Quiz.quizGame.entity.Questions;
import com.Quiz.quizGame.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuesDao quesDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Questions> question = quesDao.findRandomQuestionsByqsnType(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(question);
        quizDao.save(quiz);
        String name = quiz.getId().toString();
        return new ResponseEntity<>("created with id "+name, HttpStatus.CREATED);
    }

    public List<WrapperQuestion> showCreatedQuiz(int i) {
        Optional<Quiz> quiz = quizDao.findById(i);
        List<Questions> questionsFromDb = quiz.get().getQuestions();
        List<WrapperQuestion> questionForUser = new ArrayList<>();

        for (Questions q : questionsFromDb) {
            WrapperQuestion qq = new WrapperQuestion(q.getId(), q.getQuestion(),
                    q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionForUser.add(qq);
        }
        return questionForUser;
    }

    public ResponseEntity<String> getAnswer(int i, List<QuizAnswers> quizAnswers) {
        Optional<Quiz> quiz = quizDao.findById(i);
        List<Questions> questionsFromDb = quiz.get().getQuestions();
        int result = 0;
        int a = 0;
        for (Questions q : questionsFromDb) {
            if (q.getCorrectAnswer().equals(quizAnswers.get(a).getOption())) {
                result++;
            }
            a++;
        }
        return new ResponseEntity<>("your Score is "+result,HttpStatus.OK);

    }
}
