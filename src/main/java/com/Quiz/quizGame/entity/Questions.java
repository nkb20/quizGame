package com.Quiz.quizGame.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    String correctAnswer;
    String qsnType;

}
