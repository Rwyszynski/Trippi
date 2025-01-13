package com.trippi.trippiApp.service.impl;

import com.trippi.trippiApp.dto.RegistrationDto;
import com.trippi.trippiApp.repository.RoleRepository;
import com.trippi.trippiApp.repository.UserRepository;
import com.trippi.trippiApp.service.UserService;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setUserName(registrationDto.getUserName());
        user.setPassword(registrationDto.getPassword());
        user.setNickName(registrationDto.getNickName());
        user.setEmail(registrationDto.getEmail());
        user.setLastName(registrationDto.getLastName());
        user.setSex(registrationDto.getSex());
        user.setAge(registrationDto.getAge());
        user.setCountry(registrationDto.getCountry());
        user.setCity(registrationDto.getCity());
        user.setLanguages(registrationDto.getLanguages());
        user.setIdNumber(registrationDto.getIdNumber());
        user.setDescription(registrationDto.getDescription());
        Role role = roleRepository.findByRoleName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
