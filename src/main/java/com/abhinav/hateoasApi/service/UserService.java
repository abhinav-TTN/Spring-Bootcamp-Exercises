package com.abhinav.hateoasApi.service;

import com.abhinav.hateoasApi.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<UserDto> userDtoList = new ArrayList<>();

    public UserService() {
        userDtoList.add(new UserDto(1,"Abhinav"));
        userDtoList.add(new UserDto(2,"Ashutosh"));
        userDtoList.add(new UserDto(3,"Ram"));
    }

    public List<UserDto> getAllUsers() {
        return userDtoList;
    }

    public UserDto getUserById(int id) {
        return userDtoList.stream()
                .filter(userDto -> userDto.id() == id)
                .findFirst().get();
    }
}
