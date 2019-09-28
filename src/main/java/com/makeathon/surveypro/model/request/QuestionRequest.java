package com.makeathon.surveypro.model.request;

import java.util.List;

public class QuestionRequest {

    private String question;

    private int questionType;

    private List<String> questionOptions;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public List<String> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(List<String> questionOptions) {
        this.questionOptions = questionOptions;
    }


}
