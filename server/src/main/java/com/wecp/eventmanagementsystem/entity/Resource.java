package com.wecp.eventmanagementsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "resources") // do not change table name
public class Resource {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceID;
    private String name;
    private String type;
    private Boolean availability;

    public Resource() {}

    public Resource(Long resourceID, String name, String type, Boolean availability) {
        this.resourceID = resourceID;
        this.name = name;
        this.type = type;
        this.availability = availability;
    }

    public Long getResourceID() {
        return resourceID;
    }

    public void setResourceID(Long resourceID) {
        this.resourceID = resourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean isAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    // implement entity
}