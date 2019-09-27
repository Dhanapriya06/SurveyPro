package com.makeathon.surveypro.util;

public interface ValidationError {

    String INVALID_EMAIL_LENGTH_KEY = "8000";
    String INVALID_PASSWORD_LENGTH_KEY = "8001";
    String INVALID_USERNAME_LENGTH_KEY = "8002";
    String INVALID_ROLE_LENGTH_KEY = "8003";


    static String getMessage(String errorCode) {
        switch (errorCode) {
            case "8000":
                return "Invalid EMAIL Length";
            case "8001":
                return "Invalid Password Length";
            case "8002":
                return "Invalid Username Length";
            case "8003":
                return "Invalid Role Length";
            default:
                return "Validation Failed";
        }
    }


}
