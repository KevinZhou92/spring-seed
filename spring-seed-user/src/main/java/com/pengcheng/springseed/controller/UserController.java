package com.pengcheng.springseed.controller;

import com.pengcheng.springseed.dto.RegisterDto;
import com.pengcheng.springseed.dto.UserDto;
import com.pengcheng.springseed.service.UserService;
import com.pengcheng.springseed.service.results.BaseResult;
import com.pengcheng.springseed.service.results.FailResult;
import com.pengcheng.springseed.service.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/status")
    public String sayHello() {
        return "Hello World!";
    }

    @PostMapping(path = "/register")
    @ResponseBody
    public BaseResult<?> registerUser(@RequestBody @Valid RegisterDto registerDto) {
        boolean success = userService.registerUser(registerDto);
        if (!success) {
            return new FailResult<>();
        }
        return new SuccessResult<>();
    }

    @GetMapping(params = "userName")
    @ResponseBody
    public UserDto getUser(@RequestParam @NotBlank String userName) {
        return userService.getUser(userName);
    }
    @GetMapping
    @ResponseBody
    public BaseResult<?> getAllUsers() {
        return new SuccessResult<>(userService.getAllUsers());
    }
}
