package com.vedatkara.quizapp.service;

import com.vedatkara.quizapp.dao.QuestionDao;
import com.vedatkara.quizapp.dao.QuizDao;
import com.vedatkara.quizapp.model.Question;
import com.vedatkara.quizapp.model.QuestionWrapper;
import com.vedatkara.quizapp.model.Quiz;
import com.vedatkara.quizapp.model.Response;
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
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQues, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQues);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Quiz Created Successfully", HttpStatus.OK); //add exception handling later
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {

        Optional<Quiz> quiz = quizDao.findById(id); //It may return null. Optional!!
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(),
            q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();

        int correctAnswers = 0, i = 0;
        for(Response response: responses) {
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                correctAnswers++;
            i++;
        }

        return new ResponseEntity<>(correctAnswers, HttpStatus.OK);

    }
}
