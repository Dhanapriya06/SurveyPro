package com.makeathon.surveypro.repository;

import com.makeathon.surveypro.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<SurveyEntity, Integer> {
    List<SurveyEntity> findByUser_UserId(int userId);

    @Override
    Optional<SurveyEntity> findById(Integer integer);

    @Query(value = "select survey_id, survey_name, survey_desc from survey_details where start_date < now() and now() < end_date and is_open = true",nativeQuery = true)
    List<Object> findAllOpenSurveys();
}
