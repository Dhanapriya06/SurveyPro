package com.makeathon.surveypro.entity;

import javax.persistence.*;

@Entity
@Table(name = "SURVEY_QUESTION")
public class SurveyQuestion {
    @Id
    @Column(name="survey_question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int surveyQuestionId;
    @ManyToOne
    @JoinColumn(name = "survey_id")
    private SurveyEntity survey;
    private String question;
   // private AnswerType answerType;


}
