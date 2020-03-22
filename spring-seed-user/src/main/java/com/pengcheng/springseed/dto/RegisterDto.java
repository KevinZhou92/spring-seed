package com.pengcheng.springseed.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterDto {

    private String firstName;

    private String lastName;

    @NotBlank(message = "Please provide a non-empty user name")
    private String userName;

    private String email;

    @NotBlank(message = "Please provide a non-empty password")
    private String password;
}
