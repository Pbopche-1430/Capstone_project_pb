package com.wecp.eventmanagementsystem.entity;
 
import javax.persistence.*;
 
@Entity
@Table(name = "allocations") // do not change table name
public class Allocation {
    // implement entity
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alloctionID;
    private int quantity;
 
    @ManyToOne
    private Event event;

    @ManyToOne
    private Resource resource;
  
    public Allocation() {
    }
 
    public Allocation(Event event, Resource resource, int quantity) {
        this.event = event;
        this.resource = resource;
        this.quantity = quantity;
    }
 
    public Long getAlloctionID() {
        return alloctionID;
    }
    public void setAlloctionID(Long alloctionID) {
        this.alloctionID = alloctionID;
    }
    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }
    public Resource getResource() {
        return resource;
    }
    public void setResource(Resource resource) {
        this.resource = resource;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
   
}