package com.app.quizservice.Feign;

import com.app.questionservice.Model.QuestionWrapper;
import com.app.questionservice.Model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

/*  so in this file it helping us to connecting the quiz to question-service
to access the methods from questions like (generate | getQuestions | getScore)

            ------- and here we're just declaring the methods not defining here --------
*/

    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName,
                                                @RequestParam int numberOfQuestion);

    @PostMapping("question/get-question")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId
                                                (@RequestBody List<Integer> questionIds);

    @GetMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> ansResponseList);

}
