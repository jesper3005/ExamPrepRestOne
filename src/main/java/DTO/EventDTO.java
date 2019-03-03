/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entity.Pet;
import java.util.Date;

/**
 *
 * @author Jesper
 */
public class EventDTO {
    
    private Integer id;
    private String event;
    private String remark;
    private Date date;
    private Pet pet;

    public EventDTO(Integer id, String event, String remark, Date date, Pet pet) {
        this.id = id;
        this.event = event;
        this.remark = remark;
        this.date = date;
        this.pet = pet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    
    
}
