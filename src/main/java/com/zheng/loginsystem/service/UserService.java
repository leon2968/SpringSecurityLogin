package com.zheng.loginsystem.service;

import java.util.List;

import com.zheng.loginsystem.dto.UserDto;
import com.zheng.loginsystem.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}