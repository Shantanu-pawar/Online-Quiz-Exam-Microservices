package com.app.questionservice.Repository;

import com.app.questionservice.Model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question WHERE category = :category \n" +
            "LIMIT :numOfQues", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numOfQues);

}
