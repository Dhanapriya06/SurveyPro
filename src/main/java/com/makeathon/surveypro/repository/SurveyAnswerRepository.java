package com.makeathon.surveypro.repository;

import com.makeathon.surveypro.entity.SurveyAnswer;
import com.makeathon.surveypro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyAnswerRepository extends JpaRepository<SurveyAnswer, Integer> {

}



