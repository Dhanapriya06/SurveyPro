package com.makeathon.surveypro.entity;

import javax.persistence.*;

@Entity
@Table(name = "SURVEY_QUESTION")
public class SurveyQuestion {

    @Id
    @Column(name = "survey_question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int surveyQuestionId;

    private String question;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private SurveyEntity survey;

    @ManyToOne
    @JoinColumn(name = "answertype_id")
    private AnswerType answerType;

    public int getSurveyQuestionId() {
        return surveyQuestionId;
    }

    public void setSurveyQuestionId(int surveyQuestionId) {
        this.surveyQuestionId = surveyQuestionId;
    }

    public SurveyEntity getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyEntity survey) {
        this.survey = survey;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }
}
