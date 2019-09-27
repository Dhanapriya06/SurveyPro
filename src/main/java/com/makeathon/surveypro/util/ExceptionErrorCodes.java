package com.makeathon.surveypro.util;

public enum ExceptionErrorCodes {

    USERNAME_ALREADY_REGISTERED(100),
    NO_SUCH_PLATFORM_FOUND(101),
    INVALID_OTP(102),
    ROLE_NOT_FOUND(103),
    INVALID_COUNTRY(104),
    USER_NOT_FOUND(105),
    BAD_CREDENTAIL(106),
    EMAIL_ALREADY_REGISTERED(107);

    private int errorCode;

    ExceptionErrorCodes(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
