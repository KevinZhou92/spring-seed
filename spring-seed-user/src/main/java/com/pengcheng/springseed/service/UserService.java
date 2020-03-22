package com.pengcheng.springseed.service;

import com.pengcheng.springseed.dao.UserRepository;
import com.pengcheng.springseed.domain.User;
import com.pengcheng.springseed.dto.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean registerUser(RegisterDto registerDto) {
        if (getUserByUserName(registerDto.getUserName()) != null) {
            return false;
        }
        User newUser = new User();
        newUser.setFirstName(registerDto.getFirstName());
        newUser.setLastName(registerDto.getLastName());
        newUser.setUserName(registerDto.getUserName());
        newUser.setPassword(registerDto.getPassword());

        return insertUser(newUser);
    }

    private boolean insertUser(User user) {
        userRepository.saveAndFlush(user);
        return true;
    }

    private User getUserByUserName(String username) {
        return userRepository.findByUserName(username);
    }


}
