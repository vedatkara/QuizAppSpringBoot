package com.vedatkara.quizapp.dao;

import com.vedatkara.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//All things like fetching data from db, saving the data will be
//handled by JPA.

/*
DAO stands for Data Access Object.
Usually, the DAO class is responsible for two concepts; encapsulating the details of the persistence layer
and providing a CRUD interface for a single entity.
 */
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value= "SELECT * FROM questions q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQues" ,nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQues);
}
