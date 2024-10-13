package com.example.csv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.csv.model.LogFile;

public interface CSVRepository extends JpaRepository<LogFile, Long> {
}
