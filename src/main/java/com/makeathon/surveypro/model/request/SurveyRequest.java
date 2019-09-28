package com.makeathon.surveypro.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class SurveyRequest {

    private String surveyName;

    private String surveyDescription;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fromDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date endDate;

    List<QuestionRequest> questionRequestList;


    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getSurveyDescription() {
        return surveyDescription;
    }

    public void setSurveyDescription(String surveyDescription) {
        this.surveyDescription = surveyDescription;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<QuestionRequest> getQuestionRequestList() {
        return questionRequestList;
    }

    public void setQuestionRequestList(List<QuestionRequest> questionRequestList) {
        this.questionRequestList = questionRequestList;
    }
}
