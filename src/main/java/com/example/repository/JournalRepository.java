package com.example.repository;

import com.example.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface JournalRepository extends JpaRepository<Journal, Long> {
    List<Journal> findByTitleContains(@Param("title") String title);
}
