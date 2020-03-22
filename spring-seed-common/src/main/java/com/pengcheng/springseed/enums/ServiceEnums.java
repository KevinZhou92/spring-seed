package com.pengcheng.springseed.enums;

import lombok.Getter;

@Getter
public enum ServiceException {

    SUCCESS("2000", "Successful Operation"),
    Failed("0000", "Failed Operation"),
    USER_EXISTED("0001", "Failed Operation"),
    INCORRECT_PASSWORD("0001", "Failed Operation");

    /**
     * Service Status Code
     * 2*** represents success
     * )*** represents exceptions
     */

    private String code;
    private String message;

    private ServiceException(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
