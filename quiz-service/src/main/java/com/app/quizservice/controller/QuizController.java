package com.app.quizservice.controller;
import com.app.questionservice.Model.Question;
import com.app.questionservice.Model.QuestionWrapper;
import com.app.questionservice.Model.Response;
import com.app.quizservice.Model.CreateQuizDto;
import com.app.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody CreateQuizDto dto){
        return quizService.createQuiz(dto);
    }


//     here we're getting all the questions from quiz


//    @GetMapping("get/{id}")
//    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
//        List<QuestionWrapper> list =  quizService.getQuizQuestions(id);
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }
//
//    @PostMapping("submit/{id}")
//    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
//        return quizService.calculateResult(id, responses);
//    }

}
