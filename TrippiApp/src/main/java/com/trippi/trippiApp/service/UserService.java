package com.trippi.trippiApp.service;

import com.trippi.trippiApp.dto.RegistrationDto;
import com.trippi.trippiApp.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    User findByEmail(String email);
    User findByUsername(String username);
    List<User> searchUsers(String nickname, String country);

}
