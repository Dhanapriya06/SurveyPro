package com.makeathon.surveypro.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.makeathon.surveypro.entity.SurveyEntity;
import com.makeathon.surveypro.entity.User;

import java.util.Date;
import java.util.List;

public class SurveyRequest {

    List<QuestionRequest> questionRequestList;
    private String surveyName;
    private String surveyDescription;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fromDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date endDate;

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

    public SurveyEntity toSurveyEntity() {
        SurveyEntity se = new SurveyEntity();
        se.setEndDate(this.getEndDate());
        se.setOpen(true);
        se.setStartDate(this.getFromDate());
        se.setSurveyDesc(this.getSurveyDescription());
        se.setSurveyName(this.getSurveyName());
        //need to set user details
        se.setUser(new User());
        return se;
    }
}
