package com.trippi.trippiApp.search;

import com.trippi.trippiApp.entity.User;
import com.trippi.trippiApp.repository.UserRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;

public class UserSpecification {

    private UserRepository userRepository;

    public UserSpecification(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static Specification<User> filterUsers(String nickName, String country) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (nickName != null && !nickName.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("nickName"), nickName));
            }
            if (country != null && !country.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("country"), country));
            }
            if (predicates.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            Predicate person = criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            return person;
        };
    }

    public List<User> searchUsers(String nickName, String country) {
        return userRepository.findAll(UserSpecification.filterUsers(nickName, country));
    }
}