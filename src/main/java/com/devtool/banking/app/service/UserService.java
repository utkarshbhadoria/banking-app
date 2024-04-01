package com.devtool.banking.app.service;

import com.devtool.banking.app.dto.UserDto;
import com.devtool.banking.app.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User createuser(User user);


}
