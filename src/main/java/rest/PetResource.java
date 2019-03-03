/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTO.EventDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.PetFacade;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Jesper
 */
@Path("pet")
public class PetResource {

    @Context
    private UriInfo context;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    PetFacade pf = new PetFacade();

    /**
     * Creates a new instance of PetResource
     */
    public PetResource() {
        pf.addEntityManagerFactory(Persistence.createEntityManagerFactory("pu", null));
    }

    /**
     * Retrieves representation of an instance of rest.PetResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "hello";
    }

    @GET
    @Path("/petcount")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPetCount() {
        return Response.ok().entity(gson.toJson(pf.getAllPets().size())).build();
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPets() {
        return Response.ok().entity(gson.toJson(pf.getAllPetsDTO())).build();
    }

    @GET
    @Path("/allAlive")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAlivePets() {
        return Response.ok().entity(gson.toJson(pf.getAllAlivePets())).build();
    }

    @GET
    @Path("/all/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPetAlive(@PathParam("date") String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date dateObj;

        try {
            dateObj = sdf.parse(date);
        } catch (ParseException ex) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        return Response.ok().entity(gson.toJson(pf.getPetsByEvent(dateObj))).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postCustomer(String content) {
        EventDTO newEvent = gson.fromJson(content, EventDTO.class);
        pf.addEvent(newEvent);
        return Response.ok().entity(newEvent).build();
    }

}
