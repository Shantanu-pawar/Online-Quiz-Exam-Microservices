package com.app.quizservice.Repository;

import com.app.quizservice.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {
}
