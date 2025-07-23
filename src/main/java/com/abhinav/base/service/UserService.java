package com.abhinav.base.service;

import com.abhinav.base.dto.UserDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<UserDto> userDtoList = new ArrayList<>();

    public UserService() {
        userDtoList.add(new UserDto(1,"Abhinav","abc@123"));
        userDtoList.add(new UserDto(2,"Ashutosh","def@123"));
        userDtoList.add(new UserDto(3,"Ram","ghi@123"));
    }

    public List<UserDto> getAllUsers() {
        return userDtoList;
    }

    public Boolean addUser(UserDto newUserDto) {
        return userDtoList.add(newUserDto);
    }

    public Boolean deleteUser(Integer id) {
        for(UserDto userDto:userDtoList) {
            if (userDto.id().equals(id)) {
                userDtoList.remove(userDto);
                return true;
            }
        }
        return false;
    }
}
