package com.trippi.trippiApp.controller;

import com.trippi.trippiApp.entity.Language;
import com.trippi.trippiApp.entity.Role;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private Long id;
    private String nickName;
    private String email;
    private String password;
    private String userName;
    private String lastName;
    private String sex;
    private int age;
    private String country;
    private String city;
    private List<Language> languages = new ArrayList<>();
    private String idNumber;
    private String description;
    private List<Role> roles = new ArrayList<>();

}
