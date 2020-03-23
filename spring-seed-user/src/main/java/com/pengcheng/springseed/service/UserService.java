package com.pengcheng.springseed.service;

import com.pengcheng.springseed.dao.UserRepository;
import com.pengcheng.springseed.domain.User;
import com.pengcheng.springseed.dto.RegisterDto;
import com.pengcheng.springseed.dto.UserDto;
import com.pengcheng.springseed.enums.ServiceEnums;
import com.pengcheng.springseed.exception.ServiceException;
import com.pengcheng.springseed.security.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean registerUser(RegisterDto registerDto) {
        if (getUserByUserName(registerDto.getUserName()) != null) {
            throw new ServiceException(ServiceEnums.USER_EXISTED);
        }

        User newUser = new User();
        newUser.setFirstName(registerDto.getFirstName());
        newUser.setLastName(registerDto.getLastName());
        newUser.setUserName(registerDto.getUserName());
        newUser.setPassword(PasswordUtils.encryptPassword(registerDto.getPassword()));

        return insertUser(newUser);
    }

    private boolean insertUser(User user) throws EntityExistsException {
        try {
            userRepository.saveAndFlush(user);
        } catch (DataAccessException e) {
            throw new EntityExistsException(e.getMessage());
        }

        return true;
    }

    private User getUserByUserName(String username) {
        User user = userRepository.findByUserName(username);
        return user;
    }


    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setUserName(user.getUserName());
            userDto.setEmail(user.getEmail());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            return userDto;
        }).collect(Collectors.toList());
    }

    public UserDto getUser(String userName) {
        try {
            User user = getUserByUserName(userName);
            return user.toUserDto();
        } catch (NullPointerException e) {
            throw new ServiceException(ServiceEnums.USER_NOT_EXISTED);
        }
    }
}
