package com.makeathon.surveypro.repository;

import com.makeathon.surveypro.entity.AnswerType;
import com.makeathon.surveypro.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerTypeRepository extends JpaRepository<AnswerType, Long> {

}
