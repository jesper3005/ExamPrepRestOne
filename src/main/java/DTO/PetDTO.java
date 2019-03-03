/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Jesper
 */
public class PetDTO {
    private Integer id;
    private String name;
    private Date birth;
    private String species;
    private Date death;
    private String owner;

    public PetDTO(Integer id, String name, Date birth, String species, Date death, String owner) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.species = species;
        this.death = death;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirth() {
        return birth;
    }

    public String getSpecies() {
        return species;
    }

    public Date getDeath() {
        return death;
    }

    public String getOwner() {
        return owner;
    }
}
