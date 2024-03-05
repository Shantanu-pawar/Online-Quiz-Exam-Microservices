package com.app.quizservice.service;

import com.app.questionservice.Model.Question;
import com.app.questionservice.Model.QuestionWrapper;
import com.app.questionservice.Repository.QuestionRepo;
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

    public ResponseEntity<String> createQuiz(CreateQuizDto dto) {

        Question quest = new Question();
//        Quiz quiz = new Quiz(dto.getCategory(), dto.getTitle(), dto.getNumberOfQuestions());
//        quiz.setTitle(title);
//        quiz.setQuestions(questions);
//        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

//    public List<QuestionWrapper> getQuizQuestions(Integer id) {
//        Optional<Quiz> quiz = quizRepository.findById(id);
//        List<Integer> quesList = quiz.get().getQuestions();
//        List<QuestionWrapper> questionsForUser = new ArrayList<>();
//        for(int queNo : quesList){
//
//            QuestionWrapper qw = new QuestionWrapper(queNo.get(), queNo.getQuestionTitle(), queNo.getOption1(), queNo.getOption2(), queNo.getOption3(), queNo.getOption4());
//            questionsForUser.add(qw);
//        }
//
//        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
//
//    }

//    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
//        Quiz quiz = quizDao.findById(id).get();
//        List<Integer> questions = quiz.getQuestions();
//        int right = 0;
//        int i = 0;
//        for(Response response : responses){
//            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
//                right++;
//
//            i++;
//        }
//        return new ResponseEntity<>(right, HttpStatus.OK);
//    }
//

}
