package com.makeathon.surveypro.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class AnswerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerTypeId;

    @NotBlank
    @Size(min = 3)
    private String username;

    public long getAnswerTypeId() {
        return answerTypeId;
    }

    public void setAnswerTypeId(long answerTypeId) {
        this.answerTypeId = answerTypeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
