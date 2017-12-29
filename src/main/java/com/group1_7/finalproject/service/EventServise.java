package com.group1_7.finalproject.service;

import com.group1_7.finalproject.model.Event;
import com.group1_7.finalproject.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventServise {
    @Autowired
    EventRepository eventRepository;
    public void save(Event event) {
        eventRepository.save(event);
    }

    public void delete(UUID id) {
        eventRepository.delete(id);
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public Event getById(UUID id) {
        return eventRepository.findOne(id);
    }
}
