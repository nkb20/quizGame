package com.Quiz.quizGame.dao;

import com.Quiz.quizGame.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuesDao extends JpaRepository<Questions, Integer> {
    @Query(value ="SELECT * FROM questions q WHERE q.qsn_type =:category order by Rand() LIMIT :numQ",nativeQuery = true)
    List<Questions> findRandomQuestionsByqsnType(String category, int numQ);

    List<Questions> findByQsnType(String qsn_type);
}
