package com.vedatkara.quizapp.dao;

import com.vedatkara.quizapp.Question;
import org.springframework.data.jpa.repository.JpaRepository;

//All things like fetching data from db, saving the data will be
//handled by JPA.
public interface QuestionDao extends JpaRepository<Question, Integer> {


}
