package com.pengcheng.springseed.enums;

import lombok.Getter;

@Getter
public enum ServiceEnums {

    SUCCESS("2000", "Successful Operation."),
    FAILED("0000", "Failed Operation."),
    USER_EXISTED("0001", "User already exists."),
    USER_NOT_EXISTED("0002", "User doesn't exist."),
    INCORRECT_PASSWORD("0003", "Password is incorrect."),
    PARAMETER_BIND_FAIL("0004", "Parameter is invalid."),
    CONSTRAINT_VIOLATIONS("0005", "Parameter is invalid.");

    /**
     * Service Status Code
     * 2*** represents success
     * )*** represents exceptions
     */

    private String code;
    private String message;

    private ServiceEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
