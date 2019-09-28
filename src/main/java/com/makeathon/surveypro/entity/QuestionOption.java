package com.makeathon.surveypro.entity;

import javax.persistence.*;

@Entity
public class QuestionOption {
    @Id
    @Column(name = "questionoption_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionOptionId;
    @ManyToOne
    @JoinColumn(name = "survey_question_id")
    private SurveyQuestion survey;
    private String optionValue;

    public int getQuestionOptionId() {
        return questionOptionId;
    }

    public void setQuestionOptionId(int questionOptionId) {
        this.questionOptionId = questionOptionId;
    }

    public SurveyQuestion getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyQuestion survey) {
        this.survey = survey;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
}
