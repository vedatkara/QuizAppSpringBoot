package com.vedatkara.quizapp.controller;

import com.vedatkara.quizapp.Question;
import com.vedatkara.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")//For fetching data from a server use GetMapping
    public ResponseEntity<List<Question>> getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    //Data is in the body so we will RequestBody.
    //Also, data must be in JSON Format. Spring converts objects into JSON.
    @PostMapping("add")//For sending data to a server use PostMapping
    public String addQuestion(@RequestBody Question question) {
       return questionService.addQuestion(question);
    }

}
