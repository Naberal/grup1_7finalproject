package com.group1_7.finalproject.repository;

import com.group1_7.finalproject.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {

    List<Event> findAllByDateAfter(Date date);
}
