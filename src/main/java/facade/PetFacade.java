/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import DTO.EventDTO;
import DTO.PetDTO;
import entity.Event;
import entity.Pet;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jesper
 */
public class PetFacade {

    EntityManagerFactory emf;

    public PetFacade() {
    }

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Pet> getAllPets() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Pet.findAll", Pet.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<PetDTO> getAllPetsDTO() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("PetDTO.findAll", PetDTO.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<PetDTO> getAllAlivePets() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("PetDTO.findAllAlive", PetDTO.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<PetDTO> getPetsByEvent(Date date) {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("EventDTO.findByPetsByDate").setParameter("date", date).getResultList();
    }
    
    public EventDTO addEvent(EventDTO event) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(event);
            em.getTransaction().commit();
            return event;
        } finally {
            em.close();
        }
    }
    
    
    
    

}
