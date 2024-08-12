package com.wecp.eventmanagementsystem.service;


import com.wecp.eventmanagementsystem.entity.Event;
import com.wecp.eventmanagementsystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event getEventsById(Long eventId) {
        Event e = eventRepository.findById(eventId).orElse(null);
        if(e == null){
            throw new EntityNotFoundException("Event not found!");
        }
        else{
            return e;
        } 
    }

    public Event createEvent(Event event){
        return eventRepository.save(event);
    }

    public Event updateEventById(Long eventId, Event updatedEvent){
        Event e = eventRepository.findById(eventId).orElse(null);

        if(e != null){
            e.setAllocations(updatedEvent.getAllocations());
            e.setDateTime(updatedEvent.getDateTime());
            e.setDescription(updatedEvent.getDescription());
            e.setLocation(updatedEvent.getLocation());
            e.setStatus(updatedEvent.getStatus());
            e.setTitle(updatedEvent.getTitle());
            return e;
        }
        return null;
    }

}
