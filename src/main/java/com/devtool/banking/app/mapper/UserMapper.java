package com.devtool.banking.app.mapper;

import com.devtool.banking.app.dto.UserDto;
import com.devtool.banking.app.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserMapper {
    public UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getEmail(),
                user.getPassword()
        );

        return userDto;
    }

    public User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getEmail(),
                userDto.getPassword()
        );

        return user;
    }
}
