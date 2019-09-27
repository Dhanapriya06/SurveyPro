package com.makeathon.surveypro.exception;

public class RoleNotFoundException extends Exception {

    private int errorCode;

    public RoleNotFoundException(int errorCode) {
        super("User Role not set.");
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
