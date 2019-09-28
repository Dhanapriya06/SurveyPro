package com.makeathon.surveypro.service;

import com.makeathon.surveypro.entity.SurveyEntity;
import com.makeathon.surveypro.model.request.SurveyRequest;

import java.util.List;
import java.util.Optional;

public interface SurveyService {
    public SurveyEntity insertSurvey(SurveyRequest survey);

    public void updateSurvey(int surveyId);

    public List<SurveyEntity> getSurveyByUserId(int userId);

    public Optional<SurveyEntity> getSurveyBySurveyId(int surveyId);

    public void deleteSurvey(int surveyId);
}
