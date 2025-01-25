package com.trippi.trippiApp.repository;

import com.trippi.trippiApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByUserName(String userName);
    List<User> findAllByUserNameContains(String userName);
    User findFirstByUserName(String userName);
    User findFirstByNickName(String nickName);
}
