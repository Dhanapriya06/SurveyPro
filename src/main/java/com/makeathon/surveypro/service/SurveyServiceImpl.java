package com.makeathon.surveypro.service;

import com.makeathon.surveypro.entity.SurveyEntity;
import com.makeathon.surveypro.entity.User;
import com.makeathon.surveypro.model.request.SurveyRequest;
import com.makeathon.surveypro.repository.SurveyRepository;
import com.makeathon.surveypro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public SurveyEntity insertSurvey(SurveyRequest survey, long userId) {
        SurveyEntity se = survey.toSurveyEntity();
        User user = userRepository.findByUserId(userId).get();
        se.setUser(user);
        SurveyEntity se1 = surveyRepository.save(se);
        return se1;
    }

    @Override
    public List<Object> getAllOpenSurveys() {
        return surveyRepository.findAllOpenSurveys();
    }


    @Override
    public void updateSurvey(int surveyId) {
        surveyRepository.findById(surveyId);
    }

    @Override
    public List<SurveyEntity> getSurveyByUserId(int userId) {
        return surveyRepository.findByUser_UserId(userId);
    }

    @Override
    public Optional<SurveyEntity> getSurveyBySurveyId(int surveyId) {
        return surveyRepository.findById(surveyId);
    }

    @Override
    public void deleteSurvey(int surveyId) {
        surveyRepository.deleteById(surveyId);
    }
}
