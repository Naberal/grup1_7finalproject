package com.group1_7.finalproject.rest;

import com.group1_7.finalproject.model.Event;
import com.group1_7.finalproject.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.UUID;

@RestController
@RequestMapping(value ="/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping(value ="/allEvents")
    public LinkedList<Event> events() {
        LinkedList<Event> events = (LinkedList) eventService.getAll();
        return events;
    }

    @GetMapping(value = "/{id}")
    public Event findEvent(@PathVariable UUID id) {
        Event event = eventService.getById(id);
        return event;
    }

    @PostMapping(value ="/createEvent")
    public ResponseEntity saveEvent(@RequestBody Event event) {
        eventService.save(event);
        return new ResponseEntity("Event saved successfully", HttpStatus.OK);
    }

    @PostMapping("/{id}/updateEvent")
    public ResponseEntity updateEvent(@RequestBody Event event, @PathVariable UUID id) {
        Event updateEvent = eventService.getById(id);
        updateEvent.setName(event.getName());
        updateEvent.setDate(event.getDate());
        updateEvent.setTime(event.getTime());
        updateEvent.setType(event.getType());
        eventService.save(updateEvent);
        return new ResponseEntity("Event update successfully", HttpStatus.OK);
    }

    @DeleteMapping(value ="/{id}/deleteEvent")
    public ResponseEntity deleteEvent(@PathVariable UUID id) {
        eventService.delete(id);
        return new ResponseEntity("Event deleted successfully", HttpStatus.OK);
    }
}
