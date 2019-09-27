package com.makeathon.surveypro.exception;

public class UserAlreadyExistException extends Exception {

    private int errorCode;

    public UserAlreadyExistException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
