package com.pengcheng.springseed.controller;

import com.pengcheng.springseed.dto.RegisterDto;
import com.pengcheng.springseed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String sayHello() {
        return "Hello World!";
    }

    @PostMapping(path = "/register")
    @ResponseBody
    public String registerUser(@RequestBody @Valid RegisterDto registerDto) {
        boolean success = userService.registerUser(registerDto);
        if (!success) {
            return "Failed";
        }
        return "Success";
    }
}
