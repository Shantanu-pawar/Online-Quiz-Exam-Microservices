package com.app.quizservice.service;

import com.app.questionservice.Model.Question;
import com.app.questionservice.Model.QuestionWrapper;
import com.app.questionservice.Model.Response;
import com.app.questionservice.Repository.QuestionRepo;
import com.app.quizservice.Feign.QuizInterface;
import com.app.quizservice.Model.CreateQuizDto;
import com.app.quizservice.Model.Quiz;
import com.app.quizservice.Repository.QuizRepository;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired private QuizRepository quizRepository;
    @Autowired private QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(CreateQuizDto dto) {

        // calling the method through feign client here
        List<Integer> questions = quizInterface.getQuestionForQuiz
                                    (dto.getCategory(), dto.getNumberOfQuestions()).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(dto.getTitle());
        quiz.setQuestions(questions); // we're set this questions List here
        quizRepository.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz = quizRepository.findById(id).get();

        // here we're just providing list of integers to get all the questions from backend
        List<Integer> quesList = quiz.getQuestions();
        ResponseEntity<List<QuestionWrapper>> ques = quizInterface.getQuestionFromId(quesList);
        return ques;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        // here we're just requesting the list from quiz to questions to get Score.
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}
