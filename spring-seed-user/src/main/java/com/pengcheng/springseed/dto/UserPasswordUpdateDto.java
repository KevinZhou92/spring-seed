package com.pengcheng.springseed.dto;

import com.sun.istack.Nullable;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserPasswordUpdateDto {
    @NotBlank
    private String userName;

    @NotBlank
    private String oldPassword;

    @Nullable
    private String newPassword;

}
