package com.devtool.banking.app.service.impl;

import com.devtool.banking.app.dto.UserDto;
import com.devtool.banking.app.entity.User;
import com.devtool.banking.app.mapper.UserMapper;
import com.devtool.banking.app.repository.UserRepository;
import com.devtool.banking.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public User createuser(User user) {

        User saved = userRepository.save(user);

        return saved;


    }
}
