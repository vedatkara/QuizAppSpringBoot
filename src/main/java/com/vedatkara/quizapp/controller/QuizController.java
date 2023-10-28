package com.vedatkara.quizapp.controller;

import com.vedatkara.quizapp.model.QuestionWrapper;
import com.vedatkara.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQues,
                                             @RequestParam String title) {

        //To accept url variables use RequestParam annotation.
        return quizService.createQuiz(category, numQues, title);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id) {

        return quizService.getQuiz(id);
    }
}
