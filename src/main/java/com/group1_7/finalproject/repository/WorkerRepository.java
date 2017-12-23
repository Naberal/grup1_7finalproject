package com.group1_7.finalproject.repository;

import com.group1_7.finalproject.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkerRepository extends JpaRepository<Worker,UUID> {
}
