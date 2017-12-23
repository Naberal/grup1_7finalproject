package com.group1_7.finalproject.repository;

import com.group1_7.finalproject.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event,UUID> {
}
