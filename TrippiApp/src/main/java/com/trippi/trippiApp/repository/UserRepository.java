package com.trippi.trippiApp.repository;

import com.trippi.trippiApp.entity.User;
import com.trippi.trippiApp.search.UserSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUserName(String userName);
    List<User> findAllByUserNameContains(String userName);
    User findFirstByUserName(String userName);
    User findFirstByNickName (String nickName);
    List<User> findAll(Specification<User> userSpecification);

    @Query("SELECT u FROM users u WHERE " +
            "(:nickName IS NULL OR LOWER(u.nickName) LIKE LOWER(CONCAT('%', :nickName, '%'))) " +
            "AND (:country IS NULL OR LOWER(u.country) = LOWER(:country))")
    List<User> searchUsers(@Param("nickName") String nickName, @Param("country") String country);

}
