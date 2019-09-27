package com.makeathon.surveypro.model.response;

import java.util.Date;

public class APIResponse {

    private boolean error;
    private Date timestamp;
    private String message;
    private String details;
    private int errorCode;

    public APIResponse() {
        this.timestamp = new Date();
        this.errorCode = -1;
    }

    public APIResponse(boolean error, String message) {
        this();
        this.error = error;
        this.message = message;
    }

    public APIResponse(boolean error, String message, int errorCode) {
        this();
        this.error = error;
        this.message = message;
        this.errorCode = errorCode;
    }

    public APIResponse(boolean error, String message, String details) {
        this();
        this.error = error;
        this.message = message;
        this.details = details;
    }

    public APIResponse(boolean error, String message, String details, int errorCode) {
        this();
        this.error = error;
        this.message = message;
        this.details = details;
        this.errorCode = errorCode;
    }

    public APIResponse(boolean error, Date timestamp, String message, String details, int errorCode) {
        this();
        this.error = error;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.errorCode = errorCode;
    }


    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
