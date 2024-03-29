package com.makeathon.surveypro.repository;

import com.makeathon.surveypro.entity.AnswerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerTypeRepository extends JpaRepository<AnswerType, Long> {

}
