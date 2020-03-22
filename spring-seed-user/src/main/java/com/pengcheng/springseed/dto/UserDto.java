package com.pengcheng.springseed.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    public UserDto() {}

    public UserDto(String userName, String firstName, String lastName, String email) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
