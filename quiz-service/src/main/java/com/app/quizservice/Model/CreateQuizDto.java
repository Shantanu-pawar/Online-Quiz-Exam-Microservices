package com.app.quizservice.Model;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class CreateQuizDto {
    private String category;
    private String title;
    private int numberOfQuestions;

    public CreateQuizDto(String category, String title, int numberOfQuestions) {
        this.category = category;
        this.title = title;
        this.numberOfQuestions = numberOfQuestions;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }
}
