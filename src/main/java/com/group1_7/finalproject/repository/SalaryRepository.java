package com.group1_7.finalproject.repository;

import com.group1_7.finalproject.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.UUID;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {
    Salary findByDateAfterAndWorkerId(Date date, UUID id);
}
