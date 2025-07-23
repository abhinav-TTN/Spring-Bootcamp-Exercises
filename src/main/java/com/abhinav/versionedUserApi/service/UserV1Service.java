package com.abhinav.versionedUserApi.service;

import com.abhinav.versionedUserApi.dto.UserDtoV1;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserV1Service {

    private final List<UserDtoV1> userDtoList = new ArrayList<>();

    public UserV1Service() {
        userDtoList.add(new UserDtoV1(1,"Abhinav"));
        userDtoList.add(new UserDtoV1(2,"Ashutosh"));
        userDtoList.add(new UserDtoV1(3,"Ram"));
    }

    public List<UserDtoV1> getAllUsers() {
        return userDtoList;
    }
}
