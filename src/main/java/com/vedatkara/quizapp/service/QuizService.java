package com.vedatkara.quizapp.service;

import com.vedatkara.quizapp.dao.QuestionDao;
import com.vedatkara.quizapp.dao.QuizDao;
import com.vedatkara.quizapp.model.Question;
import com.vedatkara.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQues, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQues);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Quiz Created Successfully", HttpStatus.OK); //add debug later


    }
}
