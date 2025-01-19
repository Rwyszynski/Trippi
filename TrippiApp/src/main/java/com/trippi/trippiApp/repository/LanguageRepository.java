package com.trippi.trippiApp.repository;

import com.trippi.trippiApp.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    List<Language> findAll();
}
