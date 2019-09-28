package com.makeathon.surveypro.entity;

import javax.persistence.*;

@Entity
@Table(name = "SURVEY_ANSWER")
public class SurveyAnswer {

    @Id
    @Column(name = "survey_answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int surveyAnswerId;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private SurveyQuestion surveyQuestion;

    private String ipAddress;

    private String macAddress;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "questionoption_id")
    private QuestionOption questionOption;

    public int getSurveyAnswerId() {
        return surveyAnswerId;
    }

    public void setSurveyAnswerId(int surveyAnswerId) {
        this.surveyAnswerId = surveyAnswerId;
    }

    public SurveyQuestion getSurveyQuestion() {
        return surveyQuestion;
    }

    public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
        this.surveyQuestion = surveyQuestion;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public QuestionOption getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(QuestionOption questionOption) {
        this.questionOption = questionOption;
    }
}
