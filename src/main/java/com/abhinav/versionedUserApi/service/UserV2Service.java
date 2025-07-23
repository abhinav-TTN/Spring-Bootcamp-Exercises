package com.abhinav.versionedUserApi.service;

import com.abhinav.versionedUserApi.dto.UserDtoV1;
import com.abhinav.versionedUserApi.dto.UserDtoV2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserV2Service {

    private final List<UserDtoV2> userDtoList = new ArrayList<>();

    public UserV2Service() {
        userDtoList.add(new UserDtoV2(1,"Abhinav","abc@gmail.com","9919278318"));
        userDtoList.add(new UserDtoV2(2,"Ashutosh","def@gmail.com","1267482318"));
        userDtoList.add(new UserDtoV2(3,"Ram","ghi@gmail.com","8819238198"));
    }

    public List<UserDtoV2> getAllUsers() {
        return userDtoList;
    }
}
