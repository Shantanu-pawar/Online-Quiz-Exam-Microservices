package com.app.questionservice.Service;

import com.app.questionservice.Model.Question;
import com.app.questionservice.Model.QuestionWrapper;
import com.app.questionservice.Model.Response;
import com.app.questionservice.Repository.QuestionRepo;
import com.app.quizservice.Model.Quiz;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

    public String addQuestion(Question question) {
        questionRepo.save(question);
        return "success";
    }

    public List<Question> getAllQuestions(String category) {
        List<Question> questionList = questionRepo.findAll();
        return questionList;
    }

    public List<Question> getQuestionsByCategory(String category) {
        List<Question> questionList = questionRepo.findByCategory(category);
        return questionList;
    }

    public ResponseEntity<List<Integer>> getQuestionForQuiz(String categoryName, Integer numberOfQuestion) {
        // return the list of integers
        List<Integer> questions = questionRepo.findRandomQuestionsByCategory(categoryName, numberOfQuestion);
        return new ResponseEntity<>(questions, HttpStatus.OK);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(List<Integer> questionIds) {
        // we're just getting the data and setting it from database.
        List<QuestionWrapper> wrappers = new ArrayList<>();
        for (int id : questionIds) {
            Question question = questionRepo.findById(id).get();
            QuestionWrapper set = new QuestionWrapper(question.getId(), question.getQuestionTitle(),
                    question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
            wrappers.add(set);
        }
        return new ResponseEntity<>(wrappers, HttpStatus.OK);
    }

    public int getScore(List<Response> ansResponseList) {
        int ansCount = 0;
        for (Response response : ansResponseList) {
            Question question = questionRepo.findById(response.getId()).get();

            if (response.getAnsResponse().equals(question.getRightAnswer())) {
                ansCount++;
            }
        }
        return ansCount;
    }
}
