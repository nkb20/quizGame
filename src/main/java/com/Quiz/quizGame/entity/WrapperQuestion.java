package com.Quiz.quizGame.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WrapperQuestion {
    Integer id;
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
}
