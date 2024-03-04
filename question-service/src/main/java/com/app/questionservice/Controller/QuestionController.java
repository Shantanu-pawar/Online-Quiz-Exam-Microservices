package com.app.questionservice.Controller;


import com.app.questionservice.Model.Question;
import com.app.questionservice.Model.QuestionWrapper;
import com.app.questionservice.Model.Response;
import com.app.questionservice.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired private QuestionService questionService;

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        try{
            String response = questionService.addQuestion(question);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("allQuestions")
    public ResponseEntity<?> getAllQuestions(@PathVariable String category) {
        try {
            List<Question> list = questionService.getAllQuestions(category);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("category/{category}")
    public ResponseEntity<?> getQuestionsByCategory(@PathVariable String category) {
        List<Question> list =  questionService.getQuestionsByCategory(category);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // directly getting statusCodes from
    @GetMapping("generate")
    public ResponseEntity<?> getQuestionForQuiz(@RequestParam String categoryName,
                                                @RequestParam int numberOfQuestion){
        return questionService.getQuestionForQuiz(categoryName, numberOfQuestion);
    }

    @PostMapping("getQuestion")
    // API: return questions list based on question id's
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId
            (@RequestBody List<Integer> questionIds){
        return questionService.getQuestionFromId(questionIds);
    }

    @GetMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> ansResponseList){
        int score =  questionService.getScore(ansResponseList);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
